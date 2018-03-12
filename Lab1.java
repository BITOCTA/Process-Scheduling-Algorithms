package process_scheduling_algorithm;

import java.util.*;

public class Lab1 {

    public static int[] CreateRandom() {
        int min =2;
        int max =10;
        max-=min;
        int m = (int) (Math.random()*++max)+min;

        int[] mas = new int[m];
        System.out.println("The number of " + m + " processes was created");
        for (int i = 0; i < mas.length; i++) {
            double k = Math.random();
            int l = (int) (k * 100);

            System.out.println("The burst time of the process [" + i + "] is " + l);
            mas[i] = l;
        }
        return mas;
    }






    public static int[] procn(int mas[])
    {
        int n = mas.length;
        int[] k = new int[n];
        for(int i=1;i<=n;i++)
        {
            k[i-1]=i;
        }
        return k;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        outer1:
        while (true) {
            System.out.println("Pls, enter the number of the operation you want to do");
            System.out.println("1. Create a new set of processes");
            System.out.println("2. Conclusion");
            System.out.println("0. Quit");
            int choice = in.nextInt();

            double fifo_wt=0;
            double sjf_wt=0;
            double rr_wt=0;
            switch (choice) {

                case 1: {
                    int[] mas = CreateRandom();
                    outer:
                    while (true) {

                        {
                            System.out.println("------------------------------------------------------");
                            System.out.println("Pls, enter the number of the operation you want to do");
                            System.out.println("1. Calculate the average waiting time using FIFO algorithm");
                            System.out.println("2. Calculate the average waiting time using process_scheduling_algorithm.SJF algorithm");
                            System.out.println("3. Calculate the average waiting time using process_scheduling_algorithm.RoundRobin algorithm");
                            System.out.println("4. Previous ");
                            int choice1 = in.nextInt();


                            switch (choice1) {
                                case 1: {
                                    System.out.println(FCFS.FCFS(mas));
                                    continue outer;

                                }
                                case 2: {
                                    System.out.println(SJF.SJF(mas));
                                    continue outer;
                                }
                                case 3: {
                                    int[] proc = procn(mas);
                                    int n = mas.length;
                                    System.out.println("Pls enter the quantum time");
                                    int quantum = in.nextInt();
                                    System.out.println(RoundRobin.findavgTime(proc, n, mas, quantum));
                                    continue outer;
                                }
                                case 4:{
                                    continue outer1;
                                }
                            }
                        }
                    }
                }

                case 0: {
                    break;
                }
                case 2:{
                    outer3: while (true){
                    System.out.println("1. FIFO");
                    System.out.println("2. process_scheduling_algorithm.SJF");
                    System.out.println("3. process_scheduling_algorithm.RoundRobin");
                   int choice2 = in.nextInt();

                   switch(choice2)
                   {
                       case 1:{
                           System.out.println("------");
                           System.out.println("It is most suitable for long, time-consuming CPU processes;\n Bad usage of CPU and device I/o;\n The average waiting time varies greatly.");
                           System.out.println("------");
                           break outer3;
                       }
                       case 2:{
                           System.out.println("------");
                           System.out.println("Processes already running on the CPU are pushed out by the closest job to completion;\n Less overall turnaround time of the process;\nLess CPU waiting time");
                           System.out.println("------");
                           break outer3;
                       }
                       case 3:{
                           System.out.println("------");
                           System.out.println("If q(tends to ∞), then the RR algorithm degenerates to FIFO;\n" +
                                   "If q is small (but does not tend to 0, otherwise the PC will only switch processes and no longer perform anything at all), then everything is fine;\n" +
                                   "No starvation;\n" +
                                   "There is a high responsiveness of the system;\n" +
                                   "Equal distribution of time;\n" +
                                   "If q is less than the time it takes to switch context, then the manager will be ineffective.");
                           System.out.println("------");
                           break outer3;
                       }
                   }
                }
                }
            }
        }
    }






    }



