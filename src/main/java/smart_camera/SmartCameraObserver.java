package smart_camera;

import data_center.entities.Person;

public interface SmartCameraObserver {
    void alert(String sector, Person person);
}
