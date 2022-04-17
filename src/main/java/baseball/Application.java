package baseball;

import baseball.Utils.RandomNumberGenerator;
import baseball.domain.Game;
import baseball.domain.GameEndStatus;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameEndStatus status;
        do {
            Game game = new Game(RandomNumberGenerator.generate());
            status = game.play();
        } while (status.equals(GameEndStatus.RESTART));
    }
}
