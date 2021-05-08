package heart_rate;

public enum AlertType {
    MAX(1),
    MIN(2);

    private int value;

    AlertType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
