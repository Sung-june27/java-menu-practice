package menu.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.constant.ErrorMessage;
import menu.constant.Food;
import menu.domain.Coach;

public class CoachService {
    private final int MIN_COACH_LENGTH = 2;
    private final int MAX_COACH_LENGTH = 5;
    private final int MIN_NAME_LENGTH = 2;
    private final int MAX_NAME_LENGTH = 4;
    private final int MIN_NOT_PREFERRED_FOOD = 0;
    private final int MAX_NOT_PREFERRED_FOOD = 2;
    private final String DELIMITER = ",";

    public List<Coach> initCoaches(String input) {
        String[] split = input.split(DELIMITER);
        validateCoach(split);
        return Arrays.stream(split)
                .map(Coach::new)
                .collect(Collectors.toList());
    }

    public void addNotPreferredFood(Coach coach, String input) {
        String[] split = input.split(DELIMITER);
        validateNotPreferredFood(split);
        for (String food : split) {
            coach.addNotPreferredFood(food);
        }
    }

    private void validateNotPreferredFood(String[] split) {
        if (split.length < MIN_NOT_PREFERRED_FOOD || split.length > MAX_NOT_PREFERRED_FOOD) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        for (String food : split) {
            Food.isFood(food);
        }
    }

    public List<Coach> recommendMenu(List<Coach> coaches, List<String> categories) {
        for (Coach coach : coaches) {
            coach.recommendMenu(categories);
        }
        return coaches;
    }

    private void validateCoach(String[] split) {
        if (split.length < MIN_COACH_LENGTH || split.length > MAX_COACH_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }

        boolean validLength = Arrays.stream(split)
                .anyMatch(str -> str.length() < MIN_NAME_LENGTH || str.length() > MAX_NAME_LENGTH);
        if (!validLength) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
