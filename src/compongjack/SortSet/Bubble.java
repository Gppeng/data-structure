package compongjack.SortSet;

import java.util.Scanner;

public class Bubble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            double[] a = new double[n];
            for(int i=0;i<n;i++){
                a[i] = scanner.nextDouble();
            }
            for (int i = 0; i < n - 1; i++)
                for (int j = i + 1; j < n; j++) {
                       double tem;
                       if(a[i]>a[j]){
                           tem=a[j];
                           a[j]=a[i];
                           a[i]=tem;
                       }
                }
                for(int i=0;i<n;i++)
                System.out.println( a[i]+" " );
        }
    }
}
