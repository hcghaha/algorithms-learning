/**
 * Created by huangchaoguang on 2018/12/8.
 */

import java.util.function.*;
public class Dance {
    private static int a;

    public static Integer rest(BiFunction<Integer, Double, Integer> takeABreak) {
        return takeABreak.apply(3, 10.2);
    }

    public static void main(String[] participants) {
        rest((s, e) -> s.intValue() + e.intValue());
        int a = 0;
        char ch;
        ch = (char) a;
    }

}
