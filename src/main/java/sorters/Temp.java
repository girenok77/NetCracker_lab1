package sorters;

import java.util.Arrays;

/**
 * @author Girenok
 */
public class Temp {
    public static void main(String[] args) {
        int[] arr={24,4,2,-1,0,500,1000,2,45,20,56,75,2,56,99,53,12};
        new ArraysSortImpl(arr);

        System.out.println(Arrays.toString(arr));
    }
}
