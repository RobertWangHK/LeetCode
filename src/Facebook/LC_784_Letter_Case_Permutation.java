package Facebook;

import java.util.LinkedList;
import java.util.List;

public class LC_784_Letter_Case_Permutation {
    public List<String> letterCasePermutation(String S) {
        List<String> retList = new LinkedList<>();
        if (S == null || S.length() == 0) {
            return retList;
        }
        helper(retList, S, 0);
        return retList;
    }

    // Recursion
    private void helper(List<String> retList, String currString, int startIndex) {
        if (startIndex == currString.length()) {
            retList.add(currString);
            return;
        }
        if (Character.isAlphabetic(currString.charAt(startIndex))) {
            String lowerString = currString.substring(0, startIndex)
                    + Character.toLowerCase(currString.charAt(startIndex))
                    + currString.substring(startIndex + 1);
            String upperString = currString.substring(0, startIndex)
                    + Character.toUpperCase(currString.charAt(startIndex))
                    + currString.substring(startIndex + 1);
            helper(retList, lowerString, startIndex + 1);
            helper(retList, upperString, startIndex + 1);
        }
        else {
            helper(retList, currString, startIndex + 1);
        }
    }

}
