class Solution {
    public int maxArea(int[] nums) {
        int ans = Integer.MIN_VALUE, n = nums.length;
        int l = 0, r = n - 1;

        while(l < r){
            int min = Math.min(nums[l], nums[r]);
            ans = Math.max(ans, min * (r - l));

            if(nums[l] < nums[r]){
                l++;
            } else{
                r--;
            }
        }

        return ans;
    }
}
