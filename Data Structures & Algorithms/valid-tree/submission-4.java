class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        DSU ds = new DSU(n);
        for(int[] edge : edges){
            if(!ds.union(edge[0], edge[1])) return false;
        }
        return true;
    }
}
class DSU{
    int[] parent;
    int[] rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int getParent(int node){
        if(parent[node] == node) return node;
        int p = getParent(parent[node]);
        return parent[node] = p;
    }
    public boolean union(int x, int y){
        int p1 = getParent(x);
        int p2 = getParent(y);
        if(p1 == p2) return false;

        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
        } else if(rank[p1] < rank[p2]){
            parent[p1] = p2;
        } else {
            parent[p1] = p2;
            rank[p2]++;
        }
        return true;
    }
}
