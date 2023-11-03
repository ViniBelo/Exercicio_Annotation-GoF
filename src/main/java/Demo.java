import factories.AdminFactory;
import factories.CommonFactory;
import factories.UserFactory;
import users.UserProperties;

public class Demo {
    public static UserProperties configureUser() {
        UserProperties userProperties;
        UserFactory factory;

        factory = new CommonFactory();
        userProperties = new UserProperties(factory);
        return userProperties;
    }

    public static void main(String[] args) {
        UserProperties userProperties = configureUser();
        userProperties.create();
    }
}
