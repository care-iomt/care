package smart_door;

public class Auth {
    private final Permission permission;

    public Auth(Permission permission) {
        this.permission = permission;
    }

    public Permission getPermission() {
        return permission;
    }
}
