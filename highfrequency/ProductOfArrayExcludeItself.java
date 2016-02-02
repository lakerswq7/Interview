package highfrequency;

import java.util.ArrayList;

/*
 * http://www.lintcode.com/en/problem/product-of-array-exclude-itself/
 */
public class ProductOfArrayExcludeItself {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        if ((A == null) || (A.size() < 2)) {
            return result;
        }
        ArrayList<Long> left = new ArrayList<Long>();
        ArrayList<Long> right = new ArrayList<Long>();
        left.add((long)1);
        right.add((long)1);
        for (int i = 1; i < A.size(); i++) {
            left.add((long)A.get(i - 1) * left.get(i - 1));
        }
        for (int i = A.size() - 2; i >= 0; i--) {
            right.add(0, (long)A.get(i + 1) * right.get(0));
        }
        
        for (int i = 0; i < A.size(); i++) {
            result.add(left.get(i) * right.get(i));
        }
        return result;
    }
}
