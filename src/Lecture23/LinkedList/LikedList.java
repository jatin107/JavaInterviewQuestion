package Lecture23.LinkedList;

public class LikedList {

	private class Node {
		private int data;
		private Node next;

	}

	private Node head;
	private Node tail;
	private int size;

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addLast(int data) {

		if (size == 0) {
			this.handleSizeZero(data);
			return;
		}

		// Last Knowledge
		Node node = new Node();
		node.data = data;
		node.next = null;
		// Properties
		tail.next = node;

		// summery
		tail = node;
		this.size++;

	}

	public void addFirst(int data) {

		if (size == 0) {
			this.handleSizeZero(data);

		}

		// Last Knowledge
		Node node = new Node();
		node.data = data;
		node.next = head;
		// Properties

		// summery
		head = node;
		this.size++;

	}

	private void handleSizeZero(int data) {

		// Last Knowledge
		Node node = new Node();
		node.data = data;
		node.next = null;

		// summery
		head = tail = node;
		this.size++;

	}

	public void display() {
		// this as passed in Oops
		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.data + "-->");
			ptr = ptr.next;
		}
		System.out.println();

	}

	public int getFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("Size is Empty");
		return head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0)
			throw new Exception("Size is Empty");
		return tail.data;
	}

	public int getAt(int i) throws Exception {
		if (this.size == 0)
			throw new Exception("Size is Empty");
		else if (i < 0 || i >= size)
			throw new Exception("Index out of Bound");
		Node temp = head;
		for (int k = 0; k < i; k++) {
			temp = temp.next;

		}
		return temp.data;
	}

	public int removeAt(int i) throws Exception {
		if (this.size == 0)
			throw new Exception("Size is Empty");
		else if (i < 0 || i >= size)
			throw new Exception("Index out of Bound");
		else if (i == 0)
			return removeFirst();
		else if (i == size - 1)
			return removeLast();
		else {
			Node node = getNodeAt(i - 1);
			Node nodep1 = node.next.next;
			node.next = nodep1;
			size--;

		}
		return -1;
	}

	public void addNodeAt(int i, int data) throws Exception {
		if (this.size == 0)
			addFirst(data);
		else if (i == size)
			addLast(data);
		else if (i > size || i < 0)
			throw new Exception("illegal Argument Exception.");
		else {
			Node nodeAtm1 = getNodeAt(i - 1);
			Node nodeAt = nodeAtm1.next;
			Node newNode = new Node();
			newNode.data = data;
			newNode.next = nodeAt;
			nodeAtm1.next = newNode;
		}

	}

	private Node getNodeAt(int i) throws Exception {
		if (this.size == 0)
			throw new Exception("Size is Empty");
		else if (i < 0 || i >= size)
			throw new Exception("Index out of Bound");
		Node temp = head;
		for (int k = 0; k < i; k++) {
			temp = temp.next;

		}
		return temp;
	}

	public int removeFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("Size is Empty");
		else if (this.size == 1) {
			return this.handleWhenZiseIs1();
		} else {
			int val = head.data;
			head = head.next;
			this.size--;
			return val;
		}

	}

	private int handleWhenZiseIs1() {
		int val = head.data;
		head = tail = null;
		this.size--;
		return val;

	}

	public int removeLast() throws Exception {
		if (this.size == 0)
			throw new Exception("Size is Empty");
		else if (this.size == 1) {
			return this.handleWhenZiseIs1();
		} else {
			int val = tail.data;
			Node node = getNodeAt(size - 1);
			node.next = null;
			tail = node;
			return val;
		}

	}
}
