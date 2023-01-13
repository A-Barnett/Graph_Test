import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x =scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int a = scanner.nextInt();
        if(x == 1) {
            if(y==1) {
                if(z != 1) {
                    if(a <= 1) {
                        System.out.println("Hello World");
                    }
                }
            }
        }


    }
}
