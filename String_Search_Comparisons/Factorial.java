public class Factorial {
    public static double factorial(double in){
        for(double i = (in-1); i>0;i--){
            in = in*(i);
        }
        return in;
    }
}
