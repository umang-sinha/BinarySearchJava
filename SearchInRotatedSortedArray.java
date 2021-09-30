public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr =  {14, 15, 18, 2, 3, 6, 12};
        System.out.println(searchInRotatedSortedArray(arr, 15));
    }

    //divides the array into two sorted halves, the left being from 0 to minIndex - 1 and the right being minIndex to arr.length - 1. Then performs binary search on each of the halves
    public static int searchInRotatedSortedArray(int[] arr, int x){
        int minIndex = findMinElement(arr);
        int searchInLeftHalf = binarySearch(arr, x, 0, minIndex - 1);
        int searchInRightHalf = binarySearch(arr, x, minIndex, arr.length - 1);
        if(searchInLeftHalf != -1 && searchInRightHalf == -1){
            return searchInLeftHalf;
        }
        else if(searchInRightHalf != -1 && searchInLeftHalf == -1){
            return searchInRightHalf;
        }
        else {
            return -1;
        }
    }

    //finds the index of the minimum element in the given sorted rotated array arr
    public static int findMinElement(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int prev = (mid - 1 + arr.length) % arr.length;
            int next = (mid + 1) % arr.length;
            if(arr[prev] >= arr[mid] && arr[next] >= arr[mid]){
                return mid;
            }
            else if(arr[mid] <= arr[end]){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    //performs a binary search or array arr for element x in the range from index s to index e and returns the index if element is found
    public static int binarySearch(int[] arr, int x, int s, int e){
        int start = s;
        int end = e;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] > x){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
