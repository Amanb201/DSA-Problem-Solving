class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int countContentChild = 0;
        int gIndex = 0, sIndex=0;
        int gSize = g.length, sSize = s.length;

        while(gIndex<gSize && sIndex<sSize){
            if(g[gIndex] <= s[sIndex]){
                gIndex++; sIndex++;
                countContentChild++;
            }
            else{
                sIndex++;
            }
        }

        return countContentChild;
    }
}