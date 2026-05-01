class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for(int num : nums) queue.add(num);
        for(int i = 1; i < n; i += 2) nums[i] = queue.poll();
        for(int i = 0; i < n; i += 2) nums[i] = queue.poll();
    }
}
