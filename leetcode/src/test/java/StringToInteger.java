/**
 * Created by huangchaoguang on 2018/12/6.
 */
public class StringToInteger {
    class Solution {
        public int myAtoi(String str) {
            if (str == null) {
                return 0;
            }
            str = str.trim();
            if ("".equals(str)){
                return 0;
            }
            boolean flag = true;
            long result = 0;
            //第一个非空值
            char val = str.charAt(0);
            if ('-' == val) {
                flag = false;
            } else if ('+' == val) {
                flag = true;
            } else if (val < '0' || val > '9') {
                return (int) result;
            } else {
                result = (int) val - 48;
            }
            //其他的数值
            for (int i = 1; i < str.length(); i++) {
                val = str.charAt(i);
                if (val < '0' || val > '9') {
                    break;
                } else {
                    result = result * 10 + (int) val - 48;
                    if (flag && result >= Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if (!flag && -result <= Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
            }
            return (int) (flag ? result : -result);
        }
    }

    class Solution2 {
        public int myAtoi(String str) {
            if (str == null) {
                return 0;
            }
            //去除空格
            int i=0;
            char val;
            while (i < str.length()) {
                val = str.charAt(i);
                if (val != ' ') break;
                i++;
            }
            if (i== str.length()){
                return 0;
            }

            // 第一个非空值
            boolean flag = true;
            // 第一个非空值，且为符号 -
            val = str.charAt(i);
            if ('-' == val) {
                i++;
                flag = false;
            }
            // 第一个非空值，且为符号 +
            else if ('+' == val) {
                i++;
            }

            //其他的数值
            long result = 0;
            for (int j = i; j < str.length(); j++) {
                val = str.charAt(j);
                // 其他的数值，非数值情况
                if (val < '0' || val > '9') {
                    break;
                }
                // 属于数值情况
                result = result * 10 + (int) val - 48;
                // 如果该数为正数，且大于Integer最大值，直接返回
                if (flag && result >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                // 如果该数为负数，且小于Integer最小值，直接返回
                if (!flag && -result <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            return (int) (flag ? result : -result);
        }
    }



    public int test(String str){
        Solution2 solution = new Solution2();
        return solution.myAtoi(str);

    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        int val = stringToInteger.test(" +12 ");
        System.out.println(val);
        val = stringToInteger.test(" ");
        System.out.println(val);
       val = stringToInteger.test("-91283472332");
        System.out.println(val);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
//        val = stringToInteger.test("    -111+1");
//        System.out.println(val);
//        val = stringToInteger.test("    -111+1");
//        System.out.println(val);
//        val = stringToInteger.test("    -111+1");
//        System.out.println(val);
    }
}
