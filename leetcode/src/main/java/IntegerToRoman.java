/**
 * Created by huangchaoguang on 2018/12/5.
 */
public class IntegerToRoman {

    class Solution {
        public String intToRoman(int num) {
            if (num<0){
                return "";
            }
            String[] qian = {"", "M", "MM", "MMM", "MMMM", "MMMMM", "MMMMMM", "MMMMMMM", "MMMMMMMM", "MMMMMMMMM"};
            String[] bai = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            String[] shi = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String[] ge = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            String roman = "";

            int tmp = num;

            roman = roman + qian[tmp / 1000];
            tmp = tmp % 1000;

            roman = roman + bai[tmp / 100];
            tmp = tmp % 100;

            roman = roman + shi[tmp / 10];
            tmp = tmp % 10;

            roman = roman + ge[tmp];

            return roman;

        }
    }
}
