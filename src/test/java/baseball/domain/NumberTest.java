package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("1부터 9까지의 수는 허용된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void allowed_numbers(int value) {
        assertThat(new Number(value).getValue()).isEqualTo(value);
    }

    @DisplayName("1부터 9까지의 수 이외의 값은 허용되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 10})
    void not_allowed_numbers(int value) {
        assertThatThrownBy(() -> new Number(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 1부터 9까지의 수만 허용됩니다.");
    }

    @DisplayName("숫자 비교는 equals로 동등성을 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void equals(int value) {
        assertThat(new Number(value)).isEqualTo(new Number(value));
    }
}
