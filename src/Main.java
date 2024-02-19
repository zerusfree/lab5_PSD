import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner MyScan = new Scanner(System.in);
        System.out.println("Введіть номер завдання: ");
        int choice = MyScan.nextInt();
        switch (choice)
        {
            case 1:
                zavd1();
                break;
            case 2:
                zavd2();
                break;
            default:
                break;
        }
    }

    public static void zavd1()
    {
        char[] A = {'a', 'b', 'c'};
        char[] B = {'x', 'y', 'z'};
        char[] C = {'0', '1'};
        String[] D = new String[18];
        int j = 0;

        for (int ic = 0; ic < C.length; ic++) {
            for (int ia = 0; ia < A.length; ia++) {
                for (int ib = 0; ib < B.length; ib++) {
                    D[j] = "" + C[ic] + A[ia] + B[ib];
                    j++;
                }
            }
        }

        for (String s : D) {
            System.out.println(s);
        }
    }

    public static int[][] zavd2()
    {
        int[] U = {1, 2, 3, 4, 5}; // універсум
        int[] A = {1, 2}; // множина A
        int[] B = {2, 3, 4}; // множина B

        // Створюємо бітові рядки для множин A та B
        int[] Abit = new int[U.length];
        int[] Bbit = new int[U.length];

        for (int i = 0; i < U.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (U[i] == A[j]) {
                    Abit[i] = 1;
                    break;
                }
            }
            for (int j = 0; j < B.length; j++) {
                if (U[i] == B[j]) {
                    Bbit[i] = 1;
                    break;
                }
            }
        }

        // Виконуємо операції над множинами
        int[] notA = new int[U.length];
        int[] AandB = new int[U.length];
        int[] AorB = new int[U.length];
        int[] AdiffB = new int[U.length];
        int[] AxorB = new int[U.length];

        for (int i = 0; i < U.length; i++) {
            notA[i] = 1 - Abit[i];
            AandB[i] = Abit[i] & Bbit[i];
            AorB[i] = Abit[i] | Bbit[i];
            AdiffB[i] = (Abit[i] == 1 && Bbit[i] == 0) ? 1 : 0;
            AxorB[i] = Abit[i] ^ Bbit[i];
        }

        // Виводимо результати
        System.out.println("A: " + Arrays.toString(Abit));
        System.out.println("B: " + Arrays.toString(Bbit));
        System.out.println("notA: " + Arrays.toString(notA));
        System.out.println("A and B: " + Arrays.toString(AandB));
        System.out.println("A or B: " + Arrays.toString(AorB));
        System.out.println("A diff B: " + Arrays.toString(AdiffB));
        System.out.println("A xor B: " + Arrays.toString(AxorB));

        return new int[][] {Abit, Bbit, notA, AandB, AorB, AdiffB, AxorB};
    }

}

