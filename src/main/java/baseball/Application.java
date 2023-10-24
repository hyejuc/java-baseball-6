package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
    public static void playGame() {
        List<Integer> computer = makeRandom();
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> user = splitNumber(Integer.parseInt(Console.readLine()));
            if (!checkException(user)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static List<Integer> makeRandom() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> splitNumber(int number) {
        List<Integer> user = new ArrayList<>();
        while (number > 0) {
            user.add(number % 10);
            number /= 10;
        }
        Collections.reverse(user);
        return user;
    }

    public static boolean checkException(List<Integer> numbers) {
        String numString = numbers.toString().replace("[","").replace("]","").replaceAll(",","").replaceAll(" ", "");
        if (numString.length() != 3) {
            return false;
        }
        if (numString.contains("0")) {
            return false;
        }
        if (!isSameNumber(numString)) {
            return false;
        }
        return true;
    }

    public static boolean isSameNumber(String numString) {
        HashMap<Character, Integer> numbers = new HashMap<>();
        for (int i = 0; i < numString.length(); i++) {
            if (numbers.containsKey(numString.charAt(i))) {
                return false;
            }
            numbers.put(numString.charAt(i), i);
        }
        return true;
    }
}
