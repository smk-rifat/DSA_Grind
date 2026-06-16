class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int leftM = nums[0], rightM = nums[n - 1];
        int l = 0, r = n - 1;
        int water = 0;
        while(l < r){

            if(leftM < rightM){
                l++;
                leftM = Math.max(nums[l], leftM);
                water += leftM - nums[l];
            } else {
                r--;
                rightM = Math.max(rightM, nums[r]);
                water += rightM - nums[r];
            }
        }

        return water;
    }
}
