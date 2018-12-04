/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Created by huangchaoguang on 2018/12/4.
 */
public class MedianOfTwoSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int size1 = nums1.length;
            int size2 = nums2.length;
            boolean hasTwoMidNum = (size1 + size2)%2 == 0;
            long midSize = (size1 + size2 -1)/2 ;
            int i=0, j=0, k=0;
            boolean isNums1;
            double result =0.0;
            while(true){
                if (i == size1) {
                    isNums1 = false;
                } else if(j == size2) {
                    isNums1 = true;
                } else {
                    isNums1 = (nums1[i] <= nums2[j]);
                }
                if (k>=midSize){
                    result += isNums1 ? nums1[i] : nums2[j];
                    if (!hasTwoMidNum) return result;
                    if (k == midSize + 1) return result/2;
                }
                if (isNums1) i++;
                else j++;
                k++;
            }
        }
    }

    public void test(){
        Solution solution = new Solution();
        int nums1[] = new int[]{1,2,10};
        int nums2[] = new int[]{3,4,5,6,7,8,9};
        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        median.test();
    }
}
