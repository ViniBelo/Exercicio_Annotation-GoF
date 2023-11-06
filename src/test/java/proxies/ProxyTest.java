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

    Proxy proxy;

    @Test
    void shouldSaveAUserViaPatternProxy() {
        // given
        User user = new User("Teste", UserRoles.ADMINISTRATOR, UserPermissions.MODERATION);
        UserDao dao = new UserDaoImpl();
        proxy = new Proxy(dao);

        // when
        User savedUser = proxy.save(user);

        // then
        assertEquals(savedUser, user);
    }

    @Test
    void shouldDetectTransactionAnnotationAtSaveMethod() throws NoSuchMethodException {
        // given
        UserDao dao = new UserDaoImpl();
        Method method = dao.getClass().getMethod("save", User.class);

        // when

        // then
        assertTrue(method.isAnnotationPresent(Transaction.class));
    }
}