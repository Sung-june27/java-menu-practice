package menu.view;

public class OutputView {
    private static final String WELCOME_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public void printWelcome() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}