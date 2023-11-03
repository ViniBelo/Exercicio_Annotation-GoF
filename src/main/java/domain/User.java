package domain;

import utils.UserPermissions;
import utils.UserRoles;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final UUID id;
    private String name;
    private final UserRoles role;
    private final UserPermissions permissions;

    public User(String name, UserRoles role, UserPermissions permissions) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.role = role;
        this.permissions = permissions;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRoles getRole() {
        return role;
    }

    public UserPermissions getPermissions() {
        return permissions;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        User user = (User) object;

        if (!id.equals(user.id)) return false;
        if (!Objects.equals(name, user.name)) return false;
        if (role != user.role) return false;
        return permissions == user.permissions;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (permissions != null ? permissions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", permissions=" + permissions +
                '}';
    }
}
