package codingInterview.Recursion;

public class BoardGameNew {
    static int counter = 0;
    static int ladder[] = new int[16];
    static int SnL[] = new int[20];

    public static int pdpwith16Opening(int src, int desc, String ans) {//print Board Path
        if (src == desc) {
            System.out.println(++counter + "." + ans);
            return 1;
        }
        //if(src>desc)return 0;//reactive
        int res = 0;
        if (src == 0) {
            pdpwith16Opening(1, desc, ans + "1");
            pdpwith16Opening(1, desc, ans + "6");
        } else
            for (int dice = 1; dice <= 6 && desc >= src + dice; dice++) {
                //pro-reactive

                if (src + dice <= desc) {


                    res += pdpwith16Opening(src + dice, desc, ans + dice);
                }


            }
        return res;


    }

    public static int pdpwith16OpeningwithLadder(int src, int desc, String ans) {//print Board Path
        if (src == desc) {
            System.out.println(++counter + "." + ans);
            return 1;
        }
        //if(src>desc)return 0;//reactive
        int res = 0;
        if (src == 0) {
            pdpwith16OpeningwithLadder(1, desc, ans + "1");
            pdpwith16OpeningwithLadder(1, desc, ans + "6");
        } else
            for (int dice = 1; dice <= 6 && desc >= src + dice; dice++) {
                //pro-reactive

                if (src + dice <= desc) {
                    if (ladder[src + dice] != 0)
                        res += pdpwith16OpeningwithLadder(ladder[src + dice], desc, ans + dice);
                    else
                        res += pdpwith16OpeningwithLadder(src + dice, desc, ans + dice);
                }


            }
        return res;


    }

    public static int pdpwith16OpeningwithSnL(int src, int desc, int[] moves, int movesindex) {//print Board Path
        if (src == desc) {
            System.out.println("Win");
            return 0;
        }
        if (movesindex == moves.length) {
            System.out.println(src);
            return src;
        }
        if (src == 0) {
            if (moves[movesindex] == 1 || moves[movesindex] == 6)
                return pdpwith16OpeningwithSnL(1, desc, moves, movesindex + 1);
            else
                return pdpwith16OpeningwithSnL(0, desc, moves, movesindex + 1);

        } else {

            if (SnL[src] != 0) {
                return pdpwith16OpeningwithSnL(SnL[src], desc, moves, movesindex);//no inc in moves index
            } else {
                if (moves[movesindex] + src > desc)
                    return pdpwith16OpeningwithSnL(src, desc, moves, movesindex + 1);
                else
                    return pdpwith16OpeningwithSnL(src + moves[movesindex], desc, moves, movesindex + 1);


            }


        }


    }


    public static void main(String str[]) {
        //System.out.println("-->" + pdp(0,10, ""));
        ladder[2] = 13;
        ladder[3] = 11;
        ladder[5] = 7;
        SnL[19] = 2;

        SnL[13] = 5;
        SnL[3] = 17;
        SnL[7] = 11;


//        System.out.println("-->" + pdpwith16OpeningwithLadder(0, 15, ""));
        int[] input1 = {2, 5, 3, 4, 6, 3, 4, 3, 5, 1, 2, 3};
        int[] input2 = {2, 5, 3, 4, 6, 3, 4, 3, 5, 1, 1, 6, 5, 2, 3, 5};
        System.out.println("-->" + pdpwith16OpeningwithSnL(0, 20, input1, 0));
        System.out.println("-->" + pdpwith16OpeningwithSnL(0, 20, input2, 0));


    }

}
