class Solution {
    public int[] twoSum(int[] nums, int target) {
        //[1,2,3,4,5] target = 8
        int n = nums.length;
        Map<Integer, Integer> position = new HashMap<>();
        for(int i = 0; i < n; i++){
            position.put(nums[i], i);
        }
        int[] ans = new int[2];

        for(int i = 0; i < n; i++){
            int rem = target - nums[i];
            if(position.containsKey(rem) && position.get(rem) != i){
                ans[0] = i;
                ans[1] = position.get(rem);
                break;        
            }
        }

        return ans;
    }
}