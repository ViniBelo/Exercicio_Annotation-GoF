package factories;

import permissions.Permissions;
import roles.Role;

public interface UserFactory {
    Role defineRole();
    Permissions definePermission();
}
