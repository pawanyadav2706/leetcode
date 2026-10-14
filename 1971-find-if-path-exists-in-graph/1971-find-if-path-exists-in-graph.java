class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();

        // empty list to every node
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        // create a graph
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visited[source] = true;

        while(!stack.isEmpty()){
            int node = stack.pop();
            if(node == destination){
                return true;
            }
            for(int neighbour: adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }
            }
        }
        return false;
    }
}