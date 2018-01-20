package codingInterview.arrays;

public class PalindromePermutation {


    private static boolean checkPalindromePermutation1(String str) {
        int table[] = buildFrequencyTable(str);
        return booleancheckMaxOddOne(table);

        //space: O(1) time: O(N)
    }

    private static boolean booleancheckMaxOddOne(int table[]) {
        boolean first = false;
        for (int t : table) {
            if (t % 2 != 0) {
                if (first)
                    return false;
                first = true;

            }
        }
        return true;
        //space: O(1) time: O(N)
    }

    private static int[] buildFrequencyTable(String str) {
        int table[] = new int[getCharNumber('z') - getCharNumber('a') + 1];
        for (char c : str.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) table[x]++;

        }
        return table;
        //space: O(1) time: O(N)
    }

    private static boolean checkPalindromePermutation2(String str) {
        int countOdd = 0;
        int table[] = new int[getCharNumber('z') - getCharNumber('a') + 1];
        for (char c : str.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1)
                    countOdd++;
                else countOdd--;

            }

        }
        return countOdd <= 1;
        //space: O(1) time: O(N)
    }

    private static boolean checkPalindromePermutation3(String str) {
<<<<<<< HEAD
        int bitVector = createBitVector(str);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
        //space: O(1) time: O(N)
    }

    private static boolean checkExactlyOneBitSet(int vec) {
        return (vec & (vec - 1)) == 0;
    }

    private static int createBitVector(String vec) {
        int bitvector = 0;
        for (char c : vec.toCharArray()) {
            bitvector = toggle(bitvector, getCharNumber(c));

        }
        return bitvector;
    }

    private static int toggle(int vec, int index) {
        if (index < 0) return vec;
        int mask = 1 << index;
        if ((vec & mask) == 0)
            vec |= mask;
        else
            vec &= ~mask;
        return vec;
=======
>>>>>>> origin/master
    }


    private static int getCharNumber(char c) {
        int val = Character.getNumericValue(c);
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        if (a <= val && z >= val) {
            return val - a;
        } else
            return -1;

        //space: O(1) time: O(1)
    }


    public static void main(String... str) {

//        System.out.println("Hello World!");
        System.out.println(checkPalindromePermutation1("nitin"));
        System.out.println(checkPalindromePermutation1("jatin"));

        System.out.println(checkPalindromePermutation2("nitin"));
        System.out.println(checkPalindromePermutation2("jatin"));
<<<<<<< HEAD
        System.out.println(checkPalindromePermutation3("abc"));
=======
>>>>>>> origin/master


    }


}
