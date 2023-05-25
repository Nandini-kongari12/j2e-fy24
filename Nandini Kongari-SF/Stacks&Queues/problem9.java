import java.util.*;
public class problem9 {
    static int i=0;
    List<Integer>l;
    public problem9() {
        l=new ArrayList<Integer>();
        i=0;
    }
    
    public int next(int price) {
        l.add(price);
        int res=0;
        for(int k=i;k>=0;k--){
            if(l.get(k)<=price) res++;
            else break;
        }
        i++;
        return res;
    }
    public static void main(String[] Agrs){
        problem9 spanner=new problem9();
        System.out.print(spanner.next(100)+" ");
        System.out.print(spanner.next(80)+" ");
        System.out.print(spanner.next(60)+" ");
        System.out.print(spanner.next(70)+" ");
        System.out.print(spanner.next(60)+" ");
        System.out.print(spanner.next(75)+" ");
        System.out.print(spanner.next(85)+" ");
    }
}
