package users;

import domain.User;
import factories.users.UserFactory;
import permissions.Permissions;
import roles.Role;

public class UserProperties {

    private Role role;
    private Permissions permissions;

    public UserProperties(UserFactory factory) {
        role = factory.defineRole();
        permissions = factory.definePermission();
    }

    public User create(String name) {
        return new User(name, role.define(), permissions.define());
    }

    public Role getRole() {
        return role;
    }

    public Permissions getPermissions() {
        return permissions;
    }
}
