package codingInterview.arrays;

public class IsUniqueCharacters {


    static boolean isUnique1(String str) {

        if (str.length() > 128)
            return false;

        boolean bool[] = new boolean[128];
        for (int i = 0; i < str.length(); i++) {

            if (bool[str.charAt(i)])
                return false;
            else bool[str.charAt(i)] = true;


        }
        return true;
        //space: O(1) time: O(1)
    }

    static boolean isUnique2(String str) {

        int checker = 0, val;

        for (int i = 0; i < str.length(); i++) {
            val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0)
                return false;
            checker |= 1 << val;


        }
        return true;
        //space: O(1) time: O(1)
    }

    public static void main(String... str) {

//        System.out.println("Hello World!");
        System.out.println("jatin " + isUnique2("jatin"));
        System.out.println("sagar " + isUnique2("sagar"));
    }


}
