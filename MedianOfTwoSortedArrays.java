class Solution {
    /* Given two sorted arrays nums1 and nums2 of size m and n respectively,
       return the median of the two sorted arrays.
       The overall run time complexity should be O(log (m+n)).
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int[] A  = nums1, B = nums2;
        int loA = 0, hiA = A.length - 1;
        int half = Math.floorDiv(A.length + B.length, 2);
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;

        while (true) {
            int midA = Math.floorDiv(loA + hiA, 2);
            int midB = half - midA - 2;

            int AL = midA >= 0 ? A[midA] : min;
            int AR = midA < A.length - 1 ? A[midA+1] : max;
            int BL = midB >= 0 ? B[midB] : min;
            int BR = midB < B.length - 1 ? B[midB+1] : max;

            if (AL <= BR && BL <= AR) {
                if ((A.length + B.length) % 2 == 0) {
                    return (Math.max(AL, BL) + Math.min(AR, BR)) / 2.0;
                } else {
                    return Math.min(AR, BR);
                }
            } else if (AL > BR) {
                hiA = midA - 1;
            } else {
                loA = midA + 1;
            }
        }
    }
}