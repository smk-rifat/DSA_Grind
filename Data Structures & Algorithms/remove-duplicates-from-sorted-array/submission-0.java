class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int left = 0;
        
        for(int right = 0; right < n; right++){
            if(right > 0 && nums[right] == nums[right - 1]){
                continue;
            } else {
                nums[left++] = nums[right];
            }
        }

        return left;
    }
}