class Union{
    int parent[];
    int rank[];
    Union(int size){
        parent = new int[size];
        for(int i=1;i<size;i++)
            parent[i] = i;
        rank = new int[size];
    }
    int find(int x)
    {
        if(parent[x]!= x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    void merge(int x,int y)
    {
        int x_set = find(x);
        int y_set = find(y);
        if(x_set == y_set)
            return;
        if(rank[x_set]>rank[y_set])
            parent[y_set] = x_set;
        else if(rank[y_set]>rank[x_set])
            parent[x_set] = y_set;
        else{
            parent[y_set] = x_set;
            rank[x_set]++;
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<int[]> redundant = new ArrayList<>();
        int n = edges.length;
        Union dsu = new Union(n+1);
        for(int edge[]:edges)
        {
            int u = edge[0];
            int v = edge[1];
            if(dsu.find(u)==dsu.find(v))
                redundant.add(new int[]{u,v});
            else
                dsu.merge(u,v);
        }
        if(redundant.size() == 0)
            return new int[]{-1,-1};
        return redundant.get(redundant.size()-1);
    }
}
