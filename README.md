# data-structure
Learn data structure by myself in one week.

## 知识点
- 冒泡排序
- 插入排序
- 快速排序
- 堆排序
- 归并排序
- 希尔排序
- 选择排序
- 
---
## 时间复杂度       
1 冒泡 BubbleSort（）  
O(n^2)（平均） O(n)(最好） O(n^2)（最坏） 稳定

实现理念：让要比较的数组和后面的数据依次作比较，遇到比他大的或者比他小的数据交换数据
```
int tem;
for(int i=0;i<length-1;i++)
  for(int j=i+1;j<length;j++)
  {
    if(a[i]>a[j]){
     tem  = a[i];
     a[i] = a[j];
     a[j] = tem;
     }
  }
```
2 选择 SelectSort（）

O(n^2)(平均） O(n^2)（最好）  O(n^2)(最坏） 不稳定

实现理念：就是找到最小的数据，然后依次和前面已排序的数据作比较，然后交换数据
```
int k;
for( int i =0 ; i<n-1;i++){
  k=i;//记录i的位置，便于在后面找到符合排序的数据进行交换（即用k来和j比较）
  for(int j=i+1;j<n;j++){
  if(a[k]<a[j]){
  k=j;
  }
  tem =a[k];
  a[k] = a[i];
  a[i] = tem;
}
```
3 插入 InsertSort()

O(n^2)(平均）  O(n)(最好)   O(n^2)(最坏)  稳定

实现理念：在已排序最后一个数与未排序各数比较，找到最小的数，比这个数小（最小），插入到这个数之前
```
for(int i=0;i<n;i++){
int tem =a[i];
  for(int j=i;j>0&&a[j-1]>tem;j--){
      a[j] = a[j--];
      }
      a[j] =tem;   
   }
```
4 希尔 ShellSort() 插入排序的升级版

O(n^1.3)(平均)  O(n)(最好） O(n^2)(最坏）不稳定

实现理念：插入排序的升级，插入排序每次只能加一比较，希尔排序增加一个增量，每次增量/2
```
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
```
5 快速 QuickSort() 

O(nlogn)（平均） O(nlogn)(最好） O(n^2)(最坏)  不稳定

实现理念：分成两块各自进行遍历排序，首先要设置一个low起始点（刚开始一般是0），high(最高点，一般刚开始是数组长度)，主要就是找到中轴点，先遍历一遍找到中州店
然后递归，实现排序
```
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
```
6 归并 MergeSort(T a[],int low,int high) 

O(nlog(n))(平均） O(nlog(n))(最好） O(nlog(n)) (最坏）稳定

实现理念：采用分治法的思想，将长度为n的数组划分为很多小数组，分别进行排序，然后进行合并，合成完整有序的数组
```
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
```



