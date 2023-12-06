package productSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(new ArrayList<>(Arrays.asList(7,-1)));
        list.add(3);
        list.add(new ArrayList<>(Arrays.asList(6, new ArrayList<>(Arrays.asList(-13,8)),4)));
        int sum = findProductSum(list, 1);
        System.out.println(sum);

    }

    private static int findProductSum(List<Object> list, int multiplier, int sum) {
        for(Object o: list){
            if(o instanceof ArrayList)
                findProductSum((List<Object>) o, multiplier+1, sum);
            else
                sum = sum + (Integer) o;
        }
        return sum*multiplier;
    }

    private static int findProductSum(List<Object> list, int multiplier) {
        int sum = 0;
        for(Object o: list){
            if (o instanceof ArrayList){
                sum = sum + findProductSum((List<Object>) o, multiplier+1);
            }else{
                sum = sum + (Integer)o;
            }
        }
        return sum*multiplier;
    }
}
