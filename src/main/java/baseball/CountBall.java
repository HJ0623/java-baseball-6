package baseball;

public class CountBall {
    public static String getResult(int[] computerNumber, int[] userNumber) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber[i] == computerNumber[i]) {
                strikes++;
            } else if (contains(computerNumber, userNumber[i])) {
                balls++;
            }
        }
        if (strikes == 3) {
            return "3strike";
        } else if (strikes > 0 && balls > 0) {
            return strikes + "strike " + balls + "ball";
        } else if(strikes > 0 && balls == 0) {
            return strikes + "strike";
        }else if(strikes == 0 && balls > 0) {
            return balls + "ball";
        }else {
            return "nothing";
        }
    }

    public static boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}

