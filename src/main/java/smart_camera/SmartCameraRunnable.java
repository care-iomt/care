package smart_camera;

import data_center.DataCenterConnection;
import data_center.entities.Person;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class SmartCameraRunnable implements Runnable {
    private final List<SmartCameraObserver> observers;
    private final DataCenterConnection dataCenterConnection;
    private final SmartCameraConfig config;
    private boolean isRunning;

    public SmartCameraRunnable(List<SmartCameraObserver> observers, SmartCameraConfig config) {
        this.observers = observers;
        this.config = config;
        dataCenterConnection = DataCenterConnection.getInstance();
        isRunning = true;
    }

    public void kill() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Optional<Person> personOptional = detectPersonWithoutMask();
                personOptional.ifPresent(person -> observers
                        .forEach(observer -> observer.alert(config.getSector(), person)));
                Thread.sleep(5000);
            } catch (InterruptedException ignored) { }
        }
    }

    private Optional<Person> detectPersonWithoutMask() {
        boolean personDetected = ((int) (Math.random() * 31)) == 1;
        if (personDetected) {
            final Random rand = new Random();
            final List<Person> people = dataCenterConnection.getPersonController().getAll();
            return Optional.of(people.get(rand.nextInt(people.size())));
        }
        return Optional.empty();
    }
}
