package smart_door;

public class Auth {
    private final Long permission;

    public Auth(Long permission) {
        this.permission = permission;
    }

    public Long getPermission() {
        return permission;
    }
}
