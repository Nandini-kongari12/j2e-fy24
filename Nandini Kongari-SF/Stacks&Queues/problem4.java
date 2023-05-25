
// Not completed ..............................................
import java.util.PriorityQueue;
import java.util.Scanner;

public class problem4 {
    static class kp {
        int key, value, freq;

        kp(int k, int v) {
            key = k;
            value = k;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();
        PriorityQueue<kp> pq = new PriorityQueue<>(cap);
        int qeuries = sc.nextInt();
        for (int i = 0; i < qeuries; i++) {
            System.out.print("For SET-->0, GET-->1: ");
            switch (sc.nextInt()) {
                case 0:

                    break;
                case 1:

                    break;
                default:
                    break;
            }
        }
    }
}
