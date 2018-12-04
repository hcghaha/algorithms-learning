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
            int size1 = nums1.length-1;
            int size2 = nums2.length-1;
            long size = size1 + size2;
            boolean hasTwoMidNum = size % 2 == 0;
            long midSize = size / 2 + 1;

            int i =0, j = 0;
            boolean isI = true;
            while (true){
                if ((i + j) == midSize) {
                    if (!hasTwoMidNum) {
                        return isI ? nums1[i] : nums2[j];
                    } else {
                        double result = 0.0;
                        result += isI ? nums1[i] : nums2[j];
                        if (i < size1 && j < size2) {
                            i++;
                            j++;
                            result += (nums1[i] <= nums2[j]) ? nums1[i] : nums2[j];
                        } else if (i < size1) {
                            i++;
                            result += nums1[i];
                        } else if (j < size2) {
                            j++;
                            result += nums1[j];
                        } else {
                            result += !isI ? nums1[i] : nums2[j];
                        }
                        return result / 2;
                    }
                }
                if (nums1[i] <= nums2[j] && i < size1) {
                    i++;
                    isI = true;
                } else {
                    j++;
                    isI = false;
                }
            }
        }
    }

    public void test(){
        Solution solution = new Solution();
        int nums1[] = new int[]{1, 2};
        int nums2[] = new int[]{3};
        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        median.test();
    }
}
