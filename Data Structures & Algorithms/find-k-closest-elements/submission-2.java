class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int n = nums.length;
        Comparator<int[]> comp = new Comparator<>(){
            public int compare(int[]a, int[]b){
                if(a[1] < b[1] || (a[1] == b[1] && a[0] < b[0])){
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        PriorityQueue<int[]> queue = new PriorityQueue<>(comp);

        for(int num : nums){
            queue.add(new int[]{num, Math.abs(num - x)});
            if(queue.size()> k) queue.poll();
        }

        List<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            ans.add(queue.poll()[0]);
        }

        Collections.sort(ans);

        return ans;
    }
}