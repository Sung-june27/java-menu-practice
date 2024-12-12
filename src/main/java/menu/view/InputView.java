package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;

public class InputView {
    private final String COACH_NAME_PROMPT = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final String NOT_PREFERRED_FOOD_PROMPT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public String readCoach() {
        System.out.println(COACH_NAME_PROMPT);
        return Console.readLine();
    }

    public String readInedibleFoods(Coach coach) {
        System.out.printf(NOT_PREFERRED_FOOD_PROMPT, coach.getName());
        return Console.readLine();
    }
}