package baseball.Utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    private static final int NUMBER_SIZE = 3;

    @DisplayName("랜덤으로 생성된 숫자의 크기는 3이고 중복되지 않아야하고 범위가 1~9이여야 한다.")
    @RepeatedTest(100)
    void create_number_between_1_and_9() {
        List<Integer> randomNumbers = RandomNumberGenerator.generate();

        assertThat(randomNumbers).hasSize(NUMBER_SIZE);
        assertThat(randomNumbers).doesNotHaveDuplicates();
        assertThat(randomNumbers).filteredOn(number -> number > 0 && number < 10).size()
                .isEqualTo(NUMBER_SIZE);
    }
}
