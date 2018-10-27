package Facebook;

import java.util.Stack;

public class LC_84_Largest_Rectangle_Histogram {
    public int largestRectangleArea(int[] heights) {
        // Edge
        if (heights == null || heights.length == 0) return 0;
        // Init
        int ret = 0;
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int height = i == heights.length ? 0 : heights[i];
            if (indexStack.isEmpty() || heights[indexStack.peek()] <= height) {
                indexStack.push(i);
            }
            else {
                // Find a small than max height, get width and update max rectangle size
                int topHeight = heights[indexStack.pop()];
                int width = 0;
                if (indexStack.isEmpty()) {
                    width = i;
                }
                else {
                    width = i - indexStack.peek() - 1;
                }
                ret = Math.max(ret, topHeight * width);
                // Back this element
                i -= 1;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] inputs = new int[] {2,1,5,6,2,3};
        LC_84_Largest_Rectangle_Histogram lc = new LC_84_Largest_Rectangle_Histogram();
        System.out.print(lc.largestRectangleArea(inputs));
    }
}
