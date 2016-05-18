package mianjing.snapchat;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MakeFriends {

	public ArrayList<People> makeFriends(int n, int k) {
		ArrayList<People> peoples = new ArrayList<People>();
		Deque<People> queue = new LinkedList<People>();
		for (int i = 0; i < n; i++) {
			People p = new People(i, 0);
			peoples.add(p);
			queue.add(p);
		}
		if (n <= 0 || k <= 0 || (n * k) % 2 == 1) {
			return peoples;
		}
		while (!queue.isEmpty()) {
			People cur = queue.remove();
			while (cur.friend < k) {
				People next = queue.remove();
				cur.friend++;
				cur.friends.add(next.num);
				next.friend++;
				next.friends.add(cur.num);
				if (next.friend < k) {
					queue.add(next);
				}
			}
		}
		return peoples;
	}
	class People {
		int num;
		int friend;
		ArrayList<Integer> friends;
		People (int num, int friend) {
			this.num = num;
			this.friend = friend;
			friends = new ArrayList<Integer>();
		}
	}
	public static void main(String[] args) {
		MakeFriends test = new MakeFriends();
		for (People p : test.makeFriends(4, 2)) {
			System.out.println(p.num);
			for (int i : p.friends) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
