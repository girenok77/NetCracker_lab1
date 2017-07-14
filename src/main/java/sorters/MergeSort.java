package sorters;

import java.util.Arrays;

/**
 * @author Girenok
 */
public class MergeSort extends Sorting {
    private  int[] arr;
    public MergeSort(int[]array) {
        this.arr=array;
        sort();
    }
    public  void sort(){
        if (arr.length != 1) {
            int mid = arr.length / 2;
            int[]firsthalf = Arrays.copyOfRange(arr, 0, mid);
            int[]secondhalf = Arrays.copyOfRange(arr, mid, arr.length);
            new MergeSort(firsthalf);
            new MergeSort(secondhalf);
            merge(firsthalf, secondhalf, arr);
        }
    }

    private static void merge(int[] firsthalf, int[] secondhalf, int[] arr) {
        int arrCounter = 0;
        int fHalfCounter = 0;
        int sHalfCounter = 0;
        while (arrCounter < arr.length) {
            if (fHalfCounter<firsthalf.length && sHalfCounter<secondhalf.length) {

                if (firsthalf[fHalfCounter] < secondhalf[sHalfCounter]) {
                    arr[arrCounter] = firsthalf[fHalfCounter];
                    arrCounter++;
                    fHalfCounter++;
                } else {
                    arr[arrCounter] = secondhalf[sHalfCounter];
                    arrCounter++;
                    sHalfCounter++;
                }
            }
            else{
                if(fHalfCounter>=firsthalf.length){
                    while (sHalfCounter<secondhalf.length){
                        arr[arrCounter]=secondhalf[sHalfCounter];
                        arrCounter++;
                        sHalfCounter++;

                    }
                }
                if(sHalfCounter>=secondhalf.length){
                    while (fHalfCounter<firsthalf.length){
                        arr[arrCounter]=firsthalf[fHalfCounter];
                        arrCounter++;
                        fHalfCounter++;
                    }

                }

            }

        }
    }
}
