
import java.util.*;
public class problem4 {
    public static void moveDisks(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk from rod " + source + " to rod " + destination);
            return;
        }
        moveDisks(n - 1, source, auxiliary, destination);
        System.out.println("Move disk from rod " + source + " to rod " + destination);
        moveDisks(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        char source = '1';
        char destination = '3';
        char auxiliary = '2';

        moveDisks(N, source, destination, auxiliary);
    }
}
