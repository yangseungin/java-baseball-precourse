package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("0부터 2까지의 위치는 허용된다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void allowed_position(int value) {
        assertThat(new Position(value).getValue()).isEqualTo(value);
    }

    @DisplayName("0부터 2 이외의 위치값은 허용되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {-10, 10})
    void not_allowed_position(int value) {
        assertThatThrownBy(() -> new Position(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("위치는 0부터 2사이어야 합니다.");
    }

    @DisplayName("위치 비교는 equals로 동등성을 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void equals(int value) {
        assertThat(new Position(value)).isEqualTo(new Position(value));
    }

}
