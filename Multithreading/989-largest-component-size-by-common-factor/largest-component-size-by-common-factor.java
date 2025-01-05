class Solution {
    class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n){
            for(int i=0; i<n; i++){
                parent.add(i);
                rank.add(0);
                size.add(1);
            }
        }

        public int findUltParent(int node){
            if(node == parent.get(node))
                return node;

            int ulp = findUltParent(parent.get(node));
            parent.set(node, ulp);
            return ulp;
        }

        public void unionByRank(int nodeU, int nodeV) {
            int ulpU = findUltParent(nodeU);
            int ulpV = findUltParent(nodeV);

            if(ulpU == ulpV)
                return;

            if(rank.get(ulpU) < rank.get(ulpV)){
                parent.set(ulpU, ulpV);
            }
            else if(rank.get(ulpU) > rank.get(ulpV)){
                parent.set(ulpV, ulpU);
            }
            else{
                parent.set(ulpU, ulpV);
                rank.set(ulpV, rank.get(ulpV) + 1);
            }
        }
        
        public void unionBySize(int nodeU, int nodeV) {
            int ulpU = findUltParent(nodeU);
            int ulpV = findUltParent(nodeV);

            if(ulpU == ulpV)
                return;

            if(size.get(ulpU) < size.get(ulpV)){
                parent.set(ulpU, ulpV);
                size.set(ulpV, size.get(ulpU)+size.get(ulpV));
            }
            else if(size.get(ulpU) > size.get(ulpV)){
                parent.set(ulpV, ulpU);
                size.set(ulpU, size.get(ulpU)+size.get(ulpV));
            }
            else{
                parent.set(ulpU, ulpV);
                size.set(ulpV, size.get(ulpU)+size.get(ulpV));
            }
        }

        public int getTheMaxSize(){
            int maxSize = 0;
            for(int num: size){
                maxSize = Math.max(num, maxSize);
            }
            return maxSize;
        }
    }
    public int largestComponentSize(int[] nums) {
        int len = nums.length;

        int max = 1;
        for(int num:nums){
            max = Math.max(num, max);
        }

        DisjointSet disjointSet = new DisjointSet(max+1);

        /***Approach -1 Performing Find Union on Given Numbers (Giving TLE) */
        
        //Brute Force to Find Common Factor Greater Than 1
        // for(int i=0; i<len; i++){
        //     for(int j=i+1; j<len; j++){
        //         for(int fact=2; fact<=Math.min(nums[i], nums[j]); fact++){
        //             if(nums[i]%fact == 0 && nums[j]%fact == 0)
        //                 disjointSet.unionBySize(nums[i], nums[j]);
        //         }
        //     }
        // }

        //Using GCD to find common factor optimally
        // for(int i = 0; i < len; i++) {
        //     for(int j = i + 1; j < len; j++) {
        //         if(gcd(nums[i], nums[j]) > 1)
        //             disjointSet.unionBySize(nums[i], nums[j]);
        //     }
        // }


        // return disjointSet.getTheMaxSize();

        /***Approach -2 Performing Find Union with all factors for each number */
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    disjointSet.unionBySize(num, i);
                    disjointSet.unionBySize(num, num/i);
                }
            }
        }
        Map<Integer, Integer> map = new HashMap();
        int ans = 1;
        for (int num : nums) {
            int par = disjointSet.findUltParent(num);
            map.put(par, map.getOrDefault(par, 0) + 1);
            ans = Math.max(ans, map.get(par));
        }
        return ans;
    }

    public int gcd(int a, int b) {
        while(b != 0) { 
            int temp = b;
            b = a % b;
            a = temp; 
        }
        
        return a;
    }
}