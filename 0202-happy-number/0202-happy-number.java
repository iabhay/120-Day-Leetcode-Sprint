class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n!=1){
            int current = n;
            int res = 0;
            while(current!=0){
                int num = current%10;
                res += num*num;
                current/=10;
            }
            if(set.contains(res)){
                return false;
            }
            set.add(res);
            n = res;
        }
        return true;
}   
}