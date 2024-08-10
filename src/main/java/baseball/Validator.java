package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static void validateInput(String input) {
        validateLength(input);
        validateNumber(input);
    }

    private static void validateLength(String input) {
        if (input.length() != 3) {     // 길이가 3이 아닐떄
            throw new IllegalArgumentException("3자리 숫자를 입력해야합니다");
        }
    }


    private static void validateNumber(String input){
        Set<Character> uniqueDigits = new HashSet<>();
            for (char c : input.toCharArray()) { //각문자가 숫자인지 0인지 확인
                if (!Character.isDigit(c) || c == '0') {
                    throw new IllegalArgumentException("1~9사이의 숫자를 대입해야합니다");
                }
                uniqueDigits.add(c);
            }
            if (uniqueDigits.size() != 3) {  // 중복확인
                throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다");
            }

        }
    }

