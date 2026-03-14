class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] answer = new int[nums.length];
        for(int i = 1; i < nums.length; i++){
            while(stack.size() > 0 && nums[stack.peek()] < nums[i]){
                answer[stack.peek()] = nums[i];
                stack.pop();
            };
            stack.push(i);
        }
        for(int i = 0 ; i< nums.length; i++){
            while(stack.size() > 0 && nums[stack.peek()] < nums[i]){
                answer[stack.peek()] = nums[i];
                stack.pop();
            }
        }
        while(stack.size() > 0){
            answer[stack.peek()] = -1;
            stack.pop();
        }
        return answer;
    }
}