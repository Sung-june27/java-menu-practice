package menu.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.domain.Coach;
import org.junit.jupiter.api.Test;

class CoachServiceTest {
    CoachService coachService = new CoachService();

    @Test
    void 먹지_못하는_음식_추가_테스트() {
        Coach coach = new Coach("성준");
        coachService.addInedibleFoods(coach, "된장찌개,비빔밥");
        assertThat(coach).extracting("notPreferredFood")
                .isEqualTo(List.of("된장찌개", "비빔밥"));
    }

    @Test
    void 먹지_못하는_음식_예외_테스트() {
        Coach coach = new Coach("성준");
        assertThatThrownBy(() -> coachService.addInedibleFoods(coach, "버거킹,비빔밥"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}