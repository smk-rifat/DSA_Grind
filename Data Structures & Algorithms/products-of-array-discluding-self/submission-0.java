class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 0; i < n; i++){
            if(i == 0){
                left[i] = nums[i];
            } else {
                left[i] = nums[i] * left[i - 1];
            }
        }

        for(int j = n - 1; j >= 0; j--){
            if(j == n - 1){
                right[j] = nums[j];
            } else {
                right[j] = nums[j] * right[j + 1];
            }
        }

        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            int l = i == 0 ? 1 : left[i - 1];
            int r = i == n - 1 ? 1 : right[i + 1];
            ans[i] = l * r;
        }

        return ans;
    }
}  
