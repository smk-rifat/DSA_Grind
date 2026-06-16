class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int leftM = nums[0], rightM = nums[n - 1];
        int l = 0, r = n - 1;
        int water = 0;
        while(l < r){

            if(leftM < rightM){
                water += leftM - nums[l];
                l++;
                leftM = Math.max(nums[l], leftM);
            } else {
                water += rightM - nums[r];
                r--;
                rightM = Math.max(rightM, nums[r]);
            }
        }

        return water;
    }
}
