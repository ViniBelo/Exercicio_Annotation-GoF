package dao;

import annotations.Transaction;
import domain.User;

public class UserDaoImpl implements UserDao{
    @Override
    @Transaction
    public User save(User user) {
        System.out.println("Saving user.");
        return user;
    }
}
