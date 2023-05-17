// class Solution {
//     public int minNumberOperations(int[] target) {
//         Arrays.sort(target);
//         int n = target.length;
//         int[] nums = new int[n];
//         int vis[] = new int[n];
//         Arrays.fill(vis, 0);
//         Arrays.fill(nums, 1);
//         // int res = 1;
//         int i = 0;
//         while(!checker(vis, n)){
//             while(i < n){
//                 solver(nums, target, n, vis);
//                 if(vis[i] == 1){
//                     break;
//                 }
//                 for(int j = i; j < n; j++){
//                     nums[j] += 1;
//                 }
//                 i++;
//             }
//             res++;
//         }
//         return res;
//     }
//     public void solver(int [] nums, int[] target, int n, int[] vis){
//         for(int i = 0; i < n; i++){
//             if(nums[i] == target[i]){
//                 vis[i] = 1;
//             }
//         }
//         return;
//     }

//     public boolean checker(int[] vis, int n){
//         for(int i = 0; i < n; i++){
//             if(vis[i] == 0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
class Solution {
    public int minNumberOperations(int[] target) {
        int cnt =0, prev = 0;
        
        for(int i=0; i<target.length; i++) {
            if(target[i] > prev) {
                cnt+=(target[i]-prev);
            }
            prev = target[i];
        }
        return cnt;
    }
}