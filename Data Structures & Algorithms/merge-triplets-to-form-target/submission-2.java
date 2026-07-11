class Solution {
    public boolean mergeTriplets(int[][] triplet, int[] target) {
        int n = triplet.length;
        boolean a = false;
        boolean b = false;
        boolean c = false;
        for(int i=0;i<n;i++)
        {
            if(triplet[i][0] > target[0] || triplet[i][1]>target[1] || triplet[i][2]>target[2])
                continue;
            if(triplet[i][0] == target[0])
                a = true;
            if(triplet[i][1] == target[1])
                b = true;
            if(triplet[i][2] == target[2])
                c = true;
            if(a&&b&&c)
                return true;
        }
        return a&&b&&c;
    }
}
