package Greedy;

import java.util.*;

public class JobSequencing {
    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String args[]) {
        int JobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < JobsInfo.length; i++) {
            jobs.add(new Job(i, JobsInfo[i][0], JobsInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit); // descending order of profit

        ArrayList<Integer> ans = new ArrayList<>();
        int time = 0;

        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                ans.add(curr.id);
                time++;
            }
        }

        System.out.println("Maximum jobs that can be done: " + ans.size());

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }
}
