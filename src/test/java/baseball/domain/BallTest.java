package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @DisplayName("위치값이 같고 숫자도 같으면 스트라이크")
    @Test
    void strike() {
        Ball ball = new Ball(1, 4);
        Ball ball2 = new Ball(1, 4);

        CompareStatus compare = ball.compare(ball2);
        assertThat(compare).isEqualTo(CompareStatus.STRIKE);
    }

    @DisplayName("위치값이 다르고 숫자가 같으면 볼")
    @Test
    void ball() {
        Ball ball = new Ball(1, 4);
        Ball ball2 = new Ball(2, 4);

        CompareStatus compare = ball.compare(ball2);
        assertThat(compare).isEqualTo(CompareStatus.BALL);
    }

    @DisplayName("위치값과 숫자가 모두 다르면 낫싱")
    @Test
    void nothing() {
        Ball ball = new Ball(1, 3);
        Ball ball2 = new Ball(2, 4);

        CompareStatus compare = ball.compare(ball2);
        assertThat(compare).isEqualTo(CompareStatus.NOTHING);
    }


}
