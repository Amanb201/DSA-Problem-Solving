class Solution {
    class DisjointSet {
        List<Integer> parent;
        List<Integer> size;
        List<Integer> rank;

        DisjointSet(int n){
            parent = new ArrayList<>();
            size = new ArrayList<>();
            rank = new ArrayList<>();

            for(int i=0; i<=n; i++){
                parent.add(i);
                size.add(1);
                rank.add(0);
            }
        }

        public int findUParent(int node){
            if(node == parent.get(node)){
                return node;
            }

            int ulp = findUParent(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v){
            int ulpNodeU = findUParent(u);
            int ulpNodeV = findUParent(v);

            if(ulpNodeU == ulpNodeV)
                return;

            if(rank.get(u) < rank.get(v)){
                parent.set(u, v);
            }
            else if(rank.get(u) > rank.get(v)){
                parent.set(v, u);
            }
            else{
                parent.set(u, v);
                int rankV = rank.get(v);
                rank.set(v, rankV+1);
            }
        }

        public void unionBySize(int u, int v) {
            int ulpU = findUParent(u);
            int ulpV = findUParent(v);

            if(ulpU == ulpV)    return;

            if(size.get(ulpU) < size.get(ulpV)){
                parent.set(ulpU, ulpV);
                size.set(ulpV, size.get(ulpU) + size.get(ulpV));
            }
            else if (size.get(ulpU) > size.get(ulpV)) {
                parent.set(ulpV, ulpU);
                size.set(ulpU, size.get(ulpU) + size.get(ulpV));
            }
            else{
                parent.set(ulpV, ulpU);
                size.set(ulpU, size.get(ulpU) + size.get(ulpV));
            }
        }

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        Map<String, Integer> emailMap = new HashMap<>();
        DisjointSet disjointSet = new DisjointSet(len);

        for(int accountInd=0; accountInd<len; accountInd++){
            for(int emailInd = 1; emailInd<accounts.get(accountInd).size(); emailInd++){
                if(!emailMap.containsKey(accounts.get(accountInd).get(emailInd))){
                    emailMap.put(accounts.get(accountInd).get(emailInd), accountInd);
                }else{
                    int edgeU = emailMap.get(accounts.get(accountInd).get(emailInd));
                    int edgeV = accountInd;
                    disjointSet.unionBySize(edgeU, edgeV);
                }
            }
        }
        
        Map<Integer, List<String>> ansMap = new HashMap<>();

        for(String email: emailMap.keySet()){
            int node = emailMap.get(email);
            int ulp = disjointSet.findUParent(node);

            List<String> emails;    
            if(ansMap.containsKey(ulp)){
                emails = ansMap.get(ulp);
            }
            else{
                emails = new ArrayList<>();
            }
            emails.add(email);
            ansMap.put(ulp, emails);
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        for(int accountInd: ansMap.keySet()){
            String name = accounts.get(accountInd).get(0);

            List<String> mergedEmails = ansMap.get(accountInd);
            Collections.sort(mergedEmails);

            List<String> ans = new ArrayList<>();
            ans.add(name);
            ans.addAll(mergedEmails);
            
            mergedAccounts.add(ans);
        }

        return mergedAccounts;
    }
}