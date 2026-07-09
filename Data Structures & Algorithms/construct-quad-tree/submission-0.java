/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    Node dfs(int n,int grid[][],int r,int c)
    {
        boolean isSame = true;
        int first = grid[r][c];
        for(int i=0;i<n && isSame;i++)
        {
            for(int j=0;j<n;j++)
            { 
                if(grid[r+i][c+j] != first){
                    isSame = false;
                    break;
                }
            }
        }
           
        if(isSame)
            return new Node(first==1,true);
        int half = n/2;
        Node topleft = dfs(half,grid,r,c);
        Node topRight = dfs(half,grid,r,c+half);
        Node bottomleft = dfs(half,grid,r+half,c);
        Node bottomRight = dfs(half,grid,r+half,c+half);
        return new Node(false,false,topleft,topRight,bottomleft,bottomRight);
    }
    public Node construct(int[][] grid) {
        int n = grid.length;
        return dfs(n,grid,0,0);
    }
}