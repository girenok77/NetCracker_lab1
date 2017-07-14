package sorters;

/**
 * @author Girenok
 */
public class BubbleDownSort extends Sorting {
    private  int[] arr;

    public BubbleDownSort(int[]array) {
        this.arr=array;
        sort();
    }
    public  void sort(){
        for(int i=0;i<arr.length-1;i++){
            boolean isSwapped=false;
            for (int j=arr.length-1;j>i;j--){
                if(arr[j]<arr[j-1]){
                    swap(j,j-1,arr);
                    isSwapped=true;
                }
            }
            if(!isSwapped)break;
        }
    }
}
