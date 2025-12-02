public class FloodFill {
    public static int[][] floodFill( int[][] color,int sr,int sc,int newCol){
        int orgCol = color[sr][sc];
        // if the current color and the new color is same 
        if(orgCol == newCol) return color;
        boolean vis[][] = new boolean[color.length][color[0].length];
        helper(color,sr,sc,orgCol,newCol,vis);
        return color;
    }
    // helper function to perform the recursion
    public static void helper(int[][] color,int sr,int sc,int orgCol,int newCol,boolean vis[][]){
        if(sr<0 || sc<0 || sr>=color.length || sc>=color[0].length || color[sr][sc]!=orgCol || vis[sr][sc]){
            return;
        }
        vis[sr][sc] =true;
        //up 
        helper(color, sr-1, sc, orgCol, newCol,vis);
        //down
        helper(color, sr+1, sc, orgCol,newCol, vis);
        //left
        helper(color, sr, sc-1, orgCol,newCol, vis);
        //right
        helper(color, sr, sc+1, orgCol,newCol, vis);
        color[sr][sc] = newCol;
    }
    // to display the final image 
    public static void display(int[][] color){
        for(int i=0;i<color.length;i++){
            for(int j=0;j<color[0].length;j++){
                System.out.print(color[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        /*          1   1   1
                    1   1   0
                    1   0   1
        */
        int[][] color = {{1 ,1 ,1},{1 ,1 ,0},{1 ,0 ,1}};
        int sr = 1;
        int sc = 1;
        int newCol = 2;
        color = floodFill(color,sr,sc,newCol);
        display(color);
    }
}
