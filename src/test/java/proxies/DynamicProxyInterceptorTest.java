package proxies;

import annotations.Transaction;
import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.UserPermissions;
import utils.UserRoles;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

class DynamicProxyInterceptorTest {
    proxies.Proxy proxy;

    @Test
    void shouldSaveAUserViaDynamicProxy() throws NoSuchMethodException {
        // given
        UserDao dao = new UserDaoImpl();
        InvocationHandler handler = new DynamicProxyInterceptor(dao);
        User user = new User("Teste", UserRoles.ADMINISTRATOR, UserPermissions.MODERATION);
        proxy = new proxies.Proxy((UserDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[]{UserDao.class}, handler));

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