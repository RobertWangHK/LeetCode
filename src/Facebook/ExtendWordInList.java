package Facebook;

import sun.jvm.hotspot.debugger.cdbg.basic.BasicFunctionSym;

import java.util.*;

/**
 * 第一轮：YS. visit 1point3acres for more.
 * 第一道Fibonacci 变种
 * 有点像word ladder的一道面经题
 *
 * 第二道会有很多follow up
 * 例如 所有的组词过程，最长的组词， 多少种最长词，还有一个超级大的test case会去跑一跑
 * 自己选择 start words，再去跑跑.留学论坛-一亩-三分地
 *
 * 对时间复杂度和空间复杂度都有一定的要求
 */
public class ExtendWordInList {
    public int extendWord(List<String> wordList, String startWord) {

        // Edge
        if (wordList.size() == 0) return 0;
        // Insert to map
        Set<String> set = new HashSet<>();
        List<String> retList = new LinkedList<>();
        for (String str : wordList) {
            set.add(str);
        }

        // BFS
        Queue<String> queue = new LinkedList<>();
        Queue<String> paths = new LinkedList<>();
        queue.offer(startWord);
        paths.offer(startWord);
        int maxLength = startWord.length();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String topString = queue.poll();
                String topPath = paths.poll();
                List<String> nextStrs = nextLevel(topString, set);

                if (!nextStrs.isEmpty()) {
                    for (String nextString : nextStrs) {
                        queue.offer(nextString);
                        paths.offer(topPath + "->" + nextString);
                        maxLength = Math.max(maxLength, nextString.length());
                    }
                }

                else {
                    retList.add(topPath);
                }
            }
        }

        System.out.println(retList);
        return maxLength;
    }

    private List<String> nextLevel(String str, Set<String> set) {
        List<String> retList = new LinkedList<>();
        // Append at last
        for (char c = 'a'; c <= 'z'; c++) {
            String tmp = str + c;
            if (set.contains(tmp)) {
                retList.add(tmp);
            }
        }
        // Append at first
        for (char c = 'a'; c <= 'z'; c++) {
            String tmp = c + str;
            if (set.contains(tmp)) {
                retList.add(tmp);
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        ExtendWordInList extendWordInList = new ExtendWordInList();
        String startWord = "at";
        List<String> wordList = new LinkedList<>(Arrays.asList("chat", "hat", "chats", "bat"));

        System.out.println(extendWordInList.extendWord(wordList, startWord));
    }

}
