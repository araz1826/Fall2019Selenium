package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {


        String str="aaabbccdddee";
        System.out.println(str.length());

        Map<Character, Integer> list=new HashMap<>();

        for (int i = 0; i <str.length() ; i++) {

            if (!list.containsKey(str.charAt(i))){
                list.put(str.charAt(i),i);
            }else {
                list.put(str.charAt(i),list.get(str.charAt(i))+1);
            }
        }
        System.out.println(list);
    }
}
