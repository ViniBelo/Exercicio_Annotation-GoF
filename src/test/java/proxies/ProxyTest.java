package proxies;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.UserPermissions;
import utils.UserRoles;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProxyTest {

    static UserDao dao;

    Proxy proxy;

    @BeforeAll
    static void beforeAll() {
        dao = new UserDaoStub();
    }


    @Test
    void save() {
        // given
        User user = new User("Teste", UserRoles.ADMINISTRATOR, UserPermissions.MODERATION);
        proxy = new Proxy(dao);

        // then
        User savedUser = proxy.save(user);

        // assert
        assertEquals(savedUser, user);
    }
}