package smart_door;

import java.util.List;

public class SmartDoorConfig {
    private final List<SmartDoorPermission> smartDoorPermissions;
    private final String sector;

    public SmartDoorConfig(List<SmartDoorPermission> smartDoorPermissions, String sector) {
        this.smartDoorPermissions = smartDoorPermissions;
        this.sector = sector;
    }

    public List<SmartDoorPermission> getPermissions() {
        return smartDoorPermissions;
    }

    public String getSector() {
        return sector;
    }
}
