public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr1 = { 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int x = 12;
        System.out.println(orderAgnosticBinarySearch(arr1, x));
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 };
        int y = 15;
        System.out.println(orderAgnosticBinarySearch(arr2, y));
    }

    /*
    performs binary search on the array for element x and returns the
    corresponding index. Returns -1 if not found (The way the array has been
    sorted is unknown in this case)
    */
    public static int orderAgnosticBinarySearch(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        // checking whether the array is reverse sorted
        if (arr.length == 1) {
            if (arr[0] == x) {
                return 0;
            }
        }
        if(arr[0] < arr[arr.length-1]){
            while(start <= end){
                int mid = start + (end - start) / 2; //defining mid this way rather than doing (start+end)/2 helps prevent overflows
                if(arr[mid] == x){
                    return mid;
                }
                else if (arr[mid] < x){
                    start = mid - 1;
                }
                else {
                    end = mid + 1;
                }
            }
        }
        //this also takes care of the case when arr[0] == arr[arr.length - 1] (which means all the elements in the array are the same)
        else {
            while (start <= end){
                int mid = start + (end - start)/2;
                if(arr[mid] == x){
                    return mid;
                } 
                else if (arr[mid] < x){
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}