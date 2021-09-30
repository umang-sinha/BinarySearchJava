public class SearchInBitonicArray {
    public static void main(String[] args) {
        int[] arr = {0,1,2,4,2,1};
        System.out.println(searchInBitonicArray(arr, 3));
    }

    public static int searchInBitonicArray(int[] arr, int x){
        int maxInBitonicArray = findMaxInBitonicArray(arr);
        int searchInIncreasingHalf = binarySearchInIncreasingHalf(arr, x, 0, maxInBitonicArray);
        int searchInDecreasingHalf = binarySearchInDecreasingHalf(arr, x, maxInBitonicArray, arr.length - 1);
        if(searchInDecreasingHalf == -1 && searchInIncreasingHalf != -1){
            return searchInIncreasingHalf;
        }
        else if(searchInDecreasingHalf != -1 && searchInIncreasingHalf == -1){
            return searchInDecreasingHalf;
        }
        else if(searchInDecreasingHalf != -1 && searchInIncreasingHalf != -1){
            return searchInIncreasingHalf;
        }
        else {
            return -1;
        }
    }

    public static int findMaxInBitonicArray(int[] arr){
        if(arr.length == 1){
            return 0;
        }
        if(arr[0] > arr[1]){
            return 0;
        }
        if(arr[arr.length - 1] > arr[arr.length - 2]){
            return arr.length - 1;
        }
        int start = 1;
        int end = arr.length - 2;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return mid;
            }
            else if(arr[mid+1] > arr[mid]){
                start = mid + 1;
            }
            else if(arr[mid-1] > arr[mid]){
                end = mid - 1;
            }
        }
        return -1;
    }

    //performs binary search on array arr for element x in the monotonically increasing part of the bitonic array 
    public static int binarySearchInIncreasingHalf(int[] arr, int x, int s, int e){
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

    //performs binary search on array arr for element x in the monotonically decreasing part of the bitonic array 
    public static int binarySearchInDecreasingHalf(int[] arr, int x, int s, int e){
        int start = s;
        int end = e;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] > x){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

}