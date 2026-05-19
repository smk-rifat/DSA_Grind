class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];

        for(int num : nums){
            if(num > 0 && num <= n){
                seen[num - 1] = true;
            }
        }

        for(int i = 1; i <= n; i++){
            if(seen[i - 1] != true) return i;
        }

        return n + 1;
    }
}