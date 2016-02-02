package search;

import java.util.ArrayList;
/*
 * http://www.lintcode.com/zh-cn/problem/search-a-2d-matrix-ii/
 * 每一行的第一个不再严格大于上一行的最后一个，而是只是保证按照每一行和每一列严格递增的关系
 * 例子：
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
        // 从左下角开始往右上走
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
