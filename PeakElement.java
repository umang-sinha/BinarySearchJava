public class PeakElement { 
    public static void main(String[] args){
        int[] arr = {1,2,3,1};
        System.out.println(findPeakElement(arr));
    }

    //takes an unsorted array as input and returns the index of a peak element. A peak element is an element that is greater than both its neighbours
    public static int findPeakElement(int[] arr){
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
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                return mid;
            }
            else if(arr[mid+1] > arr[mid]){
                start = mid + 1;
            }
            else if(arr[mid - 1] > arr[mid]){
                end = mid - 1;
            }
        }
        return -1;
    }
}
