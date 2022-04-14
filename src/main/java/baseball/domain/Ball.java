package baseball.domain;

import java.util.Objects;

public class Ball {
    private final int position;
    private final Number number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = new Number(number);
    }

    public CompareStatus compare(Ball ball) {
        if (this.equals(ball)) {
            return CompareStatus.STRIKE;
        }
        if (this.number.equals(ball.number)) {
            return CompareStatus.BALL;
        }
        return CompareStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && Objects.equals(number, ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
