package testcases;

/**
 * Created by syam.suryanarayanan on 5/31/2017.
 */
/*public class MockTest {
   public static void main(String [] args){
        int testArray[] ={1,2,3,4};
        int sum = 0;
        for (int i = 0; i < testArray.length; i++) {
            sum = sum + testArray[i];
        }
        // If sum is odd, there cannot be two subsets
        // with equal sum
        if (sum%2 == 0){
            System.out.println("the array can be partitioned to two");
        }
        else{
            System.out.println("Cannot be partitioned");
        }
    }
}*/
public class MockTest
    {
        // A utility function that returns true if there is a
        // subset of arr[] with sun equal to given sum
        static boolean isSubsetSum (int arr[], int n, int sum)
        {
            // Base Cases
            if (sum == 0)
                return true;
            if (n == 0 && sum != 0)
                return false;

            // If last element is greater than sum, then ignore it
            if (arr[n-1] > sum)
                return isSubsetSum (arr, n-1, sum);

        /* else, check if sum can be obtained by any of
           the following
        (a) including the last element
        (b) excluding the last element
        */
            return isSubsetSum (arr, n-1, sum) ||
                    isSubsetSum (arr, n-1, sum-arr[n-1]);
        }

        // Returns true if arr[] can be partitioned in two
        // subsets of equal sum, otherwise false
    static boolean findPartition (int arr[], int n)
    {
        // Calculate sum of the elements in array
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // If sum is odd, there cannot be two subsets
        // with equal sum
        if (sum%2 != 0)
            return false;

        // Find if there is subset with sum equal to half
        // of total sum
        return isSubsetSum (arr, n, sum/2);
    }

    /*Driver function to check for above function*/
    public static void main (String[] args)
    {

        int arr[] = {3, 1, 5, 9, 12};
        int n = arr.length;
        if (findPartition(arr, n) == true)
            System.out.println("Can be divided into two "+
                    "subsets of equal sum");
        else
            System.out.println("Can not be divided into " +
                    "two subsets of equal sum");
    }
}