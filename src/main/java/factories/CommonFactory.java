package factories;

import permissions.CommonPermissions;
import permissions.Permissions;
import roles.CommonRole;
import roles.Role;

public class CommonFactory implements UserFactory{
    @Override
    public Role defineRole() {
        return new CommonRole();
    }

    @Override
    public Permissions definePermission() {
        return new CommonPermissions();
    }
}
