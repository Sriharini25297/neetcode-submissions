class Solution {
    int findDP(int nums[],int start,int end)
    {
        int dp[] = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(dp[start],nums[start+1]);
        for(int i=start+2;i<end;i++)
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        return dp[end-1];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(findDP(nums,0,n-1),findDP(nums,1,n));
    }
}
