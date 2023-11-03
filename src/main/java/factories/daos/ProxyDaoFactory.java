package factories.daos;

import dao.UserDao;
import dao.UserDaoImpl;
import proxies.Proxy;

public class ProxyDaoFactory implements DaoFactory{
    @Override
    public UserDao getDao() {
        UserDao dao = new UserDaoImpl();
        return new Proxy(dao);
    }
}
