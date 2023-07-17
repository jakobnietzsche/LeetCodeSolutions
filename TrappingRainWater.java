public class TrappingRainWater {
    /* Given n non-negative integers representing an elevation map where the width of each bar is 1,
       compute how much water it can trap after raining.
     */

    public int trap(int[] height) {
        int res = 0;
        int lo = 0, hi = height.length - 1;
        int maxLo = height[lo], maxHi = height[hi];

        while (lo < hi) {
            if (maxLo <= maxHi) {
                maxLo = Math.max(maxLo, height[++lo]);
                res += maxLo - height[lo];
            } else {
                maxHi = Math.max(maxHi, height[--hi]);
                res += maxHi - height[hi];
            }
        }
        return res;
    }
}
