package codingInterview.Recursion;

public class BoardGame {
    static int counter = 0;
    //static int ladder[] = {0, 0, 13, 11, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int ladder[] = new int[20];

    public static int pdp(int src, int desc, String ans) {//print Board Path
        if (src == desc) {
            System.out.println(++counter + "." + ans);
            return 1;
        }
        //if(src>desc)return 0;//reactive
        int res = 0;
        for (int dice = 1; dice <= 6 && desc >= src + dice; dice++) {
            //pro-reactive
            if (src + dice <= desc)
                res += pdp(src + dice, desc, ans + dice);


        }
        return res;


    }

    public static int pdpwith16(int src, int desc, String ans) {//print Board Path
        if (src == desc) {
            System.out.println(++counter + "." + ans);
            return 1;
        }
        //if(src>desc)return 0;//reactive
        int res = 0;
        for (int dice = 1; dice <= 6 && desc >= src + dice; dice++) {
            //pro-reactive

            if (src + dice <= desc) {

                if (ans == "" && (dice == 1 || dice == 6))
                    res += pdpwith16(src + dice, desc, ans + dice);
                else if (!ans.equalsIgnoreCase("")) res += pdpwith16(src + dice, desc, ans + dice);
            }


        }
        return res;


    }

    public static int pdpwith16Opening(int src, int desc, String ans) {//print Board Path
        if (src == desc) {
            System.out.println(++counter + "." + ans);
            return 1;
        }
        //if(src>desc)return 0;//reactive
        int res = 0;
        for (int dice = 1; dice <= 6 && desc >= src + dice; dice++) {
            //pro-reactive

            if (src + dice <= desc) {

                if (ans == "" && (dice == 1 || dice == 6))
                    res += pdpwith16(src + dice, desc, ans + dice);
                else if (!ans.equalsIgnoreCase("")) res += pdpwith16(src + dice, desc, ans + dice);
            }


        }
        return res;


    }

    public static int pdpwith16Ladder(int src, int desc, String ans) {//print Board Path
        if (src == desc) {
            System.out.println(++counter + "." + ans);
            return 1;
        }
        //if(src>desc)return 0;//reactive
        int res = 0;

        for (int dice = 1; dice <= 6 && desc >= src + dice; dice++) {
            //pro-reactive
            //if(ladder[src]!=0)                src=src+ladder[src];
            if (src + dice <= desc) {
                if (ans == "" && (dice == 1 || dice == 6))
                    res += pdpwith16Ladder(src + dice + ladder[src + dice], desc, ans + "," + dice);
                else if (!ans.equalsIgnoreCase(""))
                    if (ladder[src + dice] != 0)
                        res += pdpwith16Ladder(ladder[src + dice], desc, ans + "," + dice);
                    else
                        res += pdpwith16Ladder(src + dice, desc, ans + "," + dice);

            }


        }
        return res;


    }


    public static void main(String str[]) {
        //System.out.println("-->" + pdp(0,10, ""));
//        System.out.println("-->" + pdpwith16Ladder(0, 15, ""));


    }

}
