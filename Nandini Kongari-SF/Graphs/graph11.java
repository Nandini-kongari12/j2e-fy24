import java.util.*;
class graph11{
    int startRow;
    int startCol;
    public static int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        
        int delRow[]={1,-1,0,0};
        int delCol[]={0,0,1,-1};
        int visit[][]=new int[n][m];
   
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(visit[i][j]==0){
                    
                    max=Math.max(max,dfs(i,j,matrix,visit,n,m,delRow,delCol));
                    
                }
            }
        }
        return max;
    }

    public static int dfs(int row,int col,int [][]matrix,int [][]visit,int n,int m,int[]delRow,int[]delCol){     
        if(visit[row][col]>0){
            return visit[row][col];
        }
    
        int ans=1;
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];

            if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= m) {
                continue;
            }

            if (matrix[nrow][ncol] <= matrix[row][col]) {
                continue;
            }

                ans=Math.max(ans,dfs(nrow,ncol,matrix,visit,n,m,delRow,delCol)+1);
        }
        visit[row][col]=ans;
        return ans;
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
       
        int res = longestIncreasingPath(matrix);
        System.out.println(res);
    }
}