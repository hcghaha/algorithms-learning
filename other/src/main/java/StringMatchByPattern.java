import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * create by huangchaoguang on 2018/12/5
 */
public class StringMatchByPattern {

    /**
     *
     * @param pattern aabb
     * @param str 北京 中国 北京 中国
     * @return
     */
    public boolean match(String pattern, String str) {
        if (pattern == null || pattern.equals("") || str==null || str.equals("")){
            return false;
        }
        String strs[] = str.trim().split(" ");
        if (pattern.length() != strs.length){
            return false;
        }
        HashMap<String, String> map = new HashMap<>(strs.length);
        Set<String> set = new HashSet<>();  //主字符串不重复的个数
        for (int i=0; i< strs.length; i++){
            set.add(strs[i]);
            String key = String.valueOf(pattern.charAt(i));
            String val = map.get(key);
            if (val != null && !val.equals(strs[i])){
                return false;
            } else {
                map.put(key, strs[i]);
            }
        }
        return set.size() == map.size();
    }

    public static void main(String[] args) {
        StringMatchByPattern matchByPattern = new StringMatchByPattern();
//        System.out.println(matchByPattern.match("aabb", "呵 呵 哈 哈"));
        System.out.println(matchByPattern.match("abcdde", " 好 是 啊 才 才 才"));
    }
}
