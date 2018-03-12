package process_scheduling_algorithm;

import java.util.*;

public class RoundRobin
{

    static void findWaitingTime(int processes[], int n,
                                int bt[], float wt[], int quantum)
    {
        float rem_bt[] = new float[n];
        for (int i = 0 ; i < n ; i++)
            rem_bt[i] =  bt[i];

        float t = 0;

        while(true)
        {
            boolean done = true;

            for (int i = 0 ; i < n; i++)
            {

                if (rem_bt[i] > 0)
                {
                    done = false;

                    if (rem_bt[i] > quantum)
                    {

                        t += quantum;
                        rem_bt[i] -= quantum;
                    }

                    else
                    {
                        t = t + rem_bt[i];
                        wt[i] = t - bt[i];
                        rem_bt[i] = 0;
                    }
                }
            }

            if (done == true)
                break;
        }
    }

    static float findavgTime(int processes[], int n, int bt[],
                            int quantum)
    {
        System.out.println("Let's calculate the average waiting time using process_scheduling_algorithm.RoundRobin algorithm");

        float wt[] = new float[n], tat[] = new float[n];
        float total_wt = 0, total_tat = 0;

        findWaitingTime(processes, n, bt, wt, quantum);

        for (int i=0; i<n; i++)
        {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
        }
        float k = total_wt/n;
        return k;
    }

    public static void main(String[] args)
    {

    }
}