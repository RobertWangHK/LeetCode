package Facebook;

import java.util.*;

public class LC_721_Account_Merge {

    // Typical union find problem
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>> retList = new LinkedList<>();

        // Edge
        if (accounts == null || accounts.size() == 0) return retList;
        // Init
        Map<String, String> parents = new HashMap<>();
        Map<String, String> users = new HashMap<>();

        // Loop, assign parents to itself and user relationship
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                users.put(email, userName);
                parents.put(email, email);
            }
        }

        // Loop, combine union under same parents
        for (List<String> account : accounts) {
            String leadEmail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                parents.put(find(parents, email), leadEmail);
            }
        }

        // Loop, combine emails with same parent to same list
        Map<String, Set<String>> combineEmails = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                String parentEmail = find(parents, email);
                if (!combineEmails.containsKey(parentEmail)) {
                    combineEmails.put(parentEmail, new HashSet<String>());
                }
                combineEmails.get(parentEmail).add(email);
            }
        }

        // Generate output
        for (String parentEmail : combineEmails.keySet()) {
            String userName = users.get(parentEmail);
            List<String> list = new LinkedList<>();
            list.add(userName);
            for (String email : combineEmails.get(parentEmail)) {
                list.add(email);
            }
            retList.add(list);
        }

        return retList;
    }

    private String find(Map<String, String> parents, String email) {
        while (!email.equals(parents.get(email))) {
            email = parents.get(email);
        }
        return email;
    }

}
