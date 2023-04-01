package productSum;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        //int sum = findProductSum(list, 1);

    }

    /*private static int findProductSum(List<String> list, int multiplier) {
        int sum = 0;

        for(Object obj : list){
            if(obj instanceof ArrayList){
                sum = sum + findProductSum(obj, multiplier + 1)
            }else{
                sum = sum + obj;
            }
        }
        return sum * multiplier;
    }*/
}
