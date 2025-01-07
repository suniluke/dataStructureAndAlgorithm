package Arrays;

public class SplitArray {
    public static void main(String[] args) {
        SplitArray s = new SplitArray();
        int[] nums = {10,4,-8,7};
        int count = s.split(nums);
        System.out.println(count);
    }

    private int split(int[] nums) {
        int right = 0;
        for (int num : nums) {
            right += num;
        }

        int left = 0;
        int res = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            right -= nums[i];
            if (left >= right) {
                res++;
            }
        }

        return res;
    }
}
