class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1, i = 0;

        while(i <= r){
            if(nums[i] == 0){
                swap(nums, i, l);
                l++;
            } else if(nums[i] == 2){
                swap(nums, i, r);
                r--;
                i--;
            }
            i++;
        }
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}