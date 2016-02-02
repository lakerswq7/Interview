package dp;
/*
 * http://www.lintcode.com/zh-cn/problem/longest-increasing-subsequence/
 * 0. �������� ������½������еĳ��ȣ� sequence -> dp
 * 1. f[i] -> ����Ϊi + 1��LIS�����һ������С��Ϊ��
 * 2. f[i] -> �����쵽j���λ�õ�ʱ�򣬴�����f[i]���ҵ��ĵ�һ����nums[j]�������λ��Ϊi��ʱ��͸���f[i]��ֵΪnums[j]
 * �����ǣ�ʵ�����������һ������С�ģ��������԰����LIS��λ�ü�һ������nums[j]
 * 3. ����f[i]��ΪInteger.MAX_VALUE
 * 4. ��һ������len��¼��ǰ����LIS�� ɨ��һ���Ժ󣬷���len
 * 
 * ������Ż��㷨�����Ӷ�O(nlogn)
 * �����һ��dp�Ļ���ҪO(n^2),��ɨһ���ͬʱ����Ҫɨ����ַ�֮ǰ������
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
    // ���ֲ����ҵ�һ����target���λ��
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
