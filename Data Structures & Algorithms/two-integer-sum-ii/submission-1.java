class Solution {
    public int[] twoSum(int[] nums, int target) {
       int n = nums.length;
       Map<Integer, Integer> map = new HashMap<>();

       for(int i = 0; i < n; i++){
          int first  = nums[i];
          int second = target - first;
          if(map.containsKey(second)){
            return new int[]{map.get(second), i + 1};
          }
          map.put(nums[i], i + 1);
       }

       return new int[]{}; 
    }
}
