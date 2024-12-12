package menu.domain;

import java.util.ArrayList;
import java.util.List;

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

    public boolean addRecommendedFood(String food) {
        if (recommendedFood.contains(food)) {
            return false;
        }
        if (notPreferredFood.contains(food)) {
            return false;
        }
        recommendedFood.add(food);
        return true;
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendedFood() {
        return recommendedFood;
    }
}
