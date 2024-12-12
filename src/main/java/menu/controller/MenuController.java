package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.Coach;
import menu.service.CoachService;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final CoachService coachService;
    private final MenuService menuService;
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(CoachService coachService, MenuService menuService, InputView inputView, OutputView outputView) {
        this.coachService = coachService;
        this.menuService = menuService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Coach> coaches = readCoach();
        for (Coach coach : coaches) {
            readNotPreferredFood(coach);
        }
        List<String> categories = selectCategory();
    }

    public List<Coach> readCoach() {
        return retry(() -> {
            String input = inputView.readCoach();
            return coachService.initCoaches(input);
        });
    }

    public void readNotPreferredFood(Coach coach) {
//        retry(() -> {
//            String input = inputView.readNotPreferredFood(coach);
//            return coachService.addNotPreferredFood(coach, input);
//        });
        while (true) {
            try {
                String input = inputView.readNotPreferredFood(coach);
                coachService.addNotPreferredFood(coach, input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    public List<String> selectCategory() {
        return menuService.selectCategories();
    }

    private <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
