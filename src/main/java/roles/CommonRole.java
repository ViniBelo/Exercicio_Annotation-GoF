package roles;

import utils.UserRoles;

public class CommonRole implements Role{
    @Override
    public UserRoles define() {
        System.out.println("The new user is common.");
        return UserRoles.COMMON;
    }
}
