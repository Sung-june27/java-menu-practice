package menu.view;

import java.util.List;
import menu.domain.Coach;

public class OutputView {
    private final String WELCOME_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private final String RESULT_TITLE = "메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n";
    private final String CATEGORY_FORMAT = "[ 카테고리 | %s | %s | %s | %s | %s ]";
    private final String MENU_FORMAT = "[ %s | %s | %s | %s | %s | %s ]";
    private final String END_MESSAGE = "추천을 완료했습니다.";

    public void printWelcome() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printCategories(List<String> categories) {
        System.out.print(RESULT_TITLE);
        System.out.printf(CATEGORY_FORMAT, categories.get(0), categories.get(1), categories.get(2),
                categories.get(3), categories.get(4));
        printNewLine();
    }

    public void printRecommendedMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            List<String> recommendedFood = coach.getRecommendedFoods();
            String menus = String.join(" | ", recommendedFood);
//            System.out.printf(MENU_FORMAT, coach.getName(), recommendedFood.get(0), recommendedFood.get(1),
//                    recommendedFood.get(2), recommendedFood.get(3), recommendedFood.get(4));
            System.out.printf("[ %s | %s ]", coach.getName(), menus);
            printNewLine();
        }
        System.out.println(END_MESSAGE);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}