package smart_door;

import java.util.ArrayList;

public class SmartDoorImpl implements SmartDoor {
    private final String sector;
    private SmartDoorConfig smartDoorConfig;

    public SmartDoorImpl(String sector) {
        this.smartDoorConfig = new SmartDoorConfig(new ArrayList<>(), "None");
        this.sector = sector;
    }

    @Override
    public boolean auth(SmartDoorAuth smartDoorAuth) {
        return smartDoorConfig.getPermissions().stream()
                .anyMatch(permission -> permission.getValue() == smartDoorAuth.getPermission().getValue());
    }

    @Override
    public void configure(SmartDoorConfig smartDoorConfig) {
        this.smartDoorConfig = smartDoorConfig;
    }
}
