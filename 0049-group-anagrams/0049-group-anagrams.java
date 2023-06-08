class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lst = new ArrayList<>();
        if(strs.length == 0 || strs == null){
            return lst;
        }
        if(strs.length == 1){
            lst.add(Arrays.asList(strs));
            return lst;
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i <= strs.length - 1; i++){
            char [] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            StringBuilder strtemp = new StringBuilder();
            strtemp.append(arr);
            String tmp = strtemp.toString();
            if(map.containsKey(tmp)){
                map.get(tmp).add(strs[i]);
            }
            else{
                map.put(tmp, new ArrayList(Arrays.asList(strs[i])));
            }
        }
        return new ArrayList<>(map.values());
    }
}