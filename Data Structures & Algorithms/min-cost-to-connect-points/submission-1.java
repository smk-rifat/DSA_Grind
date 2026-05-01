class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int currentNode = 0;
        int[] distant = new int[n];
        Arrays.fill(distant, Integer.MAX_VALUE);
        int edge = 0, res = 0;

        while(edge < n - 1){
            visited[currentNode] = true;
            int nextNode = - 1;

            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;
                int cost = Math.abs(points[currentNode][0] - points[i][0]) + Math.abs(points[currentNode][1] - points[i][1]);
                distant[i] = Math.min(distant[i], cost);
                if(nextNode == -1 || distant[i] < distant[nextNode]){
                    nextNode = i;
                }
            }
            edge++;
            res += distant[nextNode];
            currentNode = nextNode;
        }

        return res;
    }
}
