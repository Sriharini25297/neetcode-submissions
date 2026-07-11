class Solution {
    boolean found(boolean visited[],List<Integer>[] graph,int src,int dest)
    {
       visited[src] = true;
       if(src == dest)
            return true;
        for(int node:graph[src])
        {
            if(!visited[node]){
            if(found(visited,graph,node,dest))
                return true;
                }
        } 
        return false;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList<>();
        for(int edge[]:prerequisites)
        {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
        }
        for(int query[]:queries)
        {
            int src = query[0];
            int dest = query[1];
            boolean visited[] = new boolean[numCourses+1];
            if(!found(visited,graph,src,dest))
                ans.add(false);
            else
                ans.add(true);
        }
        return ans;
    }
}