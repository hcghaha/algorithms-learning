import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NameOfCommunity {

    public static void main(String[] args) {
        List<String> list = getStringList();
//        for (int i=10; i<50; i++){
//            String str = list.get(i);
//            System.out.println(deal(str));
//
//        }
        writeCSV(list, "D:\\ceshi.csv");

    }

    private static List<String> getStringList() {
        List<String> list = new ArrayList<>(2600);
        list.add("津安创意园大堂门口2号丰巢快递柜");
        list.add("百晟汇翠湾大门入口左侧");
        list.add("鸿运花园停车场北出口");
        list.add("4号大院16号西区首层（原e栈）");
        list.add("沙园大厦大街南5号旁边（原e栈）");
        list.add("富力桃园E区1栋楼下");
        return list;
    }


    private static String deal(String address){
        int index = 0;
        int temp = 0;
        temp = address.lastIndexOf("区");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("园");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("院");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("苑");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("村");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("厦");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("期");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("庭");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("居");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("城");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("阁");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("寓");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("场");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("馆");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("庄");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("轩");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("里");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("府");
        if (temp > index) index = temp;
        temp = address.lastIndexOf("湾");
        if (temp > index) index = temp;

        if (index > 0) {
            return address.substring(0,index+1);
        }
        return address.substring(0,5);
    }


    private static void writeCSV(List<String> dataList, String finalPath){
        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try{
            File finalCSVFile=new File(finalPath);
            out=new FileOutputStream(finalCSVFile);
            osw=new OutputStreamWriter(out,"UTF-8");
            // 手动加上BOM标识
            osw.write(new String(new byte[]{(byte)0xEF,(byte)0xBB,(byte)0xBF}));
            bw=new BufferedWriter(osw);
            /**
             * 往CSV中写新数据
             */
            String title="";
            title="小区";
            bw.append(title).append("\r");

            if(dataList!=null&&!dataList.isEmpty()){
                for(String data:dataList){
                    bw.append(deal(data));
                    bw.append("\r");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{

            if(bw!=null){
                try{
                    bw.close();
                    bw=null;
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(osw!=null){
                try{
                    osw.close();
                    osw=null;
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try{
                    out.close();
                    out=null;
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

        }
        System.out.println(finalPath+"数据导出成功");
    }



}