public class NumberOfRotations{
    public static void main(String[] args) {
        int[] arr =  {15, 18, 2, 3, 6, 12};
        System.out.println(findNumberOfRotations(arr));
    }

    //takes a sorted rotated array as input and returns the number of times the array has been rotated clockwise
    public static int findNumberOfRotations(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){ //number of rotations = index of minimum element. Thus finding the minimum element in the array
            int mid = start + (end - start)/2; // defining mid this way rather than doing (start+end)/2 helps prevent overflows
            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length - 1 ) % arr.length;
            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]){ //the minimum element in the rotated array will be lesser than both its neighbours
                return mid;
            }
            else if(arr[mid] <= arr[end]){ //the minimum element will be present in the unsorted part of the array. Thus finding the unsorted half
                end = mid - 1;
            }
            else if(arr[mid] >= arr[start]){
                start = mid + 1;
            }
        }
        return -1;
    }
    
}