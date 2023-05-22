class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() >= 1) {
            int startInd = 0;
            for (int i = 0; i < s.length(); i++) {
                if (t.indexOf(String.valueOf(s.charAt(i)), startInd) == -1) {
                    return false;
                } else {
                    startInd = t.indexOf(String.valueOf(s.charAt(i)), startInd) + 1;
                }
            }
        } 
        return true;
    }
}