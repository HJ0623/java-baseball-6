package baseball;

public class Count {

    public static String getResult(int[] computerNumber, int[] userNumber) {
        int strikes = countStrikes(computerNumber, userNumber);
        int balls = countBalls(computerNumber, userNumber);

        return generateResultMessage(strikes, balls);
    }

    // 스트라이크의 개수를 계산하는 메서드
    private static int countStrikes(int[] computerNumber, int[] userNumber) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber[i] == computerNumber[i]) {
                strikes++;
            }
        }
        return strikes;
    }

    // 볼의 개수를 계산하는 메서드
    private static int countBalls(int[] computerNumber, int[] userNumber) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber[i] != computerNumber[i] && contains(computerNumber, userNumber[i])) {
                balls++;
            }
        }
        return balls;
    }

    // 결과 메시지를 생성하는 메서드
    private static String generateResultMessage(int strikes, int balls) {
        if (strikes == 3) {
            return "3스트라이크";
        } else if (strikes > 0 && balls > 0) {
            return strikes + "스트라이크 " + balls + "볼";
        } else if (strikes > 0 && balls == 0) {
            return strikes + "스트라이크";
        } else if (strikes == 0 && balls > 0) {
            return balls + "볼";
        } else {
            return "nothing";
        }
    }

    // 배열에 특정 값이 포함되어 있는지 확인하는 메서드
    private static boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}
