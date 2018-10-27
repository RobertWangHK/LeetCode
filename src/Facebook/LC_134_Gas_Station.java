package Facebook;

public class LC_134_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Edge
        if (gas == null || gas.length == 0) return 0;
        // Init
        int length = gas.length;
        int ret = length - 1;
        int sum = 0, total = 0;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                total += sum;
                sum = 0;
                ret = (i + 1) % length;
            }
        }
        // Counter for the last positive sum into total
        total += sum;
        if (total < 0) return -1;
        return ret;
    }
}
