package factories;

import permissions.AdminPermissions;
import permissions.Permissions;
import roles.AdminRole;
import roles.Role;

public class AdminFactory implements UserFactory{
    @Override
    public Role defineRole() {
        return new AdminRole();
    }

    @Override
    public Permissions definePermission() {
        return new AdminPermissions();
    }
}
