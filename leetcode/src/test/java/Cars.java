/**
 * Created by huangchaoguang on 2018/12/8.
 */
public class Cars {
    static {
        System.out.println("static");
    }
    private static void drive(){
        System.out.println("fast");
    }

    public static void main(String[] args) {
        drive();
        drive();
    }
}
