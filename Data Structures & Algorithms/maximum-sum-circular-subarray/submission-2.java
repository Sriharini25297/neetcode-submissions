class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int normalSum = Integer.MIN_VALUE;
        int pref = 0;
        int totalSum = 0;
        for(int num:nums)
        {
            totalSum += num;
            pref  = Math.max(num,pref+num);
            normalSum = Math.max(normalSum,pref);
        }
        int minSum = Integer.MAX_VALUE;
        pref = 0;
        for(int num:nums)
        {
            pref = Math.min(num,pref+num);
            minSum = Math.min(minSum,pref);
        }
        if(normalSum<0)
            return normalSum;
        return Math.max(normalSum,totalSum-minSum);
    }
}