import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    //class to make object of Jobs 
    static class Jobs{
        int profit;
        int deadline;
        int id;

        public Jobs(int id,int deadline,int profit){
            this.profit = profit;
            this.id = id;
            this.deadline = deadline;
        }
    }

    // function the sequence the jobs 
    public static void arrangeJobs(int jobsInfo[][]){
        ArrayList<Jobs> jobList = new ArrayList<>();
        // store all jobInfo as the Jobs object int the arraylist
        for(int i=0;i<jobsInfo.length;i++){
            jobList.add(new Jobs(i,jobsInfo[i][0],jobsInfo[i][1]));

        }
        Collections.sort(jobList, (obj1,obj2) -> obj2.profit - obj1.profit); // sort in decending order
        
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i=0;i<jobList.size();i++){
            Jobs curr = jobList.get(i);
            if(curr.deadline > time ){
                seq.add(curr.id);
                time++;
            }
        }

        // print the squence;
        System.out.println(seq);
    
    }
    public static void main(String[] args) {
        int jobsInfo[][] ={{4,20} , {1,10} , {1,40} ,{1,30}};
        arrangeJobs(jobsInfo); 

    }
    
}
