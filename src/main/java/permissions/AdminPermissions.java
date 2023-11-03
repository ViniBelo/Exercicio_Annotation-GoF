package permissions;

import utils.UserPermissions;

public class AdminPermissions implements Permissions{
    @Override
    public UserPermissions define() {
        System.out.println("Admin user can change other users.");
        return UserPermissions.MODERATION;
    }
}
