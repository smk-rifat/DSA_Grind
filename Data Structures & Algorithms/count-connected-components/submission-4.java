class DisjointSet{
    int size;
    int[] parent;
    int[] rank;
    DisjointSet(int n){
        size = n;
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public void union(int u, int v){
        int rootU = findParent(u);
        int rootV = findParent(v);
        if(rootU == rootV) return;

        if(rank[rootU] > rank[rootV]){
            parent[rootV] = rootU;
        } else if(rank[rootU] < rank[rootV]){
            parent[rootU] = rootV;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
        size--;
    }
    public int findParent(int u){
        if(u == parent[u]) return u;
        int ulp = findParent(parent[u]);
        parent[u] = ulp;
        return parent[u];
    }
    public int getSize(){
        return size;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        for(int[] edge : edges){
            ds.union(edge[0], edge[1]);
        }
        return ds.getSize();
    }

}
