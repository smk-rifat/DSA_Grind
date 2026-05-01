class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> cycle = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge : edges){
            if(!map.containsKey(edge[0])) map.put(edge[0], new ArrayList<>());
            if (!map.containsKey(edge[1])) map.put(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, -1});
        cycle.add(0);
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int cur = node[0], parent = node[1];

            for(int nei : map.getOrDefault(cur, Collections.emptyList())){
                if(nei == parent) continue;
                if(cycle.contains(nei)) return false;
                cycle.add(nei);
                queue.add(new int[]{nei, cur});
            }
        }
        
        return cycle.size() == n;
    }
}
