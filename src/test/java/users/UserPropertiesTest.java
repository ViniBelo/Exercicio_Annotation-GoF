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

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void createUsingAllAdministratorInformation() {
        // given
        User user = new User("Teste", UserRoles.ADMINISTRATOR, UserPermissions.MODERATION);
        properties = new UserProperties(new AdminFactoryStub());

        // then
        User savedUser = properties.create("Teste");

        // assert
        assertEquals(savedUser, user);
    }
}