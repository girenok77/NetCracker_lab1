package fillers;

import java.util.Random;

/**
 * @author Girenok
 * @see sorters.Sorting
 * @return arrays for testing sort methods
 */
public class Generate {


    /*Уже отсортированного массива
    (1, 2, 3, 7, ....., max);*/
    @filler
    public static int[] array1(int max){
        int[]arr=new int[max];
        for (int i=0;i<max;i++){
            arr[i]=i+1;
        }
        return arr;
    }

    /*Отсортированного массива, в конец которого дописан случайный элемент
     (1, 2, 3, 7, ....., max, X);*/
    @filler
    public static int[] array2(int max){
        int[]arr=new int[max+1];
        for (int i=0;i<max;i++){
            arr[i]=i+1;
        }
        arr[max]=new Random().nextInt(1000);
        return arr;
    }

    /*Массива, отсортированного в обратном порядке
     (max, ... , 7, 3, 2, 1);*/
    @filler
    public static int[] array3(int max){
        int[]arr=new int[max];
        for (int i=0;i<max;i++){
            arr[i]=max-i;
        }
        return arr;
    }

    /*Массива, содержащего элементы, расположенные случайным образом.*/
    @filler
    public static int[] array4(int max){
        Random r=new Random();
        int[]arr=new int[max];
        for (int a : arr) {
            a = r.nextInt(1000);
        }
        return arr;
    }
}
