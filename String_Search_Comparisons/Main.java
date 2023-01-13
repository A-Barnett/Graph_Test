public class Main {
    public static  char[] Create_string(int input_num, int chars) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] Letters = new char[input_num];

        for (int i = 0; i < input_num; i++) {
            int x = (int) (Math.random() * chars);
            Letters[i] = alphabet[x];
        }
        return Letters;
    }
    public static  char[] Create_Input(int input_num, int chars) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] Input = new char[input_num];
        for (int i = 0; i < input_num; i++) {
            int x = (int) (Math.random() * chars);
            Input[i] = alphabet[x];
        }
        return Input;
    }

    public static void main(String[] args){
//        int chars = 10;
//        char[] Search = Create_Input(50, 10);
//        int x = 10000000;
//        for(int i = x/10; i <=x; i += x/10){
//            char[] In_str = Create_string(i,26);
//            int count = Brute_Force.brute_Force(In_str,Search);
//            System.out.println("In Size: "+ i +" Count: "+count);
//        }
//        char[] In_str = Create_string(1000000,26);
//        int kmp = KMP_Search.kmp_Search(In_str, Search);
//        System.out.println(kmp);
        double fac = Factorial.factorial(150);
        System.out.println(fac);


    }
}
