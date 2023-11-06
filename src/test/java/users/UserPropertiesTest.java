package users;

import domain.User;
import factories.users.AdminFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.UserPermissions;
import utils.UserRoles;

import static org.junit.jupiter.api.Assertions.*;

class UserPropertiesTest {

    UserProperties properties;

    @Test
    void createUsingAllAdministratorInformation() {
        // given
        User user = new User("Teste", UserRoles.ADMINISTRATOR, UserPermissions.MODERATION);
        properties = new UserProperties(new AdminFactoryStub());

        // then
        User savedUser = properties.create("Teste");

        // assert
        assertEquals(savedUser.getRole(), user.getRole());
        assertEquals(savedUser.getPermissions(), user.getPermissions());
        assertEquals(savedUser.getName(), user.getName());
    }

    @Test
    void createUsingAllCommonInformation() {
        // given
        User user = new User("Teste", UserRoles.COMMON, UserPermissions.BASIC);
        properties = new UserProperties(new CommonFactoryStub());

        // then
        User savedUser = properties.create("Teste");

        // assert
        assertEquals(savedUser.getRole(), user.getRole());
        assertEquals(savedUser.getPermissions(), user.getPermissions());
        assertEquals(savedUser.getName(), user.getName());
    }

    @Test
    void createUsingAdministratorRoleAndBasicPermissionsWithAdminFactory() {
        // given
        User user = new User("Teste", UserRoles.ADMINISTRATOR, UserPermissions.BASIC);
        properties = new UserProperties(new AdminFactoryStub());

        // then
        User savedUser = properties.create("Teste");

        // assert
        assertEquals(savedUser.getRole(), user.getRole());
        assertNotEquals(savedUser.getPermissions(), user.getPermissions());
        assertEquals(savedUser.getName(), user.getName());
    }

    @Test
    void createUsingAdministratorRoleAndBasicPermissionsWithCommonFactory() {
        // given
        User user = new User("Teste", UserRoles.ADMINISTRATOR, UserPermissions.BASIC);
        properties = new UserProperties(new CommonFactoryStub());

        // then
        User savedUser = properties.create("Teste");

        // assert
        assertNotEquals(savedUser.getRole(), user.getRole());
        assertEquals(savedUser.getPermissions(), user.getPermissions());
        assertEquals(savedUser.getName(), user.getName());
    }

    @Test
    void createUsingCommonRoleAndModerationPermissionsWithAdminFactory() {
        // given
        User user = new User("Teste", UserRoles.COMMON, UserPermissions.MODERATION);
        properties = new UserProperties(new AdminFactoryStub());

        // then
        User savedUser = properties.create("Teste");

        // assert
        assertNotEquals(savedUser.getRole(), user.getRole());
        assertEquals(savedUser.getPermissions(), user.getPermissions());
        assertEquals(savedUser.getName(), user.getName());
    }

    @Test
    void createUsingCommonRoleAndModerationPermissionsWithCommonFactory() {
        // given
        User user = new User("Teste", UserRoles.COMMON, UserPermissions.MODERATION);
        properties = new UserProperties(new AdminFactoryStub());

        // then
        User savedUser = properties.create("Teste");

        // assert
        assertNotEquals(savedUser.getRole(), user.getRole());
        assertEquals(savedUser.getPermissions(), user.getPermissions());
        assertEquals(savedUser.getName(), user.getName());
    }
}