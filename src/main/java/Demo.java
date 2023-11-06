import factories.daos.DaoFactoryProvider;
import factories.users.AdminFactory;
import factories.users.CommonFactory;
import factories.users.UserFactory;
import users.UserProperties;
import utils.FactoryTypes;

import java.util.Scanner;

public class Demo {
    public static UserProperties configureUser() {
        UserProperties userProperties;
        UserFactory factory;

        var scanner = new Scanner(System.in);

        if (scanner.nextLine().equalsIgnoreCase("admin")) {
            factory = new AdminFactory();
        } else {
            factory = new CommonFactory();
        }
        userProperties = new UserProperties(factory);
        return userProperties;
    }

    public static void main(String[] args) {
        UserProperties userProperties = configureUser();
        var proxy = DaoFactoryProvider.getDaoFactory(FactoryTypes.DYNAMIC);
        System.out.println(proxy.getDao().save(userProperties.create("Matheus")));
    }
}
