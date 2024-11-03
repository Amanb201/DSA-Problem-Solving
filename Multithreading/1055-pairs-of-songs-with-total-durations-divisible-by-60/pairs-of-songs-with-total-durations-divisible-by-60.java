class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0, cnt[] = new int[60];
        for (int i = 0; i < time.length; i ++) cnt[time[i] % 60] += 1;
        for (int i = 1; i< 30; i ++) ans += cnt[i] * cnt[60 - i];
        
        ans += cnt[0]%2==0?cnt[0]/2 * (cnt[0] - 1):(cnt[0]-1)/2 * cnt[0];
        ans+=cnt[30]%2==0?cnt[30]/2 * (cnt[30] - 1): (cnt[30] - 1)/2*cnt[30];;
        return ans;
    }
}