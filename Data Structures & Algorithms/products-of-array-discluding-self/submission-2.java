class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            if(i == 0) {
                ans[i] = 1;
            } else {
                ans[i] = ans[i - 1] * nums[i - 1];
            }
        }

        int postProd = 1;

        for(int i = n - 1; i >= 0; i--){
            ans[i] = postProd * ans[i];
            postProd *= nums[i];
        }

        return ans;
    }
}  
