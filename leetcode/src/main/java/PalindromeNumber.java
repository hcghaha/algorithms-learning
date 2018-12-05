/**
 * Created by huangchaoguang on 2018/12/5.
 */
public class PalindromeNumber {

    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            long h = x;
            long m = 0;
            do {
                m = m * 10 + h % 10;
                h = h / 10;
            } while (h != 0);
            if (m > Integer.MAX_VALUE) return false;
            return (int)m == x;
        }
    }
}
