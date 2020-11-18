import java.util.*;

public class LadderLength {


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        return bfs(beginWord, endWord, wordList);


    }

    private static int bfs(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();

        Map<String, Boolean> map = new HashMap<>();

        Map<String, Integer> dist = new HashMap<>();

        dist.put(beginWord, 1);

        for (String str : wordList) {
            map.put(str, false);
        }


        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            map.put(word, true);
            char[] chars = word.toCharArray();
            for (String str : wordList) {
                char[] chars1 = str.toCharArray();
                int count = 0;
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] != chars1[i]) {
                        count++;
                    }
                }
                if (count == 1 && !map.get(str) && dist.getOrDefault(str, 0) == 0) {
                    dist.put(str, dist.get(word) + 1);
                    if (str.equals(endWord)) return dist.get(str);
                    queue.offer(str);
//                    System.out.println(str);
//                    break;
                }
            }


        }
        return 0;

    }

    public static void main(String[] args) {
        String sword = "hot";
        String eword = "dog";

        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dog");
        list.add("cog");
        list.add("pot");
        list.add("dot");

        System.out.println(ladderLength(sword, eword, list));
    }
}
