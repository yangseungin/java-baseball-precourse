package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputNumber(){
        System.out.println("숫자를 입력해 주세요:");
        return Console.readLine();
    }
    public static String inputRestart(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("새로운 게임을 시작하려면1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
