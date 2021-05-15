package smart_door;

import java.util.List;

public class SmartDoorImpl implements SmartDoor {
    private final List<Permission> permissions;
    private final String sector;

    public SmartDoorImpl(List<Permission> permissions, String sector) {
        this.permissions = permissions;
        this.sector = sector;
    }

    @Override
    public boolean auth(Auth auth) {
        return permissions.stream()
                .anyMatch(permission -> permission.getValue() == auth.getPermission().getValue());
    }
}
