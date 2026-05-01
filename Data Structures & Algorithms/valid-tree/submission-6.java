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

        if(!solve(0, -1, new HashSet<>())) return false;

        return true;
    }

    public boolean solve(int node, int parent, Set<Integer> set){
        if(set.contains(node)) return false;
        set.add(node);
        for(int nei : map.get(node)){
            if(nei == parent) continue;
            if(!solve(nei, node, set)) return false;
        }
        return true;
    }
}
