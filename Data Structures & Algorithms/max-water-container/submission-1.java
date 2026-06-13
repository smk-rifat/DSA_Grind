class Solution {
    public int maxArea(int[] nums) {
        int ans = Integer.MIN_VALUE, n = nums.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int min = Math.min(nums[i], nums[j]);
                ans = Math.max(ans, min * (j - i));
            }
        }

        return ans;
    }
}
