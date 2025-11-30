public class DisjointSet{
    static int n = 8;
    static int par[] = new int[n];
    static int rank[] = new int[n];
    // to initialise the parent array
    public static void init(){
        for(int i=0;i<n;i++){
            par[i] = i;
        }
    }
    // to find the parent of a set
    public static int find(int x){
        if(x == par[x]){
            return x; 
        }
        return par[x] = find(par[x]);
    }
    // to union of two sets
    public static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);
        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA]>rank[parB]){
            par[parB] = parA;
        }
        else{
            par[parA] = parB;
        }
    }
    public static void main(String[] args) {
        init();
        System.out.println(find(1));
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(3,7);
        System.out.println(find(7));
    }
}
