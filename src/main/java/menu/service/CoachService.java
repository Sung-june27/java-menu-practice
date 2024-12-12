package menu.service;

import static menu.service.constant.CoachConstants.DELIMITER;
import static menu.service.constant.CoachConstants.MAX_COACH_LENGTH;
import static menu.service.constant.CoachConstants.MAX_INEDIBLE_FOOD_COUNT;
import static menu.service.constant.CoachConstants.MIN_COACH_LENGTH;
import static menu.service.constant.CoachConstants.MIN_INEDIBLE_FOOD_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.service.constant.CoachConstants;
import menu.constant.ErrorMessage;
import menu.constant.Food;
import menu.domain.Coach;

public class CoachService {
    public List<Coach> initCoaches(String input) {
        String[] split = input.split(DELIMITER);
        validateCoach(split);
        return Arrays.stream(split)
                .map(Coach::new)
                .collect(Collectors.toList());
    }

    public Coach addInedibleFoods(Coach coach, String input) {
        String[] split = input.split(DELIMITER);
        validateNotPreferredFood(split);
        for (String food : split) {
            coach.addNotPreferredFood(food);
        }
        return coach;
    }

    public List<Coach> recommendMenu(List<Coach> coaches, List<String> categories) {
        for (int i = 0; i < categories.size(); i++) {
            List<String> foods = Food.foodsFromCategory(categories.get(i));
            recommendFood(coaches, foods);
        }
        return coaches;
    }

    private void recommendFood(List<Coach> coaches, List<String> foods) {
        for (int i = 0; i < coaches.size(); i++) {
            Coach coach = coaches.get(i);
            String food = Randoms.shuffle(foods).get(0);
            if (!coach.addRecommendedFood(food)) {
                i--;
            }
        }
    }

    private void validateNotPreferredFood(String[] split) {
        if (split.length < MIN_INEDIBLE_FOOD_COUNT || split.length > MAX_INEDIBLE_FOOD_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        for (String food : split) {
            Food.isFood(food);
        }
    }

    private void validateCoach(String[] split) {
        if (split.length < MIN_COACH_LENGTH || split.length > MAX_COACH_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }

        boolean validLength = Arrays.stream(split)
                .anyMatch(str -> str.length() < CoachConstants.MIN_NAME_LENGTH || str.length() > CoachConstants.MAX_NAME_LENGTH);
        if (validLength) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
