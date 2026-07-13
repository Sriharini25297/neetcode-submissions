class Solution {
    void found(int to,int nums[],int start,int end,int target,Set<List<Integer>> lst)
    {
        int p1 = start;
        int p2 = end;
        while(p1<p2)
        {
            if(nums[p1]+nums[p2] == target)
            {
                lst.add(Arrays.asList(to,nums[p1],nums[p2]));
                p1++;
                p2--;
            }else if(nums[p1]+nums[p2]<target)
            {
                p1++;
            }else{
                p2--;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> lst = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            int target = -nums[i];
            found(nums[i],nums,i+1,nums.length-1,target,lst);
        }
        return new ArrayList<>(lst);
    }
}
