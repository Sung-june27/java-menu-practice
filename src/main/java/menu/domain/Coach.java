package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> inedibleFoods = new ArrayList<>();
    private final List<String> recommendedFoods = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void addNotPreferredFood(String food) {
        inedibleFoods.add(food);
    }

    public boolean addRecommendedFood(String food) {
        if (recommendedFoods.contains(food)) {
            return false;
        }
        if (inedibleFoods.contains(food)) {
            return false;
        }
        recommendedFoods.add(food);
        return true;
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendedFoods() {
        return recommendedFoods;
    }
}
