package Facebook;


import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LC_140_Word_Break {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Edge
        if (s == null || s.length() == 0) return new LinkedList<>();
        // Init
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        System.out.println(set);
        return dfs(set, s);
    }

    private List<String> dfs(Set<String> set, String s) {
        List<String> retList = new LinkedList<String>();
        if (s == null || s.length() == 0) {
            retList.add("");
            return retList;
        }

        for (int i = 1; i <= s.length(); i++) {
            String startWord = s.substring(0, i);
            if (set.contains(startWord)) {
                System.out.println(startWord);
                List<String> list = dfs(set, s.substring(i));
                for (String str : list) {
                    if (str.length() == 0) {
                        retList.add(startWord);
                    }
                    else {
                        retList.add(startWord + " " + str);
                    }
                }
            }
        }

        return retList;
    }

    public static void main(String[] args) {
        LC_140_Word_Break lc = new LC_140_Word_Break();
        System.out.println(lc.wordBreak("catsanddog", new LinkedList<>(Arrays.asList("cat","cats","and","sand","dog"))));
    }
}
