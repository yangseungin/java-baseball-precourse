package baseball.domain;

public class Ball {
    private int position;
    private int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public CompareStatus compare(Ball ball) {
        if (position == ball.position && number == ball.number) {
            return CompareStatus.STRIKE;
        }
        if (number == ball.number) {
            return CompareStatus.BALL;
        }
        return CompareStatus.NOTHING;
    }

}
