class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer,Integer> mp = new HashMap<>();
      for(int num:nums)
      {
        mp.put(num,mp.getOrDefault(num,0)+1);
      }
      int n = nums.length;
      List<Integer>[] bucket = new ArrayList[n+1];
      for(int key:mp.keySet())
      {
        int freq = mp.get(key);
        if(bucket[freq] == null)
            bucket[freq] = new ArrayList<>();
        bucket[freq].add(key);
      }
      int ans[] = new int[k];
      int count = 0;
      for(int i=n;i>=0 && count<k;i--)
      {
        if(bucket[i]!=null){
        for(int node:bucket[i])
        {
            ans[count++] = node;
            if(count == k)
                return ans;
        }
        }
      }
      return ans;
    }
}
