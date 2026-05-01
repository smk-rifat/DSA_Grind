class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;

        for(int i = 1; i < n; i++){
            if(i % 2 == 0 && nums[i] > nums[i - 1] || i % 2 == 1 && nums[i] < nums[i - 1] ) swap(nums, i, i - 1);
        }
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
