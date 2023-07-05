class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int b = stk.pop();
                int a = stk.pop();
                int c = a + b;
                stk.push(c);
            }
            else if(tokens[i].equals("-")){
                int b = stk.pop();
                int a = stk.pop();
                int c = a - b;
                stk.push(c);
            }
            else if(tokens[i].equals("*")){
                int b = stk.pop();
                int a = stk.pop();
                int c = a * b;
                stk.push(c);
            }
            else if(tokens[i].equals("/")){
                int b = stk.pop();
                int a = stk.pop();
                int c = a / b;
                stk.push(c);
            }
            else{
                int temp = Integer.parseInt(tokens[i]);
                stk.push(temp);
            }
        }
        return stk.pop(); 
    }
}