
class Solution {
    Set<Integer> visit;
    Map<Integer, List<Integer>> map;
    public boolean validTree(int n, int[][] edges) {
        visit = new HashSet<>();
        map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        if(!dfs(0, -1)) return false;

        return visit.size() == n;
    }
    public boolean dfs(int node, int parent){
        if(visit.contains(node)) return false;
        visit.add(node);

        for(int next : map.get(node)){
            if(next == parent) continue;
            if(!dfs(next, node)) return false;
        }

        return true;
    }
}