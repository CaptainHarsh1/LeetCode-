class Solution {

    int dfs(int[]a,int[]dp,int i,int d){
        if(dp[i]!=0)return dp[i];

        int mx=1;
        int n=a.length;

        for(int j=1;j<=d && i+j<n;j++){
            if(a[i]>a[i+j]){
                mx=Math.max(mx,1+dfs(a,dp,i+j,d));
            }else break;
        }

        for(int j=1;j<=d && i-j>=0;j++){
            if(a[i]>a[i-j]){
                mx=Math.max(mx,1+dfs(a,dp,i-j,d));
            }else break;
        }

        return dp[i]=mx;
    }

    public int maxJumps(int[]arr,int d) {

        int n=arr.length;
        int[]dp=new int[n];

        int ans=0;

        for(int i=0;i<n;i++){
            ans=Math.max(ans,dfs(arr,dp,i,d));
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna