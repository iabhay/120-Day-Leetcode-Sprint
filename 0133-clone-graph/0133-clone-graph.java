/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
       if(node == null) return null;
       Queue<Node> que = new ArrayDeque();
       Map<Node,Node> map = new HashMap<>();
       que.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
       while(!que.isEmpty()){
           Node n = que.poll();

           for(Node neighbour : n.neighbors){
               if(!map.containsKey(neighbour)){
                   map.put(neighbour, new Node(neighbour.val, new ArrayList<>()));
                   que.add(neighbour);
               }
                map.get(n).neighbors.add(map.get(neighbour));
           }
       } 
       return map.get(node);
    }
}