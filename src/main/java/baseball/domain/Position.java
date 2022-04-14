package baseball.domain;

import java.util.Objects;

public class Position {
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 2;

    private final int value;

    public Position(int value) {
        if (value < MIN_POSITION || value > MAX_POSITION) {
            throw new IllegalArgumentException("위치는 0부터 2사이어야 합니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return getValue() == position.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
