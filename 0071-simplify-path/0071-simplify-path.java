class Solution {
    public String simplifyPath(String path) {
        // I didn't know yesterday that we could use vars like this!
        var dirs = new ArrayList<String>();
        for(var dir : path.split("/")) {
            if(dir.isEmpty() || dir.equals(".")){
                continue;
            }
            if(dir.equals("..")) {
                if(!dirs.isEmpty()){
                    dirs.remove(dirs.size()-1);
                }
            }
            else {
                dirs.add(dir);
            }
        }
        return "/" + String.join("/", dirs);
    }
}