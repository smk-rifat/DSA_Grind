class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> visited;
    public int countComponents(int n, int[][] edges) {
        map = new HashMap<>();
        int ans = 0;
        visited = new HashSet<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        for (int node = 0; node < n; node++) {
            if (!visited.contains(node)) {
                ans++;
                dfs(node);
            }
        }
        return ans;
    }

    public void dfs(int node){
        visited.add(node);
        for (int nei : map.getOrDefault(node, Collections.emptyList())){
            if(!visited.contains(nei)) dfs(nei);
        }
    }
}
