package baseball.domain;

import java.util.List;

public class Computer {
    private final Balls balls;

    public Computer(List<Integer> numbers) {
        this.balls = new Balls(numbers);
    }

    public Balls getBalls() {
        return balls;
    }
}
