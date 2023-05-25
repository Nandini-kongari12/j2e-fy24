import java.util.*;
class graph6 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        int[][] dp=new int[m][n];
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==1)
                break;
            else{
                dp[0][i]=1;
            }
        }
           
            for(int j=0;j<m;j++){
                if(obstacleGrid[j][0]==1)
                    break;
                else{
                    dp[j][0]=1;
                }
            }
            for(int k=1;k<m;k++){
                for(int l=1;l<n;l++){
                    if(obstacleGrid[k][l]==1){
                        dp[k][l]=0;
                    }
                    else{
                        dp[k][l]=dp[k-1][l]+dp[k][l-1];
                    }
                }
            }
        return dp[m-1][n-1];
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
       
        int res = uniquePathsWithObstacles(matrix);
        System.out.println(res);
    }
}