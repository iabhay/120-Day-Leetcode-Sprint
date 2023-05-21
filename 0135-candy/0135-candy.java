class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] leftCount = new int[n];
        Arrays.fill(leftCount, 1);
        int [] rightCount = new int[n];
        Arrays.fill(rightCount, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                leftCount[i] = leftCount[i-1] + 1;
            }
        }
        for(int i = n-2; i >=0; i--){
            if(ratings[i] > ratings[i+1]){
                rightCount[i] = rightCount[i+1] + 1;
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            int mx = Math.max(leftCount[i], rightCount[i]);
            res += mx;
        }
        return res;
    }
}