package Lecture26.GenericTrees1;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private int size;

	public boolean isEmpty() {// Abstraction > no need to evaluate further
		return this.size == 0;
	}

	public int size() {// Data hiding
		return this.size;
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		int count = 1;
		for (Node child : node.children) {
			// faith
			count += size2(child);
		}
		return count;

	}

	public void display() {
		display(root);
	}

	// Expectation
	private void display(Node node) {
		String str = node.data + "-->";
		for (Node child : node.children) {
			str += child.data + ",";
		}
		str += ".";
		System.out.println(str);
		// Faith > on smaller problem
		for (Node child : node.children) {
			display(child);
		}

	}

	private Node root;

	GenericTree() {

		Scanner sc = new Scanner(System.in);
		construct(sc, null, 1);
	}

// Expectation > to create ith child for parent node
	private Node construct(Scanner sc, Node parent, int i) {
		if (parent == null) {
			System.out.println("Enter the data for Parent");

		} else {
			System.out.println("Enter the date for " + i + " th child of" + parent.data);
		}

		int cdata = sc.nextInt();
		Node child = new Node();
		child.data = cdata;

		System.out.println("Enter the number of  children for" + child.data);
		int numgc = sc.nextInt();

		for (int j = 0; j < numgc; j++) {
			// Faith
			Node gc = construct(sc, child, j);
			child.children.add(gc);
		}

		return child;

	}

}
