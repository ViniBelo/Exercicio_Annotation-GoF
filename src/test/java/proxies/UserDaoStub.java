package proxies;

import annotations.Transaction;
import dao.UserDao;
import domain.User;

public class UserDaoStub implements UserDao {
    @Override
    @Transaction
    public User save(User user) {
        System.out.println("Saving user.");
        return user;
    }
}
