package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {


    public static void main(String[] args) {
        letterCombinations("23");
    }


    public static List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char num = digits.charAt(i);
            List<String> state0 = new ArrayList<>();
            String letter = phoneMap.get(num);
            for (int j = 0; j < letter.length(); j++) {
                state0.add(String.valueOf(letter.charAt(j)));
            }
            list.add(state0);
        }

        List<String> res = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < list.size(); i++) {

            }
        }

        return res;


    }
}
