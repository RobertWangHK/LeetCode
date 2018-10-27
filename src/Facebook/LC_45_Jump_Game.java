package Facebook;

public class LC_45_Jump_Game {
    public int jump(int[] nums) {
        int ret = 0;
        int position = 0, newPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            newPosition = position;
            while (i <= position) {
                newPosition = Math.max(newPosition, i + nums[i]);
                i += 1;
            }
            ret += 1;
            if (newPosition >= nums.length - 1) {
                break;
            }
            position = newPosition;
        }

        return ret;
    }

    public static void main(String[] args) {
        LC_45_Jump_Game lc = new LC_45_Jump_Game();
        lc.jump(new int[] {1,2,3});
    }
}
