package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validateInput(String input) {
        validateLength(input);
        validateAllDigits(input);
        validateNoZero(input);
        validateRepetition(input);
    }

    // 입력이 정확히 3자리인지 확인
    private static void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야합니다");
        }
    }

    // 모든 문자가 숫자인지 확인
    private static void validateAllDigits(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("1~9사이의 숫자를 대입해야합니다");
            }
        }
    }

    // 입력에 0이 포함되어 있지 않은지 확인
    private static void validateNoZero(String input) {
        for (char c : input.toCharArray()) {
            if (c == '0') {
                throw new IllegalArgumentException("0을 제외한 1~9사이의 숫자를 대입해야합니다");
            }
        }
    }

    // 입력된 숫자에 중복이 없는지 확인
    private static void validateRepetition(String input) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char c : input.toCharArray()) {
            uniqueDigits.add(c);
        }
        if (uniqueDigits.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다");
        }
    }
}
