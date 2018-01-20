package codingInterview.arrays;

public class StringRotation {


    private static boolean isRotation(String s, String t) {
        if (t.length() != s.length() && s.length() != 0) return false;

        return (s + s).contains(t);

        //space: O(N) time: O(N) ifcontains work in (2N+M)
    }


    public static void main(String... str) {

//        System.out.println("Hello World!");
        System.out.println(isRotation("jatin", "tinja"));
        System.out.println(isRotation("jatin", "tinaj"));

    }


}

