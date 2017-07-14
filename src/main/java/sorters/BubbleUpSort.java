package sorters;

/**
 * @author Girenok
 */
public class BubbleUpSort extends Sorting {
    private  int[] arr;
    public BubbleUpSort(int[]array) {
        this.arr=array;
        sort();
    }
    public void sort(){
        for (int i=0;i<arr.length-1;i++) {
            boolean isSwapped=false;
            for(int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]) {
                    swap(j,j+1,arr);
                    isSwapped=true;

                }
            }
            if(!isSwapped)break;

        }
    }
}
