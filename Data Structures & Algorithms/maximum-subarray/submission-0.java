class Solution {
    public int maxSubArray(int[] nums) {
        int maxi  = Integer.MIN_VALUE;
        int pref = 0;
        for(int num:nums)
        {
            pref += num;
            maxi=Math.max(maxi,pref);
            pref = Math.max(pref,0);
        }
        return maxi;
    }
}
