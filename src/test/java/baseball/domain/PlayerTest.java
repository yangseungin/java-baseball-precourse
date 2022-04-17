package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234"})
    void createBalls(String input) {
        Player player = new Player();

        Balls playerBalls = player.createBalls(input);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(input.charAt(i) - '0');
        }

        assertThat(playerBalls).
                isEqualTo(new Balls(numbers));
    }

    @DisplayName("플레이어의 입력의 길이는 3이여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "23"})
    void invalid_input_length(String input) {
        Player player = new Player();
        assertThatThrownBy(() -> player.createBalls(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의 야구공이어야 합니다.");
    }

    @DisplayName("야구공은 3개여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1t4", "ab3"})
    void input_shoud_only_be_string(String input) {
        Player player = new Player();
        assertThatThrownBy(() -> player.createBalls(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

}
