package sorters;

/**
 * @author Girenok
 */
public class QuickSort extends Sorting {
    private  int[] array;

    public QuickSort(int[]array) {
        this.array=array;
        sort();
    }

    public  void sort() {
        if (array == null || array.length == 0) {
            return;
        }

        int length = array.length;
        quickSort(0, length - 1);
    }

    private  void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;

        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];

        while (i <= j) {

            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j,array);

                i++;
                j--;
            }
        }
        //recursion
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
}
