class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> visited;

    public int countComponents(int n, int[][] edges) {
        map = new HashMap<>();
        visited = new HashSet<>();
        int ans = 0;
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0]))
                map.put(edge[0], new ArrayList<>());
            if (!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        for (int node = 0; node < n; node++) {
            if (!visited.contains(node)) {
                ans++;
                bfs(node);
            }
        }
        
        return ans;
    }

    public void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        visited.add(node);
        queue.add(node);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nei : map.getOrDefault(cur, Collections.emptyList())) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    queue.add(nei);
                }
            }
        }
    }
}
