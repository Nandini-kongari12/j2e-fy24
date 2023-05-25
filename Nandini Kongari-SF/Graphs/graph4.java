import java.util.Scanner;

public class graph4 {
    private int rowCount;
    private int colCount;

    public int countIslands(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        rowCount = matrix.length;
        colCount = matrix[0].length;
        int islandCount = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (matrix[i][j] == 1) {
                    islandCount++;
                    dfs(matrix, i, j);
                }
            }
        }

        return islandCount;
    }

    private void dfs(int[][] matrix, int row, int col) {
        if (row < 0 || row >= rowCount || col < 0 || col >= colCount || matrix[row][col] != 1) {
            return;
        }

        matrix[row][col] = -1;

        dfs(matrix, row - 1, col); 
        dfs(matrix, row + 1, col); 
        dfs(matrix, row, col - 1); 
        dfs(matrix, row, col + 1); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];
        System.out.println("Enter the matrix elements (0 or 1):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        graph4 P4 = new graph4();
        int islandCount = P4.countIslands(matrix);
        System.out.println("Number of islands: " + islandCount);
    }
}
