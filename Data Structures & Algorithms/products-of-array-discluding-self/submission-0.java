class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numZeros = 0;
        for(int num:nums)
        {
            if(num == 0)
                numZeros++;
        }
        int n = nums.length;
        int ans[] = new int[n];
        if(numZeros > 1)
        {
            Arrays.fill(ans,0);
            return ans;
        }else if(numZeros == 1)
        {
            int idx = 0;
            int product = 1;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i] ==  0)
                    idx = i;
                else
                    product *= nums[i];
            }
            ans[idx] = product;
            return ans;
        }else{
            int prefix[] = new int[n];
            int suffix[] = new int[n];
            prefix[0] = nums[0];
            for(int i=1;i<n;i++)
                prefix[i] = prefix[i-1] * nums[i];
            suffix[n-1] = nums[n-1];
            for(int i=n-2;i>=0;i--)
                suffix[i] = suffix[i+1] * nums[i];
            ans[0] = suffix[1];
            ans[n-1] = prefix[n-2];
            for(int i=1;i<=n-2;i++)
            {
                ans[i] = prefix[i-1]*suffix[i+1];
            }
            return ans;
        }
    }
}  
