import java.util.HashMap;

/**
* Created by huangchaoguang on 2018/12/5.
*/
public class LongestPalindromicSubstring {
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.equals("")) return s;
            HashMap<String, String> map = new HashMap<String, String>(1000);
            for (int i = 0; i < s.length(); i++) {
                String key = String.valueOf(s.charAt(i));
                String value = map.get(key);
                if (value != null) {
                    value = i + ";" + value;
                } else {
                    value = String.valueOf(i);
                }
                map.put(key, value);
            }
            int max = 0;
            String maxStr = null;
            int j, begin, end;
            for (int i = 0; i < s.length(); i++) {
                String key = String.valueOf(s.charAt(i));
                String[] values = map.get(key).split(";");
                for (String value : values) {
                    begin = i;
                    end = Integer.valueOf(value);
                    j = end + 1;
                    if (max >= (j - i)) break;
                    while (begin <= end) {
                        if (s.charAt(begin) != s.charAt(end)) {
                            break;
                        }
                        begin++;
                        end--;
                    }
                    if (end < begin) {
                        max = j - i;
                        maxStr = s.substring(i, j);
                    }
                }
            }
            return maxStr;
        }
    }

    public void test(){
        LongestPalindromicSubstring.Solution solution = new LongestPalindromicSubstring.Solution();
        System.out.println(solution.longestPalindrome("aaabaaaa"));
        System.out.println("babad".substring(0, 5));
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring palindromicSubstring = new LongestPalindromicSubstring();
        palindromicSubstring.test();
    }
}
