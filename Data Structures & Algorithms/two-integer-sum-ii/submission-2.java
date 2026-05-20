class Solution {
    public int[] twoSum(int[] nums, int target) {
       int n = nums.length;
       int left = 0, right = n - 1;

       while(left < right){
            if(nums[left] + nums[right] > target){
                right--;
            } else if(nums[left] + nums[right] < target){
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
       }

       return new int[]{}; 
    }
}
