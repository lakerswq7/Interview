package datastructure;

public class DataStructure {
/*
 * 1. ��һ��������ĳһ��ֵǰ�������һ������ С/�� ��ֵ�����ߺ������һ������ С/�� ��ֵ��������Ҫ��ջ
 * 2. HashTable�̰߳�ȫ����HashMapЧ�ʸ��ߣ��������˼��HashTable����ʵ�ֵ�ʱ��ͼ����ˣ���HashMapû�ӣ�
 * 	  ��Ҫ��ʱ����Դ��Լ���һ������� HashTable��, key��value�����������null�� ��HashMap���ԣ���null��key
 *    ֻ����һ��
 * 3. ����NoSql������ɾ�����Ҷ���O(1), ��relational database��B-Treeʵ�֣�����O(logn)
 * 4. hash����Ŀ������collision������С
 * 5. �����ͻ�İ취�����֣� open hashing - linkedlist�� closed hashing - array
 * 	  open hashing �� ������������ֳ�ͻ�Ͱ������������ֻ��Ҫ��ͷ��ÿ�β���ͷ������һ��ͷ������
 * 	  closed hashing �� ֻ�����飬 ���ֳ�ͻ�ͷ�����һ�����õ�λ�ã�����ʵ�ֲ�֧��ɾ����һ�㲻��
 * 6. rehashing�� ������ݵ��������������Ĵ�С�� 1/10�� ���ܾ���Ҫrehashing������Ϳ��ܳ�ͻ̫���ˣ������ˡ�
 * 	  ��Ҫ��̬���������С����ArrayList��ʵ�ֲ�࣬Ҳ�Ƿ�һ����������������ÿ�� 1 / 10 ���ͷ�һ���� ��Ҫ����
 * 	  ��������Ԫ�أ����¼�������key�� ������̺�����
 * 7. ArrayList ����ÿ��size�Ժ󣬴�С��һ��
 * 8. Heap�� Add Remove O(log n); Min/Max O(1)
 * 9. Median number: numbers keep coming, return the median number. ʹ�������ѣ�һ����С��һ������
 * 		ά����λ���� ��������С�����ѣ��������������С��
 */
	
	//Typical: From string to int.
	int hashfunc(String key) {
	// do something to key
	// return a deterministic integer number return md5(key) % hash_table_size; md5Ч�ʵ�
		return 0;
	}
	
	int HASH_TABLE_SIZE = 2;
	// Magic Number 33
	// short url��������ô��ƣ���Ϊ��Ҫ����˫���ת��������ת��������ʱ�򣬿��ܳ�������url��Ӧһ��short url�������
	// ����short urlӦ���ǵ����ı��룬�����г�ͻ
	int hashfunc2(String key) {
		int sum = 0;
		for (int i = 0; i < key.length(); i++) {
			sum = sum * 33 + (int)(key.charAt(i));
			sum = sum % HASH_TABLE_SIZE;
		}
		return sum;
	}

}
