package Google;

public class SentenceFitScreen {
    public int getLargestFont(String s, int height, int width , int smallestFontSize, int biggestFontSize) {
        int lo = smallestFontSize;
        int hi = biggestFontSize;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFit(height, width, s, mid)) {
                lo = mid;
            }
            else {
                hi = mid - 1;
            }
        }

        return lo;
    }


    private boolean canFit(int height, int width, String s, int font) {
        int rows = height / font;
        int cols = width / font;

        int cnt = 0;
        for (int i  = 0; i < rows; i++) {
            cnt += cols;
            if (s.charAt(cnt % s.length()) == ' ') {
                cnt += 1;
            }
            else {
                while (cnt >= 0 && s.charAt(cnt % s.length()) != ' ') {
                    cnt -= 1;
                }
                cnt += 1;
            }
        }

        return cnt >= s.length();
    }
}


