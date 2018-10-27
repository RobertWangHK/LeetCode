package Facebook;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC_767_Reorganize_String {
    public String reorganizeString(String S) {

        // Edge
        if (S == null || S.length() == 0) return "";
        // Init
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : S.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            pq.offer(entry);
        }

        // Check for over freq
        Map.Entry<Character, Integer> topFreq = pq.peek();
        if (topFreq.getValue() > (S.length() + 1) / 2) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            topFreq = pq.poll();
            if (i == 0 || sb.charAt(sb.length() - 1) != topFreq.getKey()) {
                sb.append(topFreq.getKey());
                topFreq.setValue(topFreq.getValue() - 1);
                if (topFreq.getValue() != 0) {
                    pq.offer(topFreq);
                }
            }
            else {
                // Fill second freq char
                Map.Entry<Character, Integer> secondFreq = pq.poll();
                sb.append(secondFreq.getKey());
                secondFreq.setValue(secondFreq.getValue() - 1);
                if (secondFreq.getValue() != 0) {
                    pq.offer(secondFreq);
                }
                pq.offer(topFreq);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LC_767_Reorganize_String lc = new LC_767_Reorganize_String();
        System.out.println(lc.reorganizeString("aaab"));
    }
}
