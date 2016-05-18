package mianjing.snapchat;

import java.util.*;

public class WordAbbr {
	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		input.add("like");
		input.add("god");
		input.add("internal");
		input.add("me");
		input.add("internet");
		input.add("interval");
		input.add("intension");
		input.add("face");
		input.add("intrusion");
		for (String o : getAbbr(input)) {
			System.out.println(o);
		}
		
	}
	public static ArrayList<String> getAbbr(ArrayList<String> input) {
		if (input == null || input.size() == 0) {
			return input;
		}
		ArrayList<String> output = new ArrayList<String>();
		HashMap<String, TrieNode> trieMap = buildTrie(input);
		for (String i : input) {
			TrieNode root = trieMap.get(transfer(i));
			output.add(retrieve(root, i));
		}
		return output;
	}
	private static String retrieve(TrieNode root, String s) {
		for (int i = 0; i < s.length(); i++) {
			if (root.keys[s.charAt(i) - 'a'].wordCount == 1) {
				if (i < s.length() - 3) {
					return s.substring(0, i + 1) + s.length() + s.charAt(s.length() - 1);
				} else {
					return s;
				}
			}
			root = root.keys[s.charAt(i) - 'a'];
		}
		return s;
	}
	private static HashMap<String, TrieNode> buildTrie(ArrayList<String> input) {
		HashMap<String, TrieNode> map = new HashMap<String, TrieNode>();
		for (String i : input) {
			String abbr = transfer(i);
			if (!map.containsKey(abbr)) {
				map.put(abbr, new TrieNode());
			}
			insertToTrie(i, map.get(abbr));
		}
		return map;
	}
	private static String transfer(String s) {
		if (s.length() <= 3) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		sb.append(s.length());
		sb.append(s.charAt(s.length() - 1));
		return sb.toString();
	}
	private static void insertToTrie(String s, TrieNode root) {
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (root.keys[cur - 'a'] == null) {
				root.keys[cur - 'a'] = new TrieNode();
			}
			root = root.keys[cur - 'a'];
			root.wordCount++;
		}
		root.isKey = true;
	}
}
class TrieNode {
	int wordCount;
	boolean isKey;
	TrieNode[] keys;
	TrieNode() {
		wordCount = 0;
		isKey = false;
		keys = new TrieNode[26];
	}
}