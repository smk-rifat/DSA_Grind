class DSU {
    List<Integer> rank;
    List<Integer> parent;
    List<Integer> size;

    DSU(int n) {
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int u){
        if(u == parent.get(u)) return u;
        int ulp = findParent(parent.get(u));
        parent.set(u, ulp);
        return parent.get(u);
    }
    public boolean unionByRank(int u, int v){
        int up = findParent(u);
        int vp = findParent(v);
        if(up == vp) return true; // they are one same tree;

        if(rank.get(up) > rank.get(vp)){
            parent.set(vp, up);
        } else if(rank.get(up) < rank.get(vp)){
            parent.set(up, vp);
        } else {
            parent.set(up, vp);
            int rankU = rank.get(vp);
            rank.set(vp, rankU + 1);
        }
        return false;
    }
    public boolean unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return true; // they are one same tree;

        if (size.get(ulp_u) > size.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }

        return false;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int ans = 0;
        for(int[] edge : edges){
            if (!dsu.unionByRank(edge[0], edge[1])){
                ans++;
            }
        }
        return n - ans;
    }
}

