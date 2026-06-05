class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k == n) return;
        k = k % n;
        
        int[] first = new int[n - k];
        int[] second = new int[k];

        for(int i = 0; i < n - k; i++){
            first[i] = nums[i];
        }

        for(int i = 0; i < k; i++){
            second[i] = nums[i + n - k];
        }

        for(int i = 0; i < k; i++){
            nums[i] = second[i];
        }

        for(int i = 0; i < n - k; i++){
            nums[i + k] = first[i]; 
        }

        /*[1,2,3,4,5,6,7,8] k = 3
          [6,7,8,1,2,3,4,5]*/

    }
}