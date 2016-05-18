package mianjing.snapchat;

public class DoubleSqrt {

	public double sqrt(int num) {
		if (num <= 0) {
			return 0;
		}
		final double precision = 0.0001;
		double low = 0;
		double high = num;
		double root = low + (high - low) / 2;
		while (Math.abs(root * root - num) > precision) {
			if (root * root == num) {
				return root;
			}
			if (root * root < num) {
				low = root;
			} else {
				high = root;
			}
			root = low + (high - low) / 2;
		}
		return root;
	}
	public static void main(String[] args) {
		DoubleSqrt s = new DoubleSqrt();
		System.out.println(s.sqrt(36));
	}
}
