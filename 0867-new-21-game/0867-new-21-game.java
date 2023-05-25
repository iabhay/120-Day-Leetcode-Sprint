class Solution {
    public double new21Game(int n, int k, int maxP) {
     if(k==0 || n>=k+maxP)   return 1;

     double dp[]=new double[n+1];
     dp[0]=1;
     double currSum=dp[0];
     for(int i=1;i<=n;i++){
         dp[i]=currSum/(double)maxP;
         if(i<k)
         currSum+=dp[i];
         if(i-maxP>=0)
         currSum-=dp[i-maxP];
     }
     double ans=0;
for(int i=k;i<=n;i++)
ans+=dp[i];

return ans;
    }
}