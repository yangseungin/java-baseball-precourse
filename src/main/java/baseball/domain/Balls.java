package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balls {
    private final List<Ball> list;
    private static final int BALLS_SIZE = 3;

    public Balls(List<Integer> numbers) {
        if (numbers.size() != BALLS_SIZE) {
            throw new IllegalArgumentException("야구공은 3개여야 합니다.");
        }

        if (numbers.get(0).equals(numbers.get(1)) || numbers.get(0).equals(numbers.get(2)) || numbers.get(1).equals(numbers.get(2))) {
            throw new IllegalArgumentException("야구공은 서로 다른 숫자를 가져야 합니다.");
        }

        List<Ball> newBalls = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            newBalls.add(new Ball(i, numbers.get(i)));
        }

        this.list = newBalls;
    }

    public List<Ball> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls = (Balls) o;
        return Objects.equals(list, balls.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
