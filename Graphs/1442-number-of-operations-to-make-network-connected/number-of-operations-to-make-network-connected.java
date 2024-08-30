class DisjointSet {
    public List<Integer> parent = new ArrayList<> ();
    public List<Integer> rank = new ArrayList<> ();

    DisjointSet (int verticesCount) {
        for(int i=0; i<verticesCount; i++){
            rank.add(0);
            parent.add(i);
        }
    }

    int findUltimateParent (int node){
        if(node == this.parent.get(node))
            return node;
        else{
            int ulp = findUltimateParent (this.parent.get(node));
            parent.set(node, ulp);
            return ulp;
        }
    }

    void unionByRank (int nodeU, int nodeV){
        int ulpNodeU = findUltimateParent(nodeU);
        int ulpNodeV = findUltimateParent(nodeV);

        if(ulpNodeU == ulpNodeV)    return;

        if(this.rank.get(ulpNodeU) < this.rank.get(ulpNodeV)){
            this.parent.set(ulpNodeU, ulpNodeV);
        }
        else if(this.rank.get(ulpNodeV) < this.rank.get(ulpNodeU)){
            this.parent.set(ulpNodeV, ulpNodeU);
        }
        else{
            this.parent.set(ulpNodeU, ulpNodeV);
            this.rank.set(ulpNodeV, this.rank.get(ulpNodeV) + 1);
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        //We can remove the cables in such a way that all comps are still in connected components
        //Step-1 Count extra edges which can be used to connect other components  (MST variation)
        //Step-1 Count all connected components. Min Operations = #connectedComp - 1 (ans) (v-1)
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;

        for(int row=0; row<connections.length; row++){
            int node1 = connections[row][0];
            int node2 = connections[row][1];

            int ulp1 = ds.findUltimateParent(node1);
            int ulp2 = ds.findUltimateParent(node2);

            if(ulp1 == ulp2){
                extraEdges++;
            }
            else{
                ds.unionByRank(node1, node2);
            }
        }

        int connectedComponentCount = 0;
        for(int i=0; i<n; i++){
            if(ds.parent.get(i) == i)
                connectedComponentCount++;
        }

        if(extraEdges >= connectedComponentCount-1) return connectedComponentCount-1;

        return -1;
    }
}