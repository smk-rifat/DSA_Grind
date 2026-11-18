class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, element = nums[0];
        for(int num : nums) {
            if (count == 0) {
                element = num;
                count = 1;
            } else if(num == element){
                count++;
            } else {
                count --;
            }
        }
        return element;
    }
}