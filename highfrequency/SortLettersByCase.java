package highfrequency;

/*
 * http://www.lintcode.com/en/problem/sort-letters-by-case/
 */
public class SortLettersByCase {
    public void sortLetters(char[] chars) {
        if ((chars == null) || (chars.length < 2)) {
            return;
        }
        int upper = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] > 'Z') {
                char temp = chars[i];
                chars[i] = chars[upper];
                chars[upper] = temp;
                upper++;
            } 
        }
    }
}
