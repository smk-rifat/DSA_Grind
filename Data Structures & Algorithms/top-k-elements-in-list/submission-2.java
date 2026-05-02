class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        List<Integer>[] frq = new List[nums.length + 1];

        for(int key: map.keySet()){
            int val = map.get(key);
            if(frq[val] == null) frq[val] = new ArrayList<>();
            frq[val].add(key);
        } 
        int[] ans = new int[k];
        int idx = 0;

        for(int i = nums.length; i >= 0; i--){
            if(frq[i] != null){
                List<Integer> cur = frq[i];
                for(int j = 0; j < cur.size(); j++){
                    ans[idx++] = cur.get(j);
                    if(idx >= k) break;
                }
            }
            if(idx >= k) break;
        }

        return ans;
    }
}
