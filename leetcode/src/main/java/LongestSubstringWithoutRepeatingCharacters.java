/**
 * Created by huangchaoguang on 2018/12/5.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 解决方案1
     */
    class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() <= 0) {
                return 0;
            }
            StringBuilder subStr = new StringBuilder();
            int index = -1;
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                String ch = String.valueOf(s.charAt(i));
                index = subStr.indexOf(ch);
                if (index != -1) {
                    if (max < subStr.length()) max = subStr.length();
                    subStr = new StringBuilder(subStr.substring(index + 1));
                }
                subStr.append(ch);
            }
            if (max < subStr.length()) max = subStr.length();
            return max;
        }
    }

    /**
     * 解决方案2
     */
    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() <= 0) {
                return 0;
            }
            int[] index = new int[128];
            int max = 0; //最多长度
            int i = 0;  //起始位置
            for (int j = 0; j < s.length(); j++) {
                i = Math.max(index[s.charAt(j)], i);
                max = Math.max(max, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return max;
        }
    }
}
