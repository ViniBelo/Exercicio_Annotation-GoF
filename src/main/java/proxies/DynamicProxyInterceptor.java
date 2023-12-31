package proxies;

import annotations.Transaction;
import dao.UserDao;
import domain.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyInterceptor implements InvocationHandler {
    private final UserDao dao;

    public DynamicProxyInterceptor(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method daoImplMethod = dao.getClass().getMethod("save", User.class);
        if (daoImplMethod.isAnnotationPresent(Transaction.class)) {
            try {
                System.out.println("Iniciando execução do método " +
                        method.getName() +
                        "." +
                        method.getDeclaringClass().getName());
                var savedUser = method.invoke(dao, args);
                System.out.println("Finalizando execução do método " +
                        method.getName() +
                        "." +
                        method.getDeclaringClass().getName() +
                        " com sucesso");
                return savedUser;
            } catch (Exception e) {
                System.err.println("Finalizando execução do método " +
                        method.getName() +
                        "." +
                        method.getDeclaringClass().getName() +
                        " com erro");
                System.out.println("Rolling back transaction...");
            }
        }
        return method.invoke(dao, args);
    }
}
