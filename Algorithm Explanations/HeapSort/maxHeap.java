public class maxHeap {
    public void buildHeap(int[] arr){
        for(int i = arr.length/2 - 1; i >= 0; i--){
            heapify(arr, arr.length, i);
        }
    }
    public void heapify(int[] arr, int size, int index){
        int max_index = index;
        int left_child = index*2 + 1;
        int right_child = index*2 + 2;

        if(left_child < size && arr[left_child] > arr[max_index])
            max_index = left_child;
        if(right_child < size && arr[right_child] > arr[max_index])
            max_index = right_child;

        if(max_index != index){
            int swap = arr[index];
            arr[index] = arr[max_index];
            arr[max_index] = swap;

            heapify(arr, size, max_index);
        }
    }

    public void sortHeap(int[] arr){
        buildHeap(arr);

        for(int i = arr.length - 1; i >= 0; i--){
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;

            heapify(arr, i, 0);
        }
    }
}
