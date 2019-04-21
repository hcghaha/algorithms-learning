/**
 * create by huangchaoguang on 2018/12/11
 */
public class ZigZagConversion {

    class Solution {
        public String convert(String s, int numRows) {
            if (s == null || "".equals(s) || numRows <= 1 || s.length() <=numRows) {
                return s;
            }

            int len = 2 * (s.length() / (2 * numRows - 2));
            int left = s.length() % (2 * numRows - 2);
            if (left > numRows) {
                len = len + 2;
            } else if (left > 0) {
                len = len + 1;
            }
            char chars[][] = new char[numRows][len];
            int i = 0, j = 0, k = 0;
            boolean isOdd = true;
            while (k < s.length()) {
                if (isOdd || (i != 0 && i != (numRows - 1))) {
                    chars[i][j] = s.charAt(k++);
                }
                i = isOdd ? i + 1 : i - 1;

                if (isOdd && i == numRows) {
                    isOdd = false;
                    i = numRows - 1;
                    j++;
                } else if (!isOdd && i == -1) {
                    isOdd = true;
                    i = 0;
                    j++;
                }
            }

            StringBuilder sb = new StringBuilder(s.length());
            for (i = 0; i < numRows; i++) {
                for (j = 0; j < len; j++) {
                    if (chars[i][j] != '\u0000') {
                        sb.append(chars[i][j]);
                    }
                }
            }
            return sb.toString();
        }
    }

    public void test() {
        Solution solution = new Solution();
        String str = "PAYPALISHIRING";
        int numRows = 4;
        String convertStr = solution.convert(str, numRows);
        System.out.println(convertStr);
    }

}