class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> trustAdjacency = new HashMap<>();

        boolean[] isOrdinaryPerson = new boolean[n+1];

        for(int index=0; index<trust.length; index++){
            List<Integer> neighbors = new ArrayList<>();
            isOrdinaryPerson[trust[index][0]] = true;

            if(trustAdjacency.containsKey(trust[index][0])){
                neighbors = trustAdjacency.get(trust[index][0]);
                neighbors.add(trust[index][1]);
                trustAdjacency.put(trust[index][0], neighbors);
            }
            else{
                neighbors.add(trust[index][1]);
                trustAdjacency.put(trust[index][0], neighbors);
            }
        }

        List<Integer> possibleTownJudge = new ArrayList<>();

        for(int person = 1; person<=n; person++){
            if(!trustAdjacency.containsKey(person))
                possibleTownJudge.add(person);
        }

        for(int person: possibleTownJudge){
            boolean isJudge = canBeTownJudge(person, trustAdjacency, n);

            if(isJudge)
                return person;
        }

        return -1;        
    }

    boolean canBeTownJudge(int person, Map<Integer, List<Integer>> trustAdjacency, int n){

        //Condition-1 This person should not trust anyone, even himself/herself.
        if(trustAdjacency.containsKey(person))
            return false;
        
        for(int personLabel=1; personLabel<=n; personLabel++){
            if(trustAdjacency.containsKey(personLabel)){
                List<Integer> trustNeighbors = trustAdjacency.get(personLabel);
                boolean doesTrustJudge = false;

                for(int neighbor: trustNeighbors){
                    if(neighbor == person){
                        doesTrustJudge = true;
                        break;
                    }
                }

                if(!doesTrustJudge)
                    return false;
            }
            else if(personLabel != person){
                return false;
            }
        }
        return true;
    }
}