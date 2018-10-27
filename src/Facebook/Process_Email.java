package Facebook;

import java.util.*;

public class Process_Email {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Edge
        if (s == null || s.length() == 0) return 0;
        // Init
        Map<Character, Integer> countMap = new HashMap<>();
        int count = countMap.size();

        // Loop
        int lo = 0, hi = 0;
        int retLength = 0;
        while (hi < s.length()) {
            char top = s.charAt(hi);
            countMap.put(top, countMap.getOrDefault(top, 0) + 1);
            if (countMap.get(top) == 1) {
                count += 1;
            }
            while (count > 2) {
                char curr = s.charAt(lo);
                countMap.put(curr, countMap.get(curr) - 1);
                if (countMap.get(curr) == 0) {
                    count -= 1;
                }
                lo += 1;
            }
            retLength = Math.max(retLength, hi - lo + 1);
            hi += 1;
        }

        return retLength;
    }

    public int processEmail(List<String> emails) {
        // Edge
        if (emails == null || emails.size() == 0) return 0;
        // Process
        Map<String, List<String>> map = new HashMap<>();
        for (String email : emails) {
            String processed_email = processHelper(email);
            if (!map.containsKey(processed_email)) {
                map.put(processed_email, new LinkedList<>());
            }
            map.get(processed_email).add(email);
        }

        int size = 0;
        for (String email : map.keySet()) {
            size += map.get(email).size() > 1 ? 1 : 0;
        }
        return size;
    }

    private String processHelper(String email) {
        // Edge
        if (email == null || email.length() == 0) return "";
        // Init
        Queue<String> queue = new LinkedList<>();
        char[] chars = email.toCharArray();

        String tmpString = "";
        int i = 0;

        for (; i < chars.length; i++) {
            char c = chars[i];
            if (c == '@') {
                queue.offer(tmpString);
                tmpString = "";
                break;
            }
            else if (c == '.') {
                queue.offer(tmpString);
                tmpString = "";
            }
            else if (c == '+') {
                queue.offer(tmpString);
                tmpString = "";
                while (i < chars.length && chars[i] != '@') {
                    i += 1;
                }
                break;
            }
            else {
                tmpString = tmpString + c;
            }
        }
        // If doesn't have @ portion
        if (i >= email.length() - 1) {
            return "";
        }
        // Append the substring from @ onwards
        queue.offer(email.substring(i));

        String retString = "";
        while (!queue.isEmpty()) {
            retString += queue.poll();
        }

        return retString;
    }

    public static void main(String[] args) {
        Process_Email process_email = new Process_Email();
        List<String> email_list= new LinkedList<>(Arrays.asList("a...@fb.com", "ab+b@fb.com", "ab@fb.com", "a.b@fb.com",
                "a.b.c.d.e@fb.com", "a+b+c@fb.com", "ab...cd@fb.com"));
        System.out.println(process_email.processEmail(email_list));
    }
}
