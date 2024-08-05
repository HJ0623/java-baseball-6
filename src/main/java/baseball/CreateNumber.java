package baseball;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class CreateNumber {
    public static int[] createRandomNumber() {
        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size() < 3) {
            numbers.add(random.nextInt(9)+1);
        }
        int[] result = new int[3];
        int i = 0;
        for (int num : numbers) {
            result[i++] = num;
        }
        return result;

    }
}

