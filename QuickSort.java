package QuickSortDescending;

public class QuickSort {
    private int[] data;

    public void setData(int[] data){
        this.data = data;
    }

    private int partition(int start, int end){
        int pivot = this.data[end];
        int i = (start-1);
        for (int j=start;j<=end-1;j++){
            if (this.data[j]<pivot){
                i++;
                int t =this.data[i];
                this.data[i]=this.data[j];
                this.data[j]=t;
            }
        }
        int t = this.data[i+1];
        this.data[i+1]=this.data[end];
        this.data[end] = t;
        return (i+1);
    }

    public void quickSort(int start,int end){
        if(start < end){
            int p = partition(start,end);
            quickSort(start,p-1);
            quickSort(p+1, end);
        }
    }
    public void printArr(int n){
        int i;
        for(i = 0;i<n ; i++)
            System.out.println(this.data[i] + " ");
    }
}
