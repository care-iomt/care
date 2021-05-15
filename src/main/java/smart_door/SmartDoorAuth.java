package smart_door;

public class SmartDoorAuth {
    private final SmartDoorPermission smartDoorPermission;

    public SmartDoorAuth(SmartDoorPermission smartDoorPermission) {
        this.smartDoorPermission = smartDoorPermission;
    }

    public SmartDoorPermission getPermission() {
        return smartDoorPermission;
    }
}
