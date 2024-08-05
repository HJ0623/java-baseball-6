package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static void validateInput(String input) {
        if (input.length() != 3) {     // 길이가 3이 아닐떄
            throw new IllegalArgumentException();
        }
        Set<Character> uniqueDigits = new HashSet<>();
        for (char c : input.toCharArray()) { //각문자가 숫자인지 0인지 확인
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException();
            }
            uniqueDigits.add(c);
        }
        if (uniqueDigits.size() != 3) {  // 고유한 숫자의 개수확인
            throw new IllegalArgumentException();
        }

    }
}
