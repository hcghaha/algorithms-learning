/**
 * create by huangchaoguang on 2018/12/8
 */
public class TwoBigNumSum {


    public String sumTwoBigNum(String num1, String num2){
        if(num1==null || "".equals(num1) || num2 == null || "".equals(num2)){
            return null;
        }
        char ch1 = num1.charAt(0);
        char ch2 = num2.charAt(0);
        if (ch1 != '-' && ch1 != '+' && (ch1 < '0' || ch1 > '9')) {
            return null;
        }
        if (ch2 != '-' && ch2 != '+' && (ch2 < '0' || ch2 > '9')) {
            return null;
        }
        String result = "";
        //一正一负，两数做减法
        if ((ch1 == '-' && ch2 != '-') || (ch2 == '-' && ch1 != '-')) {
            result = bigNumSub(num1, num2);
        }
        //否做加法
        else {
            result = bigNumAdd(num1, num2);
        }
        return result;
    }



    private String bigNumSub(String num1, String num2) {
        // 翻转两个字符串，并转换成数组
        char[] chars1 = new StringBuffer(num1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuffer(num2).reverse().toString().toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        // 找到最大长度
        int length = length1 > length2 ? length1 : length2;
        int[] result = new int[length];
        // 表示结果的正负
        char sign = '+';
        // 判断最终结果的正负
        if (length1 < length2) {
            sign = '-';
        } else if (length1 == length2) {
            int i = length1 - 1;
            // 找到第一个不相等的
            // 注意下标0处理
            while (i > 0 && chars1[i] == chars2[i]) {
                i--;
            }
            if (chars1[i] < chars2[i]) {
                sign = '-';
            }
        }
        // 计算结果集，如果最终结果为正，那么就a-b否则的话就b-a
        for (int i = 0; i < length; i++) {
            int int1 = i < length1 ? (chars1[i] - '0') : 0;
            int int2 = i < length2 ? (chars2[i] - '0') : 0;
            if (sign == '+') {
                result[i] = int1 - int2;
            } else {
                result[i] = int2 - int1;
            }
        }
        // 如果结果集合中的某一位小于零，那么就向前一位借一，
        // 然后将本位加上10。其实就相当于借位做减法
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] < 0) {
                result[i + 1] -= 1;
                result[i] += 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        // 如果最终结果为负值，就将负号放在最前面，正号则不需要
        if (sign == '-') {
            stringBuilder.append('-');
        }
        // 判断是否有前置0
        boolean flag = true;
        for (int i = length - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            stringBuilder.append(result[i]);
        }
        // 结果为一位且是0，被上面的for处理了
        // 如果最终结果集合中没有值，就说明是两值相等，最终返回0
        if (stringBuilder.toString().equals("")) {
            stringBuilder.append("0");
        }
        // 返回值
        return stringBuilder.toString();
    }

    private String bigNumAdd(String num1, String num2) {
        // 翻转两个字符串，并转换成数组
        char[] chars1 = new StringBuffer(num1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuffer(num2).reverse().toString().toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        // 计算两个长字符串中的较长字符串的长度
        int length = length1 > length2 ? length1 : length2;
        int[] result = new int[length + 1];
        for (int i = 0; i < length + 1; i++) {
            // 如果当前的i超过了其中的一个，就用0代替，和另一个字符数组中的数字相加
            int int1 = i < length1 ? (chars1[i] - '0') : 0;
            int int2 = i < length2 ? (chars2[i] - '0') : 0;
            result[i] = int1 + int2;
        }
        // 处理结果集合，如果大于10的就向前一位进位，则进行除10取余
        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        // flag用于标识是否有前置0，如果有就不要存储
        boolean flag = true;
        for (int i = length; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            stringBuilder.append(result[i]);
        }
        // 返回结果
        return stringBuilder.toString();
    }
}
