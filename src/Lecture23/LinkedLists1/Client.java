package Lecture23.LinkedLists1;

public class Client {

	public static void main(String[] args) throws Exception {
		LikedList list = new LikedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(40);
		list.addFirst(5);
		list.addNodeAt(2, 4);
		list.display();
		// list.removeFirst();
		list.display();
		// list.removeLast();
		list.display();
		list.removeAt(2);
		list.display();

		/*
		 * System.out.println(list.getFirst()); System.out.println(list.getLast());
		 * System.out.println(list.getAt(2));
		 */

	}

}
