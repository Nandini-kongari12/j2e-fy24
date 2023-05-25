import java.util.*;
class graph5 {
    public static int kthSmallest(int[][] matrix, int k) {
        Map<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
            }
        }

        for(int n : map.keySet()) {
            k -= map.get(n);

            if(k <= 0) {
                return n;
            }
        }

        return -1;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];
        System.out.println("Enter the matrix elements :");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int ksmallest = kthSmallest(matrix, k);
        System.out.println(ksmallest);
    }
}