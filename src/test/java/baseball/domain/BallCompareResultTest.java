package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BallCompareResultTest {

    @DisplayName("스트라이크가 3개면 true 리턴")
    @Test
    void isAllStrike() {
        BallCompareResult result = new BallCompareResult();
        result.setStrikeCount(3);

        assertTrue(result.isAllStrike());
    }

    @DisplayName("들어온 볼과 스트라이크 수만큼 값을 증가시킨다.")
    @Test
    void recode() {
        BallCompareResult result = new BallCompareResult();
        int repeat = 3;
        for (int i = 0; i < repeat; i++) {
            result.recode(CompareStatus.BALL);
            result.recode(CompareStatus.STRIKE);
        }

        assertThat(result.getStrikeCount()).isEqualTo(repeat);
        assertThat(result.getBallCount()).isEqualTo(repeat);
    }

    @DisplayName("볼과 스트라이크가 모두 존재하는 경우")
    @ParameterizedTest
    @CsvSource({"1, 2", "2, 1"})
    void Both_strikes_and_balls_exist(int ballCount, int strikeCount) {
        BallCompareResult result = new BallCompareResult();
        result.setBallCount(ballCount);
        result.setStrikeCount(strikeCount);

        assertEquals(result.getMessage(), ballCount + "볼 " + strikeCount + "스트라이크");
    }

    @DisplayName("볼과 스트라이크가 하나만 존재하는 경우")
    @ParameterizedTest
    @CsvSource({"0, 2", "2, 0"})
    void only_one_of_a_strike_and_ball(int ballCount, int strikeCount) {
        BallCompareResult result = new BallCompareResult();
        result.setBallCount(ballCount);
        result.setStrikeCount(strikeCount);

        String ballMessage = ballCount != 0 ? ballCount + "볼" : " ";
        String strikeMessage = strikeCount != 0 ? strikeCount + "스트라이크" : "";
        assertEquals(result.getMessage(), (ballMessage + strikeMessage).trim());
    }

    @DisplayName("볼과 스트라이크가 모두 존재하지 않는 경우 ")
    @Test
    void no_ball_no_strike() {
        BallCompareResult result = new BallCompareResult();

        assertEquals(result.getMessage(), "낫싱");
    }
}
