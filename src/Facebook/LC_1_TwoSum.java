package Facebook;

import java.util.HashMap;
import java.util.Map;

public class LC_1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        if (nums == null || nums.length == 0) return ret;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i]))
                map.put(nums[i], i);
            else {
                ret[0] = map.get(target - nums[i]);
                ret[1] = i;
                break;
            }
        }

        return ret;
    }
}
