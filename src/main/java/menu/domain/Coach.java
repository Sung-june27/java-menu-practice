package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.constant.Food;

public class Coach {
    private final String name;
    private final List<String> notPreferredFood = new ArrayList<>();
    private final List<String> recommendedFood = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void addNotPreferredFood(String food) {
        notPreferredFood.add(food);
    }

    public void recommendMenu(List<String> categories) {
        for (int i = 0; i < categories.size(); i++) {
            List<String> foods = Food.foodsFromCategory(categories.get(i));
            String food = Randoms.shuffle(foods).get(0);
            if (recommendedFood.contains(food)) {
                i--;
                continue;
            }
            recommendedFood.add(food);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendedFood() {
        return recommendedFood;
    }
}
