package sorters;

/**
 * @author Girenok
 */
public  abstract class Sorting {



    public static void swap(int i, int j,int[]array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public abstract void sort();
}
