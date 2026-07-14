class Pair{
    int temp;
    int idx;
    Pair(int temp,int idx)
    {
        this.temp = temp;
        this.idx  = idx;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stk = new Stack<>();
        int n = temperatures.length;
        int res[] = new int[n];
        for(int i=0;i<n;i++)
        {
            while(!stk.isEmpty() && stk.peek().temp < temperatures[i])
            {
                Pair p = stk.pop();
                res[p.idx] = i-p.idx;
            }
            stk.push(new Pair(temperatures[i],i));
        }
        while(!stk.isEmpty())
        {
            Pair p = stk.pop();
            res[p.idx] = 0;
        }
        return res;
    }
}
