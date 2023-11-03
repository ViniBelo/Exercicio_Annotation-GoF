package users;

import factories.UserFactory;
import permissions.Permissions;
import roles.Role;

public class UserProperties {
    private Role role;
    private Permissions permissions;

    public UserProperties(UserFactory factory) {
        role = factory.defineRole();
        permissions = factory.definePermission();
    }

    public void create() {
        role.define();
        permissions.define();
    }

    public Role getRole() {
        return role;
    }

    public Permissions getPermissions() {
        return permissions;
    }
}
