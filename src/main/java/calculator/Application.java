package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        List<Character> delimiters = new ArrayList<>(List.of(',', ':'));
        int addedCount = addDelimiters(input, delimiters);
    }

    private static int addDelimiters(String input, List<Character> delimiters) {
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(input);
        int addedCount = 0;

        while (matcher.find()) {
            String delimiterText = matcher.group(1).trim();
            for (char delimiter : delimiterText.toCharArray()) {
                delimiters.add(delimiter);
                addedCount++;
            }
        }

        return addedCount;
    }
}
