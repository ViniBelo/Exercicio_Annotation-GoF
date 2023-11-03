package factories.daos;

import dao.UserDao;
import dao.UserDaoImpl;
import proxies.DynamicProxyInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyDaoFactory implements DaoFactory{
    @Override
    public UserDao getDao() {
        UserDao dao = new UserDaoImpl();
        InvocationHandler handler = new DynamicProxyInterceptor(dao);
        return (UserDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[]{UserDao.class}, handler);
    }
}
