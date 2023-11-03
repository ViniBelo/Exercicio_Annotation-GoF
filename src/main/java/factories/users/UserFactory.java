package factories.users;

import permissions.Permissions;
import roles.Role;

public interface UserFactory {
    Role defineRole();
    Permissions definePermission();
}
