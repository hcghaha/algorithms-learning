/**
 * Created by huangchaoguang on 2018/12/8.
 */
//class Pass{
//    public static void main(String[] args){
//        int x=5;
//        Pass p = new Pass();
//        p.doStuff(x);
//        System.out.print("main x= "+x);
//    }
//
//    void doStuff(int x){
//        System.out.println("doStuff x= "+x++);
//
//    }
//}


//class Button {
//    public String text;
//    public int hashCode(){
//        return text.hashCode();
//    }
//
//    public boolean equals(Object o) {
//        if (!(o instanceof Button)) return false;
//        Button b = (Button) o;
//        return text.equals(b.text);
//    }
//
//    public static void main(String[] args) {
//        Button button = new Button();
//        button.text = "111";
//        System.out.println(button.equals(button));
//    }
//}

public class Test {
//    static int arr[] = new int[10];

    static int x = 10;

    static {
        x += 5;
    }

    public static void main(String[] a) {
//        System.out.println(arr[1]);
        System.out.println("x= " + x);
    }

    static {
        x += 3;
    }
}
