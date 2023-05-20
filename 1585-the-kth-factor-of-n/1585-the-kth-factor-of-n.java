class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                lst.add(i);
            }
        }
        if(k > lst.size()){
            return -1;
        }
        return lst.get(k-1);
    }
}