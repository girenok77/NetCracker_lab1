package sorters;

import java.util.Arrays;

/**
 * @author Girenok
 * Implementing of library sort method(QuickSort)
 */
public class ArraysSortImpl extends Sorting  {
    private  int[] array;
    public ArraysSortImpl(int[]array) {
        this.array=array;
        sort();
    }
    public  void sort(){
        Arrays.sort(array);
    }
}
