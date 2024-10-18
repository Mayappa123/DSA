import java.util.*;
//Already sorted on the basis of end time..
public class Activity_Selection {

    //without sorted activities...
    public static void withoutSorting(int[][] acitivities) {
        int[][] activities = new int[start.length][3];

        for(int i=0; i<start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //Lamda function for sorting...
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        //end time basis sorted...
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity...
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for(int i=0; i<end.length; i++) {
            if(acitivities[i][1] >= lastEnd) {
                maxAct++;
                ans.addAll(activities[i][0]);
                lastEnd = acitivities[1][2];
            }
        }
    }



    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        
        //end time basis sorted...
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity...
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];

        for(int i=1; i<end.length; i++) {
            if(start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("max activities = "+maxAct);
        for(int i=0; i<ans.size(); i++) {
            System.out.println("A"+ans.get(i));
        }
        System.out.println();
    }

   
}
