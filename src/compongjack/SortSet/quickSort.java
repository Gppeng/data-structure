package compongjack.SortSet;

import java.util.Scanner;

/**
 * 快速排序
 * 时间复杂度(nlogn)
 * 原理：将一个要排序的数组，分成两部分，分别进行排序（首先通过一趟排序找到一个中轴，一边的数总是比另一边的数小
 * 要点：找到一个标志位，一般以第一位作为标识点（中轴数）
 *
 * 通过递归的方式一直下去，直到所有的数都排序完成
 * @param
 */
public class quickSort {
    private static  int QuickSortMiddle(int[] e,int low,int high){
        int tem=e[low];
        /**
         * 找到中轴点
         */
        while(low<high){
            while((low < high) && (tem <= e[high])){
                high--;
            }
            e[high]=e[low];
            while((low < high) && (e[low] < tem)){
                    low++;
            }
            e[low]=e[high];
        }
             e[low]=tem;
        return low;
    }
    private static void quicksort(int a[],int low,int high){
        if(low<high) {
            int middle = QuickSortMiddle(a, low, high);
            quicksort(a,low,middle-1);
            quicksort(a,middle+1,high);
        }
    }
    private  static void printArray(int a[],int low,int high){
        for(int i=low;i<high;i++){
            System.out.print( a[i]+"  " );
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n;

        n=scanner.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
         a[i]=scanner.nextInt();
        }
        //System.out.println( a[1] );
        quicksort(a,0,a.length-1);
        printArray(a,0,a.length-1);
    }
}
