import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortIterative {
    public static int[] mergeSort(int[] arr){
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int[] x = new int[1];
            x[0] = arr[i];
            list.add(x);
        }
        int listLength = arr.length;
        int currenIndex = 0;
        while (list.get(0).length != arr.length) {
            if(listLength-1 != currenIndex){
               int[] y =  merge(list.get(currenIndex), list.get(currenIndex+1));
               list.remove(currenIndex+1);
               list.remove(currenIndex);
               list.add(currenIndex, y);
               listLength--;
               if(currenIndex == listLength){
                currenIndex = 0;
               }else{
                currenIndex++;
               }
               
            }else{
                currenIndex = 0;
            }
        }
        return list.get(0);
    }

    public static int[] merge(int[] array1, int[] array2){
        int [] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if(array1[i] < array2[j]){
                combined[index] = array1[i];
                index++;
                i++;
            }else{
                combined[index] = array2[j];
                index++;
                j++;
            }
        } 
        while(i < array1.length){
            combined[index] = array1[i];
            index++;
            i++;
        }
        while(j < array2.length){
            combined[index] = array2[j];
            index++;
            j++;
        }
        return combined;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,6};
        int[] arr2 = mergeSort(arr);
        System.out.println(Arrays.toString(arr2));
    }
}
