package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Game {
    private final Balls balls;

    public Game(List<Integer> numbers) {
        this.balls = new Balls(numbers);
    }

    public Balls getBalls() {
        return balls;
    }

    public GameEndStatus play() {
        Player player = new Player();
        BallCompareResult ballCompareResult;
        do {
            String input = InputView.inputNumber();
            Balls playerBalls = player.createBalls(input);
            ballCompareResult = balls.compare(playerBalls);
            OutputView.showResult(ballCompareResult.getMessage());
        } while (!ballCompareResult.isAllStrike());
        return end();
    }

    private GameEndStatus end() {
        String restart = InputView.inputRestart();
        if (restart.equals(GameEndStatus.RESTART.getValue())) {
            return GameEndStatus.RESTART;
        }
        if (restart.equals(GameEndStatus.END.getValue())) {
            return GameEndStatus.END;
        }
        throw new IllegalArgumentException("잘못 입력하였습니다.");
    }


}
