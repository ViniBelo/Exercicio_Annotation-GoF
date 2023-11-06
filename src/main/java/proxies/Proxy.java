package proxies;

import annotations.Transaction;
import dao.UserDao;
import domain.User;

import java.lang.reflect.Method;

public class Proxy implements UserDao {
    private final UserDao dao;

    public Proxy(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User save(User user) {
        try {
            Method method = dao.getClass().getMethod("save", User.class);
            if (method.isAnnotationPresent(Transaction.class)) {
                try {
                    System.out.println("Iniciando execução do método " +
                            method.getName() +
                            "." +
                            method.getDeclaringClass().getName());
                    var savedUser = dao.save(user);
                    System.out.println("Finalizando execução do método " +
                            method.getName() +
                            "." +
                            method.getDeclaringClass().getName() +
                            " com sucesso");
                    return savedUser;
                } catch (Exception e) {
                    System.out.println("Finalizando execução do método " +
                            method.getName() +
                            "." +
                            method.getDeclaringClass().getName() +
                            " com erro");
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return dao.save(user);
    }
}
