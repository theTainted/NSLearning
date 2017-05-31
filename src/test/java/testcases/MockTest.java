package testcases;

/**
 * Created by syam.suryanarayanan on 5/31/2017.
 */
public class MockTest {
    public static void main(String [] args){
        int testArray[] ={1,2,3,5};
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
}
