class DisjointSet {
    private List<Integer> size;
    private List<Integer> rank;
    private List<Integer> parent;
    public DisjointSet(int n){
        size = new ArrayList<>();
        rank = new ArrayList<>();
        parent = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            size.add(1);
            rank.add(0);
            parent.add(i);
        }
    }
    private int getParent(int node){
        if(node == parent.get(node)) return node;
        int ulp = getParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public boolean unionByRank(int u, int v){
        int ulp_u = getParent(u);
        int ulp_v = getParent(v);
        if (ulp_v == ulp_u) return false;

        if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        } else if (rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        } else {
            int rankU = rank.get(ulp_u);
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rankU + 1);
        }

        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DisjointSet disjointSet = new DisjointSet(n);
        int ans = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int cost = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                queue.add(new int[]{cost, i, j});
            }
        }
        
        while (!queue.isEmpty()){
            int[] edge = queue.poll();
            int u = edge[1], v = edge[2], w = edge[0];
            if(disjointSet.unionByRank(u, v)){
                ans += w;
            }
        }
        
        return ans;
    }
}
