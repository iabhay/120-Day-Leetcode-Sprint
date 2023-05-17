class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                if(palindromeChecker(s.substring(i,j))){
                    res++;
                }
            }
        }
        return res;
    }
    public boolean palindromeChecker(String s){
        if(s == ""){
            return false;
        }
        if(s.length() == 1){
            return true;
        }
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    // public void listMaker(String s, int i, int j, int res){
    //     if(j >= s.length()){
    //         return;
    //     }
    //     if(palindromeChecker(s)){
    //         res++;
    //     }
    //     listMaker(s.substring(i,j), i, j+1, res);
    //     listMaker(s.substring(i,j), i+1, j, res);
    //     listMaker(s.substring(i, j), i+1, j+1, res);
    // }
}