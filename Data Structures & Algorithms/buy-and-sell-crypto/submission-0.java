class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int val = 0;

        for(int i = 1; i < n; i++){
            int cur = nums[i] - min;
            if(cur > 0 && cur > val) val = cur;
            min = Math.min(nums[i], min);
        } 

        return val;
    }
}