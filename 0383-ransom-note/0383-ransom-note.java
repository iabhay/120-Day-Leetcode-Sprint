class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == ""){
            return true;
        }
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : magazine.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char cf : ransomNote.toCharArray()){
            if(!map.containsKey(cf)){
                return false;
            }
            else{
                int temp = map.get(cf);
                if(temp == 1){
                    map.remove(cf);
                }
                else{
                    map.put(cf, temp-1);
                }
            }
        }
        return true;
    }
}