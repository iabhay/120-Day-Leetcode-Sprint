class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        String [] str = s.split(" ");
        Collections.reverse(Arrays.asList(str));
        String res = "";
        for(int i = 0; i < str.length-1; i++){
            res += str[i];
            res += " ";
        }
        res += str[str.length - 1];
        return res;
    }
}