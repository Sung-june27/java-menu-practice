package menu.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.ErrorMessage;
import menu.domain.Coach;

public class CoachService {
    private final int MIN_COACH_LENGTH = 2;
    private final int MAX_COACH_LENGTH = 5;
    private final int MIN_NAME_LENGTH = 2;
    private final int MAX_NAME_LENGTH = 4;

    public List<Coach> initCoaches(String input) {
        String[] split = input.split(",");
        validate(split);
        return Arrays.stream(split)
                .map(Coach::new)
                .collect(Collectors.toList());
    }

    private void validate(String[] split) {
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
