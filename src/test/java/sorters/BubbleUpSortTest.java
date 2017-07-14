package sorters;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Girenok
 */
public class BubbleUpSortTest {
    private static int[] arr0;
    private static int[] arr1;

    @org.junit.BeforeClass
    public static void setUp() throws Exception {
        arr0 = new int[]{5, 3, 2, -5, 1};
        arr1 = new int[arr0.length];
        for (int i = 0; i < arr1.length; i++) arr1[i] = arr0[i];


        //System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(arr0));
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void sort() throws Exception {
        Sorting sorting = new BubbleUpSort(arr1);
        for (int i = 0; i < arr1.length - 1; i++) {
            if (arr1[i] > arr1[i + 1]) fail();
        }
    }


    @org.junit.Test
    public void sort1() throws Exception {
        Sorting sorting = new BubbleUpSort(arr1);


    }

    @org.junit.Test
    public void sort2() throws Exception {
        Sorting sorting = new BubbleUpSort(arr1);
        boolean bool = false;
        for (int a : arr1) {
            for (int b : arr0) {
                if (a == b) bool = true;
            }
            assertTrue(bool);
            //if(!bool)fail();
        }
    }

}