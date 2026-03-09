class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int element = nums[i];
            while(nums[i] <= n && nums[i] > 0 && nums[element -1] != nums[i]){
                     int temp = nums[element - 1];
                     nums[element - 1] = nums[i];
                     nums[i] = temp;
                     element = nums[i];

            }
        }
        for(int i = 0; i < n ; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
        
    }
}