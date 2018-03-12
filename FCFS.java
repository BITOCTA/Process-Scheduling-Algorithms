package process_scheduling_algorithm;

public class FCFS {
    public static double FCFS(int[] mas) {
        double avg = 0;
        System.out.println();
        System.out.println("Let's calculate the average waiting time using process_scheduling_algorithm.FCFS algorithm");
        for (int i = 0; i < mas.length; i++) {
            for (int k = i; k > 0; k--) {
                avg += mas[k - 1];
            }

        }
        double favg = avg / mas.length;
        return favg;


    }
}
