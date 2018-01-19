package codingInterview.arrays;

public class OneAway {


    private static boolean oneEditAway(String s, String t) {
        if (s.length() == t.length())
            return replace(s, t);
        if (s.length() + 1 == t.length())
            return insert(s, t);
        if (t.length() + 1 == s.length())
            return insert(t, s);
        return false;
        //space: O(N) time: O(N)
    }

    private static boolean replace(String s, String t) {
        boolean onereplace = false;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == t.charAt(i))
                continue;
            if (onereplace)
                return false;
            onereplace = true;
        }
        return true;
        //space: O(1) time: O(N)
    }

    private static boolean insert(String s, String t) {

        int index1 = 0, index2 = 0;
        while (index1 < s.length() && index2 < t.length()) {
            if (s.charAt(index1) != t.charAt(index2)) {
                if (index1 != index2)
                    return false;
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
        //space: O(1) time: O(N)
    }


    public static void main(String... str) {

//        System.out.println("Hello World!");
        System.out.println(oneEditAway("jatin", "jitin"));
        System.out.println(oneEditAway("jatin", "jtin"));
        System.out.println(oneEditAway("tin", "jtin"));
        System.out.println(oneEditAway("tin", "jatin"));

    }


}
