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
            readInedibleFoods(coach);
        }
        recommendMenu(coaches);
    }

    public List<Coach> readCoach() {
        outputView.printWelcome();
        return retry(() -> {
            String input = inputView.readCoach();
            return coachService.initCoaches(input);
        });
    }

    public void readInedibleFoods(Coach coach) {
        retry(() -> {
            String input = inputView.readInedibleFoods(coach);
            return coachService.addInedibleFoods(coach, input);
        });
    }

    public void recommendMenu(List<Coach> coaches) {
        List<String> categories = menuService.selectCategories();
        coachService.recommendMenu(coaches, categories);
        outputView.printCategories(categories);
        outputView.printRecommendedMenu(coaches);
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
