package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

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
            System.out.println("숫자를 입력해 주세요:");
            Balls playerBalls = player.createBalls(Console.readLine());
            ballCompareResult = balls.compare(playerBalls);
            System.out.println(ballCompareResult.getMessage());

        } while (!ballCompareResult.isAllStrike());

        return end();

    }

    private GameEndStatus end() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("새로운 게임을 시작하려면1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        if (restart.equals("1")) {
            return GameEndStatus.RESTART;
        }
        if (restart.equals("2")) {
            return GameEndStatus.END;
        }
        throw new IllegalArgumentException("잘못 입력하였습니다.");
    }


}
