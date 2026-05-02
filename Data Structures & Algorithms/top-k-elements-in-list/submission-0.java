class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        int[][] frq = new int[map.size()][2];
        int idx = 0;
        for(int key : map.keySet()){
            frq[idx][0] = key;
            frq[idx][1] = map.get(key);
            idx++;
        } 
        Arrays.sort(frq, (a, b) -> b[1] - a[1]);

        int[] ans = new int[k];

        for(int i = 0; i < k; i++){
            ans[i] = frq[i][0];
        }  

        return ans;
    }
}
