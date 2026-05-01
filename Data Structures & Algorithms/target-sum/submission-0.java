class Solution {
    int n;
    Integer[][] memo;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        memo = new Integer[n + 1][target + 2001];
        return solve(nums, 0, 0, target);
    }
    int solve(int[] nums, int curSum, int idx, int target){
        if(target == curSum && idx >= n) return 1;
        if(idx >= n) return 0;
        if(memo[idx][curSum + 1000] != null) return memo[idx][curSum + 1000];
        return memo[idx][curSum + 1000] = solve(nums, curSum + nums[idx], idx + 1, target) + solve(nums, curSum - nums[idx], idx + 1, target);
    }
}