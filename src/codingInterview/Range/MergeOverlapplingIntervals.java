package codingInterview.Range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "" + start + end + "";
    }
}

public class MergeOverlapplingIntervals {

    public static void main(String str[]) {
        ArrayList<Interval> al = new ArrayList<Interval>();
        al.add(new Interval(2, 6));
        al.add(new Interval(1, 3));

        al.add(new Interval(8, 10));
        al.add(new Interval(15, 18));
        Collections.sort(al, new Comparator<Interval>() {
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        return o1.start - o2.start;
                    }
                }
        );
        ArrayList<Interval> newal = new ArrayList<Interval>();
        newal.add(al.get(0));
        Interval temp;
        for (int i = 1; i < al.size(); i++)
            if (newal.get(newal.size() - 1).end >= al.get(i).start) {
                System.out.println(newal.get(newal.size() - 1).end + ">=" + al.get(i).start);
                temp = newal.get(newal.size() - 1);
                newal.remove(newal.size() - 1);
                if (temp.end < al.get(i).end) {
                    System.out.println("-->" + temp.end + "<" + al.get(i).end + "s" + temp.start);
                    temp.end = al.get(i).end;
                }
                newal.add(temp);

            } else {
                newal.add(al.get(i));
            }

        System.out.println(newal);
        System.out.println(al);


    }


}
