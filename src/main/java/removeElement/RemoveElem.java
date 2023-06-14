package removeElement;

import java.util.Arrays;

public class RemoveElem {

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,4,3,3,2,3,4,2,3,4};

        int target = 3;
        int index = removeElement(nums, target);

        System.out.println("index : " + index);

        Arrays.stream(nums).forEach(elem -> System.out.println(elem + " "));

    }

    private static int removeElement(int[] nums, int target) {
        int index = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != target){
                nums[index] = nums[i];
                index += 1;
            }
        }
        return index;
    }
}
