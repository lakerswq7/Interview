package mianjing.snapchat;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return one such possible sentences.

s = "catsanddog", dict = ["cat", "cats", "and", "dog"], return ¡°cats and dog"£»

Clarification:

Q: What to return if s can¡¯t be splitted into words in dict? A: Return NULL;
Q: What if there are multiple ways of splitting s? A: Return one split solution is fine;  
Q: What if S is null/empty string? A: Return NULL; - So on and so fort.
 */
public class OneWordBreak {

	public String wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return null;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		return dfs(set, s, dict, 0);
	}
	private String dfs(HashSet<Integer> set, String s, Set<String> dict, int pos) {
		if (set.contains(pos)) {
			return null;
		}
		for (int i = pos; i < s.length(); i++) {
			String left = s.substring(pos, i + 1);
			if (dict.contains(left)) {
				if (i == s.length() - 1) {
					return left;
				}
				String right = dfs(set, s, dict, i + 1);
				if (right != null) {
					return left + " " + right;
				}
			}
		}
		set.add(pos);
		return null;
	}
	public static void main(String[] args) {
		String s = "catcatsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("dog");
		OneWordBreak sol = new OneWordBreak();
		System.out.println(sol.wordBreak(s, dict));
	}
}
