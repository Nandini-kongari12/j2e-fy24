import java.util.*;

public class problem10 {
    public static long reverseBits(int n) {
        int res = 0;
        String bin = Integer.toBinaryString(n);
        System.out.println(bin);
        int len=bin.length();
        int count=32-len;
        StringBuilder sb=new StringBuilder(bin);
        sb.reverse();
        while(count>0){
            sb.append('0');
            count--;
        }
        System.out.println(sb+" Length: "+sb.length());
        return Long.parseLong(sb.toString(),2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(reverseBits(n));
    }
}