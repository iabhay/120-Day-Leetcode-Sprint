class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()){
            return false;
        }
        if(s.length() == 1){
            if(s.charAt(0) != t.charAt(0)){
                return false;
            }
        }
        char a1[] = s.toCharArray();
        char a2[] = t.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        for(int i = 0; i < a1.length -1; i++){
            if(a1[i] != a2[i]){
                return false;
            }
        }
        return true;
    }
}