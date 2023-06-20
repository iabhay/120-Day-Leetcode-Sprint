class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[A.length];
        for(int i = 0; i < A.length; i++){
            int curr = 0;
            if(set.contains(A[i])){
                curr++;
            }
            if(set.contains(B[i])){
                curr++;
            }
            if(A[i] == B[i]){
                curr++;
            }
            set.add(A[i]);
            set.add(B[i]);
            if(i != 0) res[i] = res[i-1] + curr;
            else{
                res[i] = curr;
            }
        }
        //  
        return res; 
    }
}