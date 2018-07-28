package Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LC_380_O1_Insert_Delete_Get {
    /**
     The idea is that we use a map to keep track of mapping between elements an detheir indexes in the array
     insert to the array is o1, as long as we still have enough space in the array, can create a resize helper function
     */

    int count = 0;
    int size = 20;
    ArrayList<Integer> nums;
    Map<Integer, Integer> elementIndexMap;
    Random random;

    /** Initialize your data structure here. */
    public LC_380_O1_Insert_Delete_Get() {
        nums = new ArrayList<>(size);
        elementIndexMap = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (elementIndexMap.containsKey(val)) return false;
        elementIndexMap.put(val, count);
        nums.add(val);
        if (count > size / 2) {
            resize();
        }
        count += 1;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!elementIndexMap.containsKey(val)) return false;
        int numIndex = elementIndexMap.get(val);
        // Exch
        int tmp = nums.get(nums.size() - 1);
        nums.set(nums.size() - 1, val);
        nums.set(numIndex, tmp);
        elementIndexMap.put(tmp, numIndex);
        elementIndexMap.remove(val);
        count -= 1;
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (count == 0) return -1;
        return nums.get(random.nextInt(count));
    }

    /** Resize helper function */
    private void resize() {
        ArrayList<Integer> newArray = new ArrayList<>(size * 2);
        // Copy
        for (int i = 0; i < count; i++) {
            newArray.set(i, nums.get(i));
        }
        nums = newArray;
        size = size * 2;
    }

    public static void main(String[] args) {
        LC_380_O1_Insert_Delete_Get lc = new LC_380_O1_Insert_Delete_Get();
        lc.insert(0);
        lc.remove(0);
        lc.remove(0);
        lc.insert(-1);
        System.out.println(lc.getRandom());
        lc.getRandom();
        lc.getRandom();
        lc.getRandom();
    }
}
