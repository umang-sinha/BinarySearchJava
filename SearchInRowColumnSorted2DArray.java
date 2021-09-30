public class SearchInRowColumnSorted2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            { 10, 20, 30, 40 },
            { 15, 25, 35, 45 },
            { 27, 29, 37, 48 },
            { 32, 33, 39, 50 }
        };
        searchInRowColumnSorted2DArray(arr, 39);
    }

    public static void searchInRowColumnSorted2DArray(int[][] arr, int x){
        int i = 0;
        int j = arr.length - 1;
        while(i >= 0 && i <= arr[0].length - 1 && j >= 0 && j <= arr.length - 1){
            if(arr[i][j] == x){
                break;
            }
            else if(arr[i][j] > x){
                j--;
            }
            else if(arr[i][j] < x){
                i++;
            }
        }

        if(i >= 0 && i <= arr[0].length - 1 && j >= 0 && j <= arr.length - 1){
            System.out.println(i + " " + j);
        }
        else {
            System.out.println("Not found");
        }
        
    }
}
