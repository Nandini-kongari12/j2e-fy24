import java.util.*;
public class problem1 {
    static void printKLengthString(char set[], String seq, int n, int k) {
        if (k == 0){
           System.out.println(seq);
           return;
        }
        for (int i = 0; i < n; i++){
           String newSeq;
           newSeq=seq+set[i];
           printKLengthString(set, newSeq, n, k - 1);
        }
     }
    public static void main(String[] Args){
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        char[] ch=new char[s.length];
        for(int i=0;i<s.length;i++){
            ch[i]=s[i].charAt(0);
        }
        int k=sc.nextInt();
        printKLengthString(ch,"", ch.length,k);
    }
}
