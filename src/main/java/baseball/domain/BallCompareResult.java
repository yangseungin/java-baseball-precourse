package baseball.domain;

public class BallCompareResult {
    private int strikeCount = 0;
    private int ballCount = 0;
    private String message = "";

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public boolean isAllStrike() {
        return strikeCount == 3;
    }

    public void recode(CompareStatus compare) {
        if (compare.equals(CompareStatus.BALL)) {
            ballCount++;
        }
        if (compare.equals(CompareStatus.STRIKE)) {
            strikeCount++;
        }
    }

    public String getMessage() {
        if (strikeCount == 0 && ballCount == 0) {
            message = "낫싱";
        }
        if (ballCount > 0) {
            message += String.format("%s볼 ", ballCount);
        }
        if (strikeCount > 0) {
            message += String.format("%s스트라이크", strikeCount);
        }
        return message.trim();
    }
}
