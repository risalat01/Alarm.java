class Solution {
    public int evalRPN(String[] tokens) {
        
      Stack<Integer> stack = new Stack<>();

      for(String token : tokens){
        if(isOperator(token)){
           int operend1 = stack.pop();
           int operend2 = stack.pop();
            int result = eval(operend1, operend2, token);
            stack.push(result);
        }else{
            stack.push(Integer.parseInt(token));
        }
      }
      return stack.pop();
    }

    private int eval(int operend1,int operend2,String token){
         if(token.equals("+")){
            return operend1 + operend2;
         }else if(token.equals("-")){
            return operend2 - operend1;
         }else if(token.equals("/")){
            return operend2 / operend1;
         }else if(token.equals("*")){
            return operend1 * operend2;
         }
         return 0;
    }
    private boolean isOperator(String token){
    return token.equals("+") || token.equals("-") || 
           token.equals("*") || token.equals("/");
}
}