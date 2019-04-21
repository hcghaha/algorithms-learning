/**
 * create by huangchaoguang on 2019/4/21
 */
public class ContainerWithMostWater {
    class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            int i = 0, j = height.length - 1;
            while (i < j) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j])*(j-i));
                if (height[i] < height[j]){
                    i++;
                } else {
                    j--;
                }
            }
            return maxArea;
        }
    }

    public int test(){
        ContainerWithMostWater.Solution solution = new ContainerWithMostWater.Solution();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        return solution.maxArea(height);
    }




    public static void main(String[] args) {
        ContainerWithMostWater main = new ContainerWithMostWater();
        System.out.println(main.test());


    }
}
