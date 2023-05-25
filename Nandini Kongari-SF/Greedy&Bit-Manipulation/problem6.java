import java.util.*;

public class problem6 {
    public static int getSignleNumber(int n, int[] arr) {
        int[][] matBin = new int[n][32];
        for (int i = 0; i < n; i++) {
            String s = Integer.toBinaryString(arr[i]);
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            for (int j = 0; j < s.length(); j++) {
                matBin[i][31-j] = (sb.charAt(j)=='0')?0:1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (matBin[j][i] == 1) {
                    count++;
                }
            }
            if (count % 3 == 0) {
                sb.append(0);
                continue;
            }
            sb.append(1);
        }
        return Integer.parseInt(sb.toString(),2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getSignleNumber(n, arr));
    }
}
