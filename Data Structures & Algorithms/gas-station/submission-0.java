class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gas_sum = 0;
        int gas_cost = 0;
        for(int num:gas)
            gas_sum += num;
        for(int num:cost)
            gas_cost += num;
        if(gas_cost > gas_sum)
            return -1;
        int idx = 0;
        int tillNow = 0;
        for(int i=0;i<gas.length;i++)
        {
            tillNow += (gas[i]-cost[i]);
            if(tillNow<0)
            {
                tillNow = 0;
                idx=i+1;
            }
        }
        return idx;
    }
}
