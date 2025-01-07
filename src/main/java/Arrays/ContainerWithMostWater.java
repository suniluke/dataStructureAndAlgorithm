package Arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater c = new ContainerWithMostWater();
        int result = c.maxArea(height);
        System.out.println(result);

    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while(left < right){
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, currentArea);
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
