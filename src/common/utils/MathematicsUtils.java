package common.utils;

public class MathematicsUtils {
    public static int factorial(int n){
        int result = 1;
        for(int i = n; i > 0; i--){
            result *= i;
        }

        return result;
    }
}
