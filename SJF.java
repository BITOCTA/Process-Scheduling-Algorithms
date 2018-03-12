package process_scheduling_algorithm;

public class SJF {
    public static double SJF(int[] mas) {
        double avg = 0;
        System.out.println("");
        System.out.println("Let's calculate the average waiting time using process_scheduling_algorithm.SJF algorithm");
        int t;
        for (int i = 0; i < mas.length; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                if (mas[j] < mas[i]) {
                    t = mas[i];
                    mas[i] = mas[j];
                    mas[j] = t;
                }
            }
        }
        for (int i = 0; i < mas.length; i++) {

            for (int k = i; k > 0; k--) {
                avg += mas[k - 1];
            }

        }
        double favg = avg / mas.length;
        return favg;


    }
}
