class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> cycle;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1) return false;
        map = new HashMap<>();
        cycle = new HashSet<>();

        for(int[] edge : edges){
            if(!map.containsKey(edge[0])) map.put(edge[0], new ArrayList<>());
            if(!map.containsKey(edge[1])) map.put(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        if (!dfs(0, -1)) return false;
        
        return cycle.size() == n;
    }
    public boolean dfs(int course, int parent){
        if(cycle.contains(course)) return false;
        cycle.add(course);

        for(int nei : map.getOrDefault(course, Collections.emptyList())){
            if(nei == parent) continue;
            if(!dfs(nei, course)) return false;
        }
        return true;
    }
}
