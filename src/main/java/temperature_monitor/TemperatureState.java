package temperature_monitor;

public class TemperatureState {
    private Integer temperature;

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return String.valueOf(temperature);
    }
}
