class Solution {
    /***
        If the bitwise AND of candidates is positive,
        there is at least one bit that all candidates is 1.

        So we can enumerate each bit of 32 bits,
        the number of candidates that have this bit.
        If a & bit > 0, it means candidate a has this bit.

        We sum up the total number cur of current candidates that have this bit,
        then update out final result res.


        Complexity
        Time O(nlog10000000)
        Space O(1)
     */
    public int largestCombination(int[] candidates) {
        int res = 0, cur = 0;
        for (int i = 1; i <= 10000000; i <<= 1) {
            cur = 0;
            for (int a : candidates)
                if ((a & i) > 0)
                    cur++;
            res = Math.max(res, cur);
        }
        return res;
    }
}