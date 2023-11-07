package dao;

import annotations.Transaction;
import domain.User;

public class UserDaoImpl implements UserDao{
    @Override
    @Transaction
    public User save(User user) {
        if (!user.equals(null)) {
            System.out.println("Saving user.");
        } else {
            System.err.println("Null value!");
            throw new NullPointerException();
        }
        return user;
    }
}
