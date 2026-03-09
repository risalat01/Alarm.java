class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int element = nums[i];
            while(nums[i] >= 1 && nums[i] <= n && nums[element -1] != nums[i]){
              element = nums[i];
              int temp = nums[element -1];
              nums[element -1] = nums[i];
              nums[i] = temp;
            }
        }
        for(int i = 0; i<n; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }
}