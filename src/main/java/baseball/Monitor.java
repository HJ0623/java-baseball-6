package baseball;
import java.util.Scanner;

class Monitor {
    private static final Scanner scanner = new Scanner(System.in);
    private static int[] computerNumber;

    public static void startGame() {
        System.out.println("Start NumberBaseBall Game.");
        boolean continuePlaying = true;
        while (continuePlaying) {
            computerNumber = CreateNumber.createRandomNumber();
            boolean isGameWon = false;
            while (!isGameWon) {
                try {
                    System.out.print("Enter Number ");
                    String userInput = scanner.nextLine();
                    Validator.validateInput(userInput);
                    int[] userNumber = parseInput(userInput);
                    String result = CountBall.getResult(computerNumber, userNumber);
                    System.out.println(result);
                    if (result.equals("3strike")) {
                        System.out.println("collect 3 number! End game");
                        isGameWon = true;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.exit(1);
                }
            }
            continuePlaying = reStart();
        }
    }

    private static int[] parseInput(String input) { //String 타입의 입력을 정수 배열로 변환하는 메서드
        int[] userNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            userNumber[i] = input.charAt(i) - '0';
        }
        return userNumber;
    }

    private static boolean reStart() {    //게임 재시작 메서드
        System.out.println("restart");
        while(true) {
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                return true;
            } else if (choice.equals("2")) {
                return false;
            } else {
                System.out.println("wrong input please input 1 or 2");
            }
        }
    }
}

