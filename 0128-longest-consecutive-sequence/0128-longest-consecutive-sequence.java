class Solution {
    public int longestConsecutive(int[] nums) {
  
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;

       
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int nextNum = num + 1;
            int count = 1;

            while (set.contains(nextNum)) {
                nextNum++;
                count++;
            }

            ans = Math.max(ans, count);
        }
        return ans;
    }
}

  