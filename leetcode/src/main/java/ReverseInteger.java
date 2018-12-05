/**
 * Created by huangchaoguang on 2018/12/5.
 */
public class ReverseInteger {

    class Solution {
        public int reverse(int x) {
            long h = x;
            long m = 0;
            do {
                m = m * 10 + h % 10;
                h = h / 10;
            } while (h != 0);
            if (m > Integer.MAX_VALUE) return 0;
            if (m < Integer.MIN_VALUE) return 0;
            return (int) m;
        }
    }

}
