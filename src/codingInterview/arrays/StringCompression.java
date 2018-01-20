package codingInterview.arrays;

public class StringCompression {


    private static String compresed(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(count);
                count = 0;

            }
        }


        return sb.length() > str.length() ? str : sb.toString();
    }


    public static void main(String... str) {

//        System.out.println("Hello World!");
        System.out.println(compresed("intellij"));
        System.out.println(compresed("iiinnnntttteeeellllliiijjjj"));

    }


}
