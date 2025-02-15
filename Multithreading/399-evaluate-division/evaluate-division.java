class Solution {
    class Pair{
        String denominator;
        double value;
        Pair (String deno, double val){
            this.denominator = deno;
            this.value = val;
        }
    }
    private void addRelationship(String first, String second, double value, Map<String, List<Pair>> equationsMap){
            List<Pair> relationships = new ArrayList<>();
            if(equationsMap.containsKey(first)){
                relationships = equationsMap.get(first);
            }
            Pair relationship = new Pair(second, value);
            relationships.add(relationship);

            equationsMap.put(first, relationships);
    }

    private double[] evaluateQueries(List<List<String>> queries, Map<String, List<Pair>> equationsMap){
        int totalQueries = queries.size();
        double[] evaluations = new double[totalQueries];

        int index = 0;
        for(List<String> query: queries){
            String source = query.get(0);
            String dest = query.get(1);
            
            double value = -1.0;
            if(equationsMap.containsKey(source)){
                if(source == dest)
                    value = 1.0;
                else{
                    Set<String> visited = new HashSet<>();
                    value = dfsTraversalOnRelations(source, dest, equationsMap, visited);
                }
            }
            evaluations[index++] = value;            
        }
        return evaluations;
    }

    private double dfsTraversalOnRelations(String source, String dest, Map<String, List<Pair>> equationsMap, Set<String> visited){
        visited.add(source);
        if(equationsMap.containsKey(source)){
            for(Pair relation: equationsMap.get(source)){
                String denominator = relation.denominator;

                if(denominator.equals(dest))
                    return relation.value;

                if(!visited.contains(denominator)){
                    double value = dfsTraversalOnRelations(denominator, dest, equationsMap, visited);
                    if(value != -1.0)
                        return relation.value * value;
                }
            }
        }
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> equationsMap = new HashMap<>();
        for(int index=0; index<equations.size(); index++){
            String first = equations.get(index).get(0);
            String second = equations.get(index).get(1);

            addRelationship(first, second, values[index], equationsMap);
            addRelationship(second, first, 1/values[index], equationsMap);
        }
        return evaluateQueries(queries, equationsMap);
    }
}