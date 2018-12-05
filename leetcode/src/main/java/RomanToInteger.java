import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by huangchaoguang on 2018/12/5.
 */
public class RomanToInteger {
    /**
     * 方案1
     */
    class Solution {
        public int romanToInt(String s) {
            if (s == null || s.equals("")){
                return 0;
            }
            Map<String, Integer> romanMap = new HashMap<>();
            romanMap.put("I", 1);
            romanMap.put("V", 5);
            romanMap.put("X", 10);
            romanMap.put("L", 50);
            romanMap.put("C", 100);
            romanMap.put("D", 500);
            romanMap.put("M", 1000);

            Stack<Integer> stack = new Stack<>();
            for(int i=0; i<s.length(); i++){
                Integer value = romanMap.get(String.valueOf(s.charAt(i)));
                if (value == null) {
                    return 0;
                }
                nextValue(stack, value);
            }
            long num = 0;
            while (stack.size() > 0) {
                Integer tmp = stack.pop();
                num = num + tmp;
            }
            if (num > Integer.MAX_VALUE) return 0;
            return (int) num;
        }

        public void nextValue(Stack<Integer> stack, Integer value){
            if (stack.size() == 0) {
                stack.push(value);
                return;
            }
            Integer tmp = stack.peek();
            if (value <= tmp) {
                stack.push(value);
                return;
            }
            stack.pop();
            nextValue(stack, value -tmp);
        }
    }

    /**
     * 方案2
     */
    class Solution2 {
        public int romanToInt(String s) {
            if (s == null || s.equals("")){
                return 0;
            }
            Map<String, Integer> romanMap = new HashMap<>();
            romanMap.put("I", 1);
            romanMap.put("V", 5);
            romanMap.put("X", 10);
            romanMap.put("L", 50);
            romanMap.put("C", 100);
            romanMap.put("D", 500);
            romanMap.put("M", 1000);
            int pre = 0;
            long num = 0;
            Integer value = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                value = romanMap.get(String.valueOf(s.charAt(i)));
                if (value == null) {
                    return 0;
                }
                num = (pre > value) ? num - value : num + value;
                pre = value;
            }
            if (num > Integer.MAX_VALUE) return 0;
            return (int) num;
        }
    }
}
