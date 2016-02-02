package highfrequency;

public class HighFrequency {
/*
 * 1. ��� ����λ�ӷ� ��� a ^ b = c, �� a ^ c = b, b ^ c = a
 * 	Ӧ�þ��������������λУ��. ��һ�������У�飬 ��������һ�����ˣ����������������а���У�����������ָ�
 * 
 * 2. Single Number III
 * Given an array of integers, every element appears twice except for two. Find the two singles
 * ˼·�ǰ��������ֳ������� ÿһ������һ��Ψһ��������ͨ�����������ֱ���򣬾Ϳ����������Ψһ������
 * �ֳ������ķ����ǣ��Ƚ���������������õ�һ���������������������ĳһ����λ�����Է�������������һλ�ϣ�����Ψһ������һ����0��
 * һ����1�� �ٸ��ݴˣ����������ֳ�������������ԭ��һ����������ֵ�ͬһ����Ψһ���������ᱻ�ֱ�ֵ�������
 * 
 * 3. �����������������˼·�� һ. ��ǰ�Ӻ�ɨ����;  ��. ����ָ��ͬʱ����βɨ
 * 
 * 4. �������������ʱ�򣬿��������˼�룺
 * Sum[i] = A[1] + A[2] + ..... A[i]
 * Sum[i...j] = Sum[j] - Sum[i - 1]
 * 
 * 5. MaximumSubarray IV:
 * A. Find the subarray which sum equals to zero
 * Ӧ��4��˼�룬���Sum[i]������ת������Sum����ͬ��Ԫ�أ�ʹ��HashMap��O(n)ʱ�䣬 O(n)�ռ�
 * B. Find the subarray which sum is closest to zero
 * Ӧ��4��˼�룬���Sum[i], ����ת������Sum���������Ԫ�أ� sort�� O(nlogn)ʱ��
 * 
 * 6. K Sum
 * �ȴ�������ö�ٳ�k/2��������hashmap�����target�Ĳ�������Ӷ���n��k / 2�η��� �ٴ�������ö��k / 2���������ڲ���hashmap�
 * �����ܸ��ӶȾ���O(pow(n, k / 2));
 * 
 * 7. Quick Questions
 * 	A. Power(x, n)
 * 		���� x �� n / 2 �η���Ȼ��ݹ�����ȥ���������Ӷ�O(logn)
 * 	B. O(2) check power of 2
 * 		x & (x - 1) == 0
 * 
 * 8. ���Ӿ���ĺ����
 * 	Ҳ����4��˼�룬ֻ�����Ƕ�ά�� sub(x1, y1, x2, y2) = sum(x2, y2) + sum(x1, y1) - sum(x2, y1) - sum(x1, y2)
 */
}
