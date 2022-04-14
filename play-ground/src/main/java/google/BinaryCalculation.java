package google;
/*
    power : Use memonization technique to iterate/recurse over the power. for example : 2^4 is 2*2*2*2 which is 4*4. 
    So if you already know what 2*2 is then next computation should be 4*4.
    Binary value for 16 - 0001 0000

    https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
*/
public class BinaryCalculation {

    // this was asked during a top-interview. Binary value for 16 - 0001 0000
    static int power (int base, int pow) {
        
        if ( pow == 0 ) {
        
            return 1;
        
        } else if (pow % 2 == 0) {
        
            return power(base, pow / 2) * power(base, pow / 2);
        
        } else {
        
            return base * power(base, pow / 2 ) * power(base, pow / 2);
        
        }

    }

    static void add (int x, int y) {
        //TODO:
    }

    static void multiply (int x, int y) {
        //TODO:
    }

    static void divide (int x, int y) {

    }

    public static void main(String[] args) {

        int val = power(2, 4);
        System.out.println(val);
    }
}