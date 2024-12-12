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

    public String getName() {
        return name;
    }

    public void addNotPreferredFood(String food) {
        notPreferredFood.add(food);
    }
}
