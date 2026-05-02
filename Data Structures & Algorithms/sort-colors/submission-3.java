class Solution {
    public void sortColors(int[] nums) {
       int n = nums.length;
       int l = 0, r = n - 1, m = 0;

       while(m <= r){
            if(nums[m] == 0){
               swap(nums, m, l);
               l++;
            } else if(nums[m] == 2){
                swap(nums, m, r);
                r--;
                m--;
            }
            m++;
       } 
    }
    void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}