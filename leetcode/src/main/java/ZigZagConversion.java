/**
 * Created by huangchaoguang on 2018/12/11.
 */
public class ZigZagConversion {
    class Solution {
        public String convert(String s, int numRows) {
            if (s == null || "".equals(s) || numRows <= 1 || numRows >= s.length()) {
                return s;
            }
            StringBuilder[] sbs = new StringBuilder[numRows];
             //初始化下标
            int[] indexs = new int[numRows * 2 - 2];
            int j = 0;
            for (int i = 0; i < numRows; i++) {
                indexs[j++] = i;
            }
            for (int i = numRows - 2; i > 0; i--) {
                indexs[j++] = i;
            }

            j = 0;
            int index = 0;
            while (j<s.length()){
                index = indexs[j % indexs.length];
                sbs[index].append(s.charAt(j));
                j++;
            }
            StringBuilder sb = new StringBuilder(s.length());
            for (int i=0; i<sbs.length; i++){
                sb.append(sbs[i]);
            }

            return  sb.toString();
        }
    }
}
