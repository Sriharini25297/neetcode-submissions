class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0]>5)
            return false;
        int fiveCoins = 0;
        int tenCoins = 0;
        int n = bills.length;
        for(int i=0;i<n;i++)
        {
            int bill = bills[i];
            if(bill == 5)
                fiveCoins++;
            else if(bill == 10)
            {
                tenCoins++;
                if(fiveCoins == 0)
                    return false;
                fiveCoins--;
            }else{
                if(fiveCoins>0 && tenCoins>0)
                {
                    fiveCoins--;
                    tenCoins--;
                }else if(fiveCoins>=3)
                {
                    fiveCoins-=3;
                }else{
                    return false;
                }
            }
        }
        return true;  
    }
}