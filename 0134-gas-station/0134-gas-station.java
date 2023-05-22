class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ind = 0;
        int sum = 0;
        int total = 0;
        int n = cost.length;
        for(int i = 0; i < n; i++){
            sum += gas[i] - cost[i];

            if(sum < 0){
                total += sum;
                sum = 0;
                ind  = i + 1;
            }
        }
        total += sum;
        return total >= 0 ? ind : -1;
    }
}