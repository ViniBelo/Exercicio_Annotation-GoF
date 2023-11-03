package permissions;

import utils.UserPermissions;

public class CommonPermissions implements Permissions{
    @Override
    public UserPermissions define() {
        System.out.println("Common user can make and comment posts.");
        return UserPermissions.BASIC;
    }
}
