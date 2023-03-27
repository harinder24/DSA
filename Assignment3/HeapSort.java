
public class HeapSort {
    void swap(int aIndex, int b, int[] arr) {
        int tmp = arr[aIndex];
        arr[aIndex] = arr[b];
        arr[b] = tmp;
      }
  
      void bubbleDown(int i, int[] arr, int length){
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if(left < length){
          if(arr[left] > arr[max]){
            max = left;
          }
        }
        if(right < length){
          if(arr[right] > arr[max]){
            max = right;
          }
        }
  
        swap(max, i, arr);
        if(i != max){
          bubbleDown(max, arr, length);
        }
      }
      int remove(int[] arr, int length){
        int top = arr[0];
        arr[0] = arr[--length];
        bubbleDown(0, arr, length);
        return top;
      }
  
      void heapSort(int[] arr){
          int length =  arr.length;
          
          
         
          for (int i = length - 1; i >= 0; i--) {
            bubbleDown(i, arr, arr.length);
          }
     
          
          
      }
    
      public static void main(String[] args) {
    
        HeapSort aHeapTree = new HeapSort();
        int[] arr = {1,2,55,63,13,45,99,4,67,11,33};
        aHeapTree.heapSort(arr);
        int i = arr.length;
        while(i > 0){
          System.out.println(aHeapTree.remove(arr, i));
          i--;
        }
      } 
}
