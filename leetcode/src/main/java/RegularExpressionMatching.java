/**
 * create by huangchaoguang on 2019/4/21
 */
public class RegularExpressionMatching {

    class Solution {
        public boolean isMatch(String s, String p) {
            if(p.isEmpty()){
                return s.isEmpty();
            }
            boolean firstMatch = !s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
            if (p.length()>=2 && p.charAt(1)=='*'){
                return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));

            } else {
                return firstMatch && isMatch(s.substring(1), p.substring(1));
            }
        }
    }


    public boolean test(){
        RegularExpressionMatching.Solution solution = new RegularExpressionMatching.Solution();
        ListNode head = ListUtils.createList(new int[]{1, 1, 2, 2, 2, 3, 3,6});
        return solution.isMatch("1","2");
    }
    public static void main(String[] args) {
        RegularExpressionMatching main = new RegularExpressionMatching();
        boolean result = main.test();
        System.out.println(result);

    }
}
