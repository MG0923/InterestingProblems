/* Java program for Merge Sort */
class MergeSort {
    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[(high - low + 1)];
        int left = low;
        int right = mid + 1;
        int k = 0; // index in temp array

        //will run till the array's are of same size
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp[k] = arr[left];
                left++;
            } else {
                temp[k] = arr[right];
                right++;
            }
            k++;
        }

        while (left <= mid) {
            temp[k] = arr[left];
            left++;
            k++;
        }

        while (right <= high) {
            temp[k] = arr[right];
            right++;
            k++;
        }

        //copying temp array to main array
        System.arraycopy(temp, 0, arr, low, temp.length);
    }

    //divide array's
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + (high - 1)) / 2;

            sort(arr, low, mid);
            sort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}