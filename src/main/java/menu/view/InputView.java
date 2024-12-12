package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String COACH_NAME_PROMPT = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public String readCoach() {
        System.out.println(COACH_NAME_PROMPT);
        return Console.readLine();
    }
}