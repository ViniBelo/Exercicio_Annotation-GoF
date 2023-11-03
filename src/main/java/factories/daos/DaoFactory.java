package factories.daos;

import dao.UserDao;

public interface DaoFactory {
    UserDao getDao();
}
