//1792. Maximum Average Pass Ratio

// There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. 
//You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.

// You are also given an integer extraStudents. 
//There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. 
//You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.

// The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. 
//The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.

// Return the maximum possible average pass ratio after assigning the extraStudents students. 
//Answers within 10-5 of the actual answer will be accepted.

import java.util.*;

public class Maximum_Average_Pass_Ratio {

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max heap to store classes based on the potential gain in pass ratio
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Initialize the heap with the initial gains for all classes
        for (int[] cls : classes) {
            int passi = cls[0], totali = cls[1];
            double currentGain = gain(passi, totali);
            maxHeap.offer(new double[] { currentGain, passi, totali });
        }

        // Distribute the extra students
        while (extraStudents > 0) {
            // Get the class with the largest potential gain
            double[] top = maxHeap.poll();
            double currentGain = top[0];
            int passi = (int) top[1];
            int totali = (int) top[2];

            // Add one extra student
            passi++;
            totali++;
            extraStudents--;

            // Recalculate the gain and push back to the heap
            double newGain = gain(passi, totali);
            maxHeap.offer(new double[] { newGain, passi, totali });
        }

        // Calculate the final average pass ratio
        double totalRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int passi = (int) top[1];
            int totali = (int) top[2];
            totalRatio += (double) passi / totali;
        }

        return totalRatio / classes.length;
    }

    // Function to calculate the potential gain of adding one student to a class
    private static double gain(int passi, int totali) {
        double currentRatio = (double) passi / totali;
        double newRatio = (double) (passi + 1) / (totali + 1);
        return newRatio - currentRatio;
    }

    public static void main(String[] args) {
        int[][] classes = { { 1, 2 }, { 3, 5 }, { 2, 2 } };
        int extraStudents = 2;

        System.out.println(maxAverageRatio(classes, extraStudents)); // 0.7833333333333333
        // Explanation:
        // You can assign the two extra students to the first class.
        // The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
    }
}
