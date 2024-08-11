package baseball;
import java.util.Scanner;

class Monitor {
    private static final Scanner scanner = new Scanner(System.in);
    private static int[] computerNumber;
    private static final String RESTART= "1"; //상수 설정
    private static final String EXIT="2";

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean continuePlaying = true;
        while (continuePlaying) {
            computerNumber = CreateNumber.createRandomNumber();
            boolean isGameWon = false;
            while (!isGameWon) {
                try {
                    System.out.print("숫자를 입력해주세요: ");
                    String userInput = scanner.nextLine();
                    Validator.validateInput(userInput);
                    int[] userNumber = parseInput(userInput);
                    String result = Count.getResult(computerNumber, userNumber);
                    System.out.println(result);
                    if (result.equals("3스트라이크")) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."); // 설명이 부족했음
        while(true) {
            String choice = scanner.nextLine();
            if (choice.equals(RESTART)) {
                return true;
            } else if (choice.equals(EXIT)) {
                return false;
            } else {
                System.out.println("잘못된 입력입니다 새로시작하려면 1 종료하려면 2를 입력하세요.");
            }
        }
    }
}

