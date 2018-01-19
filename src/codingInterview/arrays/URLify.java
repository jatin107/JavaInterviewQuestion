package codingInterview.arrays;

public class URLify {


    static String replaceSpace(String str) {

        int spaceCount = 0, newIndex = 0;
        char ch[] = str.toCharArray();
        for (int i = 0; i < ch.length; i++)
            if (ch[i] == ' ')
                spaceCount++;

        newIndex = ch.length + spaceCount * 2;
        char chNew[] = new char[newIndex];
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] == ' ') {
                chNew[newIndex - 1] = '0';
                chNew[newIndex - 2] = '2';
                chNew[newIndex - 3] = '%';
                newIndex -= 3;

            } else {
                chNew[newIndex - 1] = ch[i];
                newIndex--;
            }

        }

        return new String(chNew);
        //space: O(N) time: O(N)
    }


    public static void main(String... str) {

//        System.out.println("Hello World!");
        System.out.println(replaceSpace("Mr Jatin Goyal   "));
        System.out.println(replaceSpace("sagar"));
    }


}
