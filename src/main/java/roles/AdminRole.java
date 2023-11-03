package roles;

import utils.UserRoles;

public class AdminRole implements Role{
    @Override
    public UserRoles define() {
        System.out.println("The new user is administrator.");
        return UserRoles.ADMINISTRATOR;
    }
}
