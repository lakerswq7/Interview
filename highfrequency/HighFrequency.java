package highfrequency;

public class HighFrequency {
/*
 * 1. 异或， 不进位加法 如果 a ^ b = c, 则 a ^ c = b, b ^ c = a
 * 	应用就是用冗余磁盘做位校验. 用一块磁盘做校验， 其中任意一个坏了，都可以用其余所有包括校验磁盘异或来恢复
 * 
 * 2. Single Number III
 * Given an array of integers, every element appears twice except for two. Find the two singles
 * 思路是把所有数分成两拨， 每一拨都有一个唯一的数，再通过对两拨数分别异或，就可以求出两个唯一的数。
 * 分成两拨的方法是，先将所有数异或，这样得到一个非零的数，检查这个数的某一非零位，可以分析出来，在这一位上，两个唯一的数，一个是0，
 * 一个是1， 再根据此，把所有数分成两拨。这样，原来一样的数都会分到同一拨，唯一的两个数会被分别分到两拨。
 * 
 * 3. 数组问题多想想以下思路： 一. 从前从后扫两遍;  二. 两个指针同时从首尾扫
 * 
 * 4. 求子数组问题的时候，可以有这个思想：
 * Sum[i] = A[1] + A[2] + ..... A[i]
 * Sum[i...j] = Sum[j] - Sum[i - 1]
 * 
 * 5. MaximumSubarray IV:
 * A. Find the subarray which sum equals to zero
 * 应用4的思想，求出Sum[i]，任务转化成找Sum中相同的元素，使用HashMap，O(n)时间， O(n)空间
 * B. Find the subarray which sum is closest to zero
 * 应用4的思想，求出Sum[i], 任务转化成找Sum中最相近的元素， sort， O(nlogn)时间
 * 
 * 6. K Sum
 * 先从数里面枚举出k/2个数存在hashmap里，存与target的差，这样复杂度是n的k / 2次方。 再从数组里枚举k / 2个数看看在不在hashmap里，
 * 所以总复杂度就是O(pow(n, k / 2));
 * 
 * 7. Quick Questions
 * 	A. Power(x, n)
 * 		先算 x 的 n / 2 次方，然后递归算下去，这样复杂度O(logn)
 * 	B. O(2) check power of 2
 * 		x & (x - 1) == 0
 * 
 * 8. 求子矩阵的和最大
 * 	也是用4的思想，只不过是二维的 sub(x1, y1, x2, y2) = sum(x2, y2) + sum(x1, y1) - sum(x2, y1) - sum(x1, y2)
 */
}
