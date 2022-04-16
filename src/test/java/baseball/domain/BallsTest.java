package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {
    @DisplayName("정상적인 공 생성")
    @ParameterizedTest
    @CsvSource({"1, 2, 3", "4, 5, 6"})
    void correct_ball(int num1, int num2, int num3) {
        Balls balls = new Balls(Arrays.asList(num1, num2, num3));
        assertThat(balls.getList()).isEqualTo(Arrays.asList(new Ball(0, num1), new Ball(1, num2), new Ball(2, num3)));
    }

    @DisplayName("야구공들은 겹치는 숫자를 가질 수 없다.")
    @ParameterizedTest
    @CsvSource({"1, 2, 2", "4, 4, 4"})
    void no_duplicate_numbers(int num1, int num2, int num3) {
        assertThatThrownBy(() -> new Balls(Arrays.asList(num1, num2, num3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("야구공은 서로 다른 숫자를 가져야 합니다.");
    }

    @DisplayName("야구공은 3개여야 한다.")
    @Test
    void number_of_balls_must_be_three() {
        assertThatThrownBy(() -> new Balls(Arrays.asList(1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("야구공은 3개여야 합니다.");
    }
}
