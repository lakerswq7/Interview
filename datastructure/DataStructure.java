package datastructure;

public class DataStructure {
/*
 * 1. 求一个数组中某一个值前面最近的一个比他 小/大 的值，或者后面最近一个比他 小/大 的值，往往需要用栈
 * 2. HashTable线程安全，但HashMap效率更高，这里的意思是HashTable在它实现的时候就加锁了，而HashMap没加，
 * 	  需要的时候可以从自己这一层加锁。 HashTable中, key和value都不允许出现null。 而HashMap可以，但null的key
 *    只能有一个
 * 3. 所以NoSql，插入删除查找都是O(1), 而relational database是B-Tree实现，都是O(logn)
 * 4. hash函数目的是让collision减到最小
 * 5. 解决冲突的办法有两种： open hashing - linkedlist； closed hashing - array
 * 	  open hashing ： 数组存链表，出现冲突就把它存在链表里，只需要存头，每次插在头，更新一下头就行了
 * 	  closed hashing ： 只用数组， 出现冲突就放在下一个可用的位置，这种实现不支持删除。一般不用
 * 6. rehashing： 存的数据的数量与如果数组的大小比 1/10， 可能就需要rehashing，否则就可能冲突太多了，就慢了。
 * 	  需要动态增加数组大小。与ArrayList的实现差不多，也是翻一倍，就是数据数量每到 1 / 10 ，就翻一倍， 需要重新
 * 	  遍历所有元素，重新计算所有key， 这个过程很慢。
 * 7. ArrayList 就是每到size以后，大小翻一倍
 * 8. Heap： Add Remove O(log n); Min/Max O(1)
 * 9. Median number: numbers keep coming, return the median number. 使用两个堆，一个最小堆一个最大堆
 * 		维护中位数， 左面存比它小的最大堆，右面存比它大的最小堆
 */
	
	//Typical: From string to int.
	int hashfunc(String key) {
	// do something to key
	// return a deterministic integer number return md5(key) % hash_table_size; md5效率低
		return 0;
	}
	
	int HASH_TABLE_SIZE = 2;
	// Magic Number 33
	// short url不可以这么设计，因为需要的是双向的转换，这样转换回来的时候，可能出现两个url对应一个short url的情况，
	// 所以short url应该是递增的编码，不能有冲突
	int hashfunc2(String key) {
		int sum = 0;
		for (int i = 0; i < key.length(); i++) {
			sum = sum * 33 + (int)(key.charAt(i));
			sum = sum % HASH_TABLE_SIZE;
		}
		return sum;
	}

}
