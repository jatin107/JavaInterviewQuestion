package codingInterview.thread;

public class TreeRightView {

	static int rlevel = 0;
	static int llevel = 0;

	public static void rightView(BNode n, int level) {
		if (n == null)
			return;
		if (rlevel == level) {
			rlevel++;
			System.out.println(n.data);
		}

		rightView(n.right, level + 1);
		rightView(n.left, level + 1);

	}

	public static void leftView(BNode n, int level) {
		if (n == null)
			return;
		if (llevel == level) {
			llevel++;
			System.out.println(n.data);
		}

		leftView(n.left, level + 1);
		leftView(n.right, level + 1);

	}

	public static void main(String str[]) {

		BNode bn = new BNode(12);
		bn.left = new BNode(10);
		bn.right = new BNode(30);
		bn.right.left = new BNode(25);
		bn.right.right = new BNode(40);
		// rightView(bn, 0);
		leftView(bn, 0);

	}

}

class BNode {
	public int data;
	public BNode left, right;
	public int level;

	BNode(int d) {
		data = d;
	}

}
