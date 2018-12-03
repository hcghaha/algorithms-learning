/**
 * 运算验证
 */
public class OperationTest {

    public static int test(){
        int t =1, a = 2, b = -1;
        /**
         * 1. (a=b) 表示将b的值赋给a, 此时a的值为-1，(a=b)也是-1
         * 2. t=a++ 表示先运行t=a， 然后在执行a++
         * 3. 因if条件为false， if语句块为执行，所以t还是原来的值
         */
        if ((a=b)>0) t=a++;
        return t;
    }

    public static void main(String[] args) {
        System.out.println(test()); //
    }

}
