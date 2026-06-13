class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        int i = 0, j = n - 1;

        while(i <= j){
            if(nums[i] + nums[j] <= limit){
                i++;
                j--;
            } else {
                j--;
            }
            ans++;
        }

        return ans;
    }
}