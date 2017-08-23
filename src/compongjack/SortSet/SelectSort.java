package compongjack.SortSet;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 在要排序的一组数中，
 * 选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，
 * 如此循环到倒数第二个数和最后一个数比较为止。
 */
public class SelectSort {
    private  static  void  selectSort(int a[]) {
        int count = 0;
        while (count < a.length - 1) {
            for (int i = count + 1; i < a.length; i++) {
                if (a[count] > a[i]) {
                    int tem = a[i];
                    a[i] = a[count];
                    a[count] = tem;
                }
                count++;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 插入排序
     *
     * @param a
     */
    public static void sort(int a[]){
            int len=a.length;
            //int count=1;
            //int tem;
//            while (count<len){
//                //int m=count;
//                for(int i=count;i>0;i--){
//                    if(a[count]<a[i]){
//                      tem=a[count];
//                      a[count]=a[i];
//                      a[i]=tem;
//                    }
//                }
//                count++;
//            }
            //int[] b=a;
        int j=0;
            for(int i=0;i<len;i++) {
                int temp=a[i];
                for(j=i;j>0&&temp<a[j-1];j--){

                        a[j]=a[j-1];

                }
                a[j]=temp;
            }

    }

    /**
     * 选择排序
     */
    public static void SelSort(int a[]){
        int len=a.length;
        int k,temp;
        for(int i=0;i<len-1;i++){
            k=i;
            for(int j=i+1;j<len;j++){
                if(a[j]<a[k]){
                    k=j;
                }
            }
            temp=a[i];
            a[i]=a[k];
            a[k]=temp;
        }
    }

    /**
     * shell排序，希尔排序，就是加强的直接插入排序，只是加了一个增量，每循环一次，增量缩小为一半
     * @param
     */
    private static void shellsort(int a[]){
        int len=a.length;
        int j;
        int tem;
        for(int increment=len/2;increment>0;increment/=2){
            for(int i=increment;i<len;i++){
                tem=a[i];
                for(j=i;j>=increment;j-=increment){
                    if(tem>a[j-increment]){
                        a[j]=a[j-increment];
                    }
                    else {
                        break;
                    }
                }
                a[j]=tem;
            }
        }

    }

    /**
     * 归并排序
     * 是将一个待排序的序列分为多个子序列，依次排序，然后再合并成一个新
     * 的序列
     * 体现了分治法的思想
     *
     * 核心步骤：分序列，两个序列同时排序，合并（重要步骤）
     * @param
     */
    public static void mergeSort(int a[],int low,int high){
        int middle=(low+high)/2;
        if(low<high) {
            mergeSort(a, low, middle);
            mergeSort(a, middle + 1, high);
            merge(a, low, middle, high);
        }
        
    }
    /**
    进行合并
     */
    private static void merge(int[] a, int low, int middle, int high) {
        int[] tem = new int[high-low];
        int i=low;
        int j=middle+1;
        int k=0;
        /**
         * 重点就是小于等于号的判定
         * 以及最后将临时数组替换为自身数组的关键点就是要加上low,
         * 因为要经过很多次的合并
         */
        while(i<=middle&&j<high){
            if(a[i]<a[j]){
                tem[k++] = a[i++];
            }
            else{
                tem[k++] = a[j++];
            }
        }
        while(i<=middle){
            tem[k++] = a[i++];
        }
        while(j<high){
            tem[k++] = a[j++];
        }
        for(int t=0;t<tem.length;t++){
            a[t+low] = tem[t];
        }
    }

    /***
     * 堆排序，是选择排序的改良版本
     * （选择排序：核心思想就是，在未排序的数中找到相应的最小的数，放在已排序的队列之前
     * 有一个中间变量来代替下标
     * 然后遍历数组（从已排序的数组的下标开始遍历知道遍历完所有的数，找到最小的数
     * 然后替换
     * （就是找最小的数）
     * 。。
     *核心代码：
     *
     * 插入排序：是在已排序的后面的数依次与前面的数作比较，找到相应的比他大的或者
     * 或者比他小的最大（小）的数，插到前面
     * 插入排序的核心代码是找到一个中间变量，代替要比较的数，然后在
     * 下重循环中依次与这个数比较，找到比他小的，差插入前面
     * 核心代码是
     * for(int i=0;i<len;i++){
     *
     *    tem=num[i];
     *    //重要的代码就是在&&z中，这个作用就是找到比他小的已排序的数，然后在插入其中
     *    for(j=i;j>0&&num[j-1]>tem;j--){
     *    //将前面的数后移
     *    num[j]=num[j-1];
     * }
     *
     * 堆排序是快速排序的改良版
     *  主要就是建堆
     *  堆排序就是建立完全二叉树
     *  然后交换堆顶与堆底元素
     * @param
     *
     */
    public static void sortDui(int a[]){
        int len=a.length;
        for(int i=0;i<len-1;i++){
            BuildDui(a,len-i-1);
            swap(a,0,len-i-1);
        }
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int i, int i1) {
        int tem;
        tem=a[i];
        a[i]=a[i1];
        a[i1]=tem;
    }

    private static void BuildDui(int[] a, int lastIndex) {
            /**
            重中之重
             */
            for(int i=(lastIndex-1)/2;i>0;i--){
                int k=i;
                while(2*k<=lastIndex){
                    int rootIndex=2*k;
                    if(rootIndex<lastIndex){
                        if(a[rootIndex]<a[rootIndex+1]);
                        rootIndex++;
                    }
                    if(a[k]<a[rootIndex]){
                        swap(a,k,rootIndex);
                        k=rootIndex;
                    }else {
                        break;
                    }
                }
            }
    }

    public static void main(String[] args){
        int a[]={1,56,89,789,568,0,40,26};
        //int b[]=new int[a.length];
        int low=0;
        int high = a.length;
        //mergeSort(a,low,high);
        //shellsort(a);
        sortDui(a);
        System.out.println( "排序后的结果" );
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+ " " );
        }
    }
}
