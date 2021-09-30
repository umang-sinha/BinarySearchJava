public class MaximumElementInBitonicArray {
    public static void main(String[] args) {
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        System.out.println(findMaxInBitonicArray(arr));
    }

    //returns the maximum element in a bitonic array. A Bitonic array that monotonically increases and then monotonically decreases
    //this is the same as finding peak element
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
}
