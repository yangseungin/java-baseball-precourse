package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @DisplayName("3개의 공을 가진 컴퓨터 생성")
    @ParameterizedTest
    @CsvSource({"1, 2, 3", "4, 5, 6"})
    void create_computer(int num1, int num2, int num3) {
        List<Integer> numbers = Arrays.asList(num1, num2, num3);
        Game game = new Game(numbers);

        assertThat(game.getBalls()).isEqualTo(new Balls(numbers));
    }

}
