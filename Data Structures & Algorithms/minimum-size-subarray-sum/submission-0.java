class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int cur = 0;
            for(int j = i; j < n; j++){
                cur += nums[j];
                if(cur >= target){
                    ans = Math.min(j - i + 1, ans);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}