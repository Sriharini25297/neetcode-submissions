class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int res = 1;
        int n = arr.length;
        for(int i=0;i<n-1;i++)
        {
            if(arr[i] == arr[i+1])
                continue;
            int sign = arr[i]>arr[i+1]?0:1;
            int j = i+1;
            while(j<n-1)
            {
                if(arr[j] == arr[j+1])
                    break;
                int currSign = arr[j]>arr[j+1]?0:1;
                if(currSign == sign)
                    break;
                sign = currSign;
                j++;
            }
            res = Math.max(res,j-i+1);
        }
        return res;
    }
}