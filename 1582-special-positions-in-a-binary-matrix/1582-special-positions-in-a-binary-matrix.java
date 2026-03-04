class Solution {
    public int numSpecial(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        
        // Calculate row sums
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                rowSum[i] += mat[i][j];
            }
        }
        
        // Calculate column sums
        for(int j = 0; j < n; j++){
            for(int i = 0; i < m; i++){
                colSum[j] += mat[i][j];
            }
        }
        
        int ans = 0;
        
        // Check special positions
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1){
                    ans++;
                }
            }
        }
        
        return ans;
    }
}