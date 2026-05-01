class Solution {
    Map<Integer, List<Integer>> map;
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        map = new HashMap<>();
        for(int c = 0; c < n; c++) map.put(c, new ArrayList<>());

        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];
        int ans = 0;

        for(int node = 0; node < n; node++){
            if(!visited[node]) {
                solve(node);
                ans++;
            }
        } 

        return ans;
    }
    public void solve(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int nei : map.get(cur)){
                if(!visited[nei]){
                    visited[nei] = true;
                    queue.add(nei);
                }
            }
        }
    }
}
