package dp;
/*
 * http://www.lintcode.com/zh-cn/problem/longest-increasing-subsequence/
 * 0. 不能排序， 求最长不下降子序列的长度， sequence -> dp
 * 1. f[i] -> 长度为i + 1的LIS的最后一个数最小能为几
 * 2. f[i] -> 当考察到j这个位置的时候，从所有f[i]中找到的第一个比nums[j]大的数的位置为i的时候就更新f[i]的值为nums[j]
 * 道理是，实际上是找最后一个比他小的，这样可以把这个LIS的位置加一，赋成nums[j]
 * 3. 所有f[i]都为Integer.MAX_VALUE
 * 4. 用一个变量len记录当前最大的LIS， 扫完一遍以后，返回len
 * 
 * 这个是优化算法，复杂度O(nlogn)
 * 如果是一般dp的话需要O(n^2),即扫一遍的同时，需要扫这个字符之前的所有
 */
public class LongestIncreasingSubsequence {
    public int longestIncreasingSubsequence(int[] nums) {
        int len = 0;
        int[] lis = new int[nums.length];
        for (int i = 0; i < lis.length; i++) {
            lis[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            int pos = findPos(lis, nums[i], 0, len);
            lis[pos] = nums[i];
            if (pos == len) {
                len++;
            }
        }
        return len;
    }
    // 二分查找找第一个比target大的位置
    public int findPos(int[] lis, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (lis[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (lis[start] > target) {
            return start;
        } else {
            return end;
        }
    }
}
