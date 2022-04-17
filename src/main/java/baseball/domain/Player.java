package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Balls balls;

    public Balls createBalls(String input) {
        validInput(input);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(input.charAt(i) - '0');
        }

        return new Balls(numbers);
    }

    private void validInput(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("3개의 야구공이어야 합니다.");
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
