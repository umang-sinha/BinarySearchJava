public class BinarySearchOnReverseSortedArray{
    public static void main(String[] args){
        int[] arr = {23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int x = 12;
        System.out.println(binarySearch(arr, x));
    }

    //performs a binary search on the given reverse sorted array for x and returns the correpnding index. If not found, returns -1
    public static int binarySearch(int arr[], int x){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2; //defining mid this way rather than doing (start+end)/2 helps prevent overflows
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
        return -1;
    }
}