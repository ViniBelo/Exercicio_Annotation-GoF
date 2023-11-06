package users;

import domain.User;
import factories.users.AdminFactory;
import factories.users.CommonFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.UserPermissions;
import utils.UserRoles;

import static org.junit.jupiter.api.Assertions.*;

class UserPropertiesTest {

    UserProperties properties;

    @Test
    void mustCreateAAdminUserUsingAdminFactory() {
        // given
        User user = new User("Teste", UserRoles.ADMINISTRATOR, UserPermissions.MODERATION);
        properties = new UserProperties(new AdminFactory());

        // when
        User savedUser = properties.create("Teste");

        // then
        assertEquals(savedUser.getRole(), user.getRole());
        assertEquals(savedUser.getPermissions(), user.getPermissions());
        assertEquals(savedUser.getName(), user.getName());
    }

    @Test
    void mustCreateACommonUserUsingCommonFactory() {
        // given
        User user = new User("Teste", UserRoles.COMMON, UserPermissions.BASIC);
        properties = new UserProperties(new CommonFactory());

        // when
        User savedUser = properties.create("Teste");

        // then
        assertEquals(savedUser.getRole(), user.getRole());
        assertEquals(savedUser.getPermissions(), user.getPermissions());
        assertEquals(savedUser.getName(), user.getName());
    }

    @Test
    void shouldHaveDifferentRolesUsingAdministratorRoleAndBasicPermissionsWithCommonFactory() {
        // given
        User user = new User("Teste", UserRoles.ADMINISTRATOR, UserPermissions.BASIC);
        properties = new UserProperties(new CommonFactory());

        // when
        User savedUser = properties.create("Teste");

        // then
        assertNotEquals(savedUser.getRole(), user.getRole());
        assertEquals(savedUser.getPermissions(), user.getPermissions());
        assertEquals(savedUser.getName(), user.getName());
    }

    @Test
    void shouldHaveDifferentRolesUsingCommonRoleAndModerationPermissionsWithAdminFactory() {
        // given
        User user = new User("Teste", UserRoles.COMMON, UserPermissions.MODERATION);
        properties = new UserProperties(new AdminFactory());

        // when
        User savedUser = properties.create("Teste");

        // then
        assertNotEquals(savedUser.getRole(), user.getRole());
        assertEquals(savedUser.getPermissions(), user.getPermissions());
        assertEquals(savedUser.getName(), user.getName());
    }

    @Test
    void shouldHaveDifferentPermissionsUsingAdministratorRoleAndBasicPermissionsWithAdminFactory() {
        // given
        User user = new User("Teste", UserRoles.ADMINISTRATOR, UserPermissions.BASIC);
        properties = new UserProperties(new AdminFactory());

        // when
        User savedUser = properties.create("Teste");

        // then
        assertEquals(savedUser.getRole(), user.getRole());
        assertNotEquals(savedUser.getPermissions(), user.getPermissions());
        assertEquals(savedUser.getName(), user.getName());
    }

    @Test
    void shouldHaveDifferentPermissionsUsingCommonRoleAndModerationPermissionsWithCommonFactory() {
        // given
        User user = new User("Teste", UserRoles.COMMON, UserPermissions.MODERATION);
        properties = new UserProperties(new CommonFactory());

        // when
        User savedUser = properties.create("Teste");

        // then
        assertEquals(savedUser.getRole(), user.getRole());
        assertNotEquals(savedUser.getPermissions(), user.getPermissions());
        assertEquals(savedUser.getName(), user.getName());
    }
}