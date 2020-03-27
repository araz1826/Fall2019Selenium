package utilities;

import java.util.*;

public class Practice {
    public static void main(String[] args) {

        int number=153;
        int a=0;
        int sum=0;
        while (number>0){

           a=number%10;
           number=number/10;
           sum+=(a*a*a);
        }
        if (number==sum){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }

}
