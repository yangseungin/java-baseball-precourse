package baseball.domain;

public enum GameEndStatus {
    RESTART("1"), END("2");

    private final String value;

    GameEndStatus(String input) {
        this.value = input;
    }

    public String getValue() {
        return value;
    }
}
