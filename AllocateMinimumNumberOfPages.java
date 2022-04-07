/*
* Given number of pages in n different books and m students. 
* The books are arranged in ascending order of number of pages. 
* Every student is assigned to read some consecutive books. 
* The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum. 
*/ 
public class AllocateMinimumNumberOfPages{
    public static void main(String[] args){
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(findMin(arr, k));
    }

    //arr is the sorted array that contains number of pages in each book. k is the number of students. 
    public static int findMin(int[] arr, int k){
        if(k > arr.length){
            return -1;
        }
        int start = arr[arr.length - 1];
        int end = sum(arr);
        int res = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(isPossible(arr, k, mid)){
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    //checks if allocation with current minimum is possible
    public static boolean isPossible(int[] arr, int k, int currentMin){
        int currentSum = 0;
        int studentsRequired = 1;
        for(int i = 0; i < arr.length; i++){
            currentSum = currentSum + arr[i];
            if(currentSum > currentMin){
                studentsRequired++;
                currentSum = arr[i];
            }
            if(studentsRequired > k){
                return false;
            }
        }
        return true;
    }

    //calculates sum of all elements in the given array
    public static int sum(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        return sum;
    }
}