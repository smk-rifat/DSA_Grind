class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU ds = new DSU(n);
        int ans = 0;
        for(int[] edge : edges){
          ds.union(edge[0], edge[1]);
        }

        return ds.getSize();
    }
}
class DSU{
    int[] rank;
    int[] parent;
    int size;

    DSU(int n){
        rank = new int[n];
        parent = new int[n];
        for(int i = 0; i < n; i++){
            rank[i] = 1;
            parent[i] = i;
        }
        size = n;
    }

    public int getParent(int node){
        if(parent[node] == node) return node;
        int gP = getParent(parent[node]);
        return parent[node] = gP;
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
            parent[p2] = p1;
            rank[p1]++;
        }
        size--;
        return true;
    }

    public int getSize(){
        return size;
    }
}
