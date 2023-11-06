package proxies;

import annotations.Transaction;
import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.UserPermissions;
import utils.UserRoles;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProxyTest {

    static UserDao dao;

    Proxy proxy;

    @BeforeAll
    static void beforeAll() {
        dao = new UserDaoStub();
    }

    @Test
    void save() throws NoSuchMethodException {
        // given
        User user = new User("Teste", UserRoles.ADMINISTRATOR, UserPermissions.MODERATION);
        Method method = dao.getClass().getMethod("save", User.class);
        proxy = new Proxy(dao);

        // then
        User savedUser = proxy.save(user);

        // assert
        assertEquals(savedUser, user);
        assertTrue(method.isAnnotationPresent(Transaction.class));
    }
}