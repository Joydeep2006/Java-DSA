import java.util.PriorityQueue;
public class WeakestSoldier {
    public static class Row implements Comparable<Row>{
        int soldiers;
        int idx;

        public Row(int soldiers,int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2){
            if(r2.soldiers == this.soldiers){
                return this.idx - r2.idx;
            }
            else{
                return this.soldiers-r2.soldiers;
            }
        }
    }
    public static void weakest(int rows[][],int k){
        PriorityQueue<Row>pq = new PriorityQueue<>();
        for(int i=0;i<rows.length;i++){
            int count = 0;
            for(int j=0;j<rows[0].length;j++){
                if(rows[i][j]==1){
                    count++;
                }
            }
            pq.add(new Row(count,i));
        }

        // now remove the k weakest rows
        for(int i=0;i<k;i++){
            System.out.println("R"+pq.remove().idx);
        }
    }
    public static void main(String[] args) {
        int rows[][] = {{1,0,0,0},
                        {1,1,1,0},
                        {1,1,0,0},
                        {1,0,0,0}};
        int k = 2;

        weakest(rows, k);


    }
}
