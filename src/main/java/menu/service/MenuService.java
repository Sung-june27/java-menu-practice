package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.constant.Food;

public class MenuService {
    List<String> categories = new ArrayList<>();

    public List<String> selectCategories() {
        Food[] foods = Food.values();
        for (int i = 0; i < 5; i++) {
            int idx = Randoms.pickNumberInRange(1, 5) - 1;
            String category = foods[idx].getCategory();
            if (countCategory(category) > 1) {
                i--;
                continue;
            }
            categories.add(category);
        }
        return categories;
    }

    private int countCategory(String category) {
        return Collections.frequency(categories, category);
    }
}
