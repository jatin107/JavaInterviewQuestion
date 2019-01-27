package org.Fidelity;

import java.util.*;

public class LongestStringChain {
    static Map<String, Integer> pastResult = new HashMap<>();

    private static String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }

    private static int longestStringChain(List<String> dic, String Ques, int ans) {
        int lans = 1, max = ans;
        String changedQues;
        for (int i = 0; i < Ques.length(); i++) {
            changedQues = charRemoveAt(Ques, i);
            if (pastResult.containsKey(changedQues))
                lans = pastResult.get(changedQues) + 1;
            else if (dic.contains(changedQues))
                lans = longestStringChain(dic, changedQues, ans + 1);
            if (!pastResult.containsKey(Ques) || pastResult.get(Ques) < lans)
                pastResult.put(Ques, lans);
            max = lans > max ? lans : max;
        }
        return max;
    }

    private static int longestStringChainDic(List<String> dic) {
        int lans = 0, max = 0;//local Ans,Max value til now
        for (String str : dic) {
            lans = longestStringChain(dic, str, 1);
            max = lans > max ? lans : max;
        }
        return max;
    }

    public static void main(String[] str) {
        List<String> al = new ArrayList<>();
        al = Arrays.asList("a", "b", "ba", "bca", "bda", "bdca");
       /* System.out.println(longestStringChain(al,"ca",1));//Output 2
        System.out.println(longestStringChain(al,"cab",1));//Output 1
        System.out.println(pastResult);//Map*/
        System.out.println(longestStringChainDic(al));//Output 4
        System.out.println(longestStringChain(al,"cab",1));

    }
}
