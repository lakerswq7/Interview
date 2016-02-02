package search;

import java.util.ArrayList;
/*
 * http://www.lintcode.com/zh-cn/problem/search-a-2d-matrix-ii/
 * ÿһ�еĵ�һ�������ϸ������һ�е����һ��������ֻ�Ǳ�֤����ÿһ�к�ÿһ���ϸ�����Ĺ�ϵ
 * ���ӣ�
 * [
    [1, 3, 5, 7],

    [2, 4, 7, 8],

    [3, 5, 9, 10]
 * ]
 */
public class SearchA2DMatrixII {
    public int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        if ((matrix == null) || (matrix.size() == 0) || (matrix.get(0).size() == 0)) {
            return 0;
        }
        int cols = matrix.get(0).size();
        int rows = matrix.size();
        // �����½ǿ�ʼ��������
        int m = 0;
        int n = rows - 1;
        int count = 0;
        while ((m < cols) && (n >= 0)) {
            int temp = matrix.get(n).get(m);
            if (temp == target) {
                m++;
                n--;
                count++;
            } else if (temp > target) {
                n--;
            } else {
                m++;
            }
        }
        return count;
    }
}
