import java.math.BigDecimal;
import java.text.Format;

/**
 * 有两个非负数a和b，求两者的和。注意a和b可能是小数，输出结果不包含多于的0
 */
public class TwoBigNumSum {
    /**
     * 计算两个数值的和
     * @param a
     * @param b
     * @return
     */
    public String sum(String a, String b) {
        return new BigDecimal(a).add(new BigDecimal(b)).stripTrailingZeros().toPlainString();
    }

    public String sum2(String a, String b){
        String aa[] = a.split(".");
        String bb[] = a.split(".");
//        if (aa[0] == null)

        return null;
    }


    public static void main(String[] args) {
        TwoBigNumSum twoBigNumSum = new TwoBigNumSum();
        System.out.println(twoBigNumSum.sum("000111111177777777777777711111111012120.00098", "0.00002"));
        String str = "121a1w2a1e433awe";
        System.out.println(str.split("a")[0]);
    }
}
