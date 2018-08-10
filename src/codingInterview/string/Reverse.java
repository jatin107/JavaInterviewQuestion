package codingInterview.string;

public class Reverse {

	static public void reverse(char ch[]) {

		char temp;

		for (int start = 0, end = ch.length - 1; start < end; start++, end--) {
			temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
		}

	}

	static public void reverseResercive(char ch[], int start, int end) {

		if (start >= end)
			return;

		char temp;
		temp = ch[start];
		ch[start] = ch[end];
		ch[end] = temp;
		reverseResercive(ch, start + 1, end - 1);

	}

	public static void main(String[] args) {
		char ch[] = "jatin".toCharArray();
//		reverse(ch);
		reverseResercive(ch, 0, 4);
		System.out.println(new String(ch));

	}

}
