class Solution {
    Map<Integer, List<Integer>> map;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!= n - 1) return false;
        map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, -1});
        Set<Integer> set = new HashSet<>();

        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            int node = curNode[0], parent = curNode[1];
            set.add(node);
            for(int nei : map.get(node)){
                if(nei == parent) continue;
                if(!set.contains(nei)){
                    queue.add(new int[]{nei, node});
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
