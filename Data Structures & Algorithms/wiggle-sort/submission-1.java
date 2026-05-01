class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 1; i < n - 1; i += 2){
            swap(nums, i, i + 1);
        }
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
