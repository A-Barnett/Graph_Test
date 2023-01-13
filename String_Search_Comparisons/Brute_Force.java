public class Brute_Force {
    public static int brute_Force(char[] in_str, char[] search) {
        int count = 0, cases = 0;
        for (int i = 0; i <= (in_str.length - search.length); i++) {
            int x = 0;
            for (int n = 0; n < search.length; n++) {
                if (in_str[i + n] == search[n]) {
                    x++;
                    count++;
                } else {
                    count++;
                    break;
                }
            }
            if (x == search.length) {
                cases++;

            }

        }
        return count;

    }
}
