class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int digitSum = sumOfDigits(nums[i]);
            if(map.containsKey(digitSum)){
                map.get(digitSum).add(nums[i]);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                map.put(digitSum, temp);
            }
        }
        if(map.size() == n){
            return -1;
        }
        int res = 0;
        for(int sum : map.keySet()){
            ArrayList<Integer> curr = map.get(sum);
            int sz = curr.size();
            if(sz >= 2){
                Collections.sort(curr);
                res = Math.max(res, (curr.get(sz-1) + curr.get(sz-2)));
            }
        }
        return res;
    }

    public int sumOfDigits(int num){
        int res = 0;
        while(num > 0){
            res += num % 10;
            num = num/10;
        }
        return res;
    }
}