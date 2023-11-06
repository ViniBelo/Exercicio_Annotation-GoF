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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DynamicProxyInterceptorTest {

    static UserDao dao;

    static InvocationHandler handler;

    proxies.Proxy proxy;

    @BeforeAll
    static void beforeAll() {
        dao = new UserDaoStub();
        UserDao dao = new UserDaoImpl();
        handler = new DynamicProxyInterceptor(dao);
    }

    @Test
    void invoke() throws NoSuchMethodException {
        // given
        User user = new User("Teste", UserRoles.ADMINISTRATOR, UserPermissions.MODERATION);
        proxy = new proxies.Proxy((UserDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[]{UserDao.class}, handler));
        Method method = dao.getClass().getMethod("save", User.class);

        // then
        User savedUser = proxy.save(user);

        // assert
        assertEquals(savedUser, user);
        assertTrue(method.isAnnotationPresent(Transaction.class));
    }
}