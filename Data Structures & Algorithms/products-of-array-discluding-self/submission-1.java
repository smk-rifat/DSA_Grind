class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int prodWithoutZero = 1;
        int zero = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                zero++;
            } else {
                prodWithoutZero *= nums[i];
            }
            prod *= nums[i];
        }

        if(zero > 1) return new int[n];

        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                ans[i] = prodWithoutZero;
            } else if(zero > 0){
                ans[i] = 0;
            } else {
                ans[i] = prod/nums[i];
            }
        }

        return ans;
        
    }
}  
