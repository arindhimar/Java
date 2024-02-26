import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s;

        System.out.print("Enter String: ");
        s = sc.nextLine();

        char[] chArr = new char[s.length()];
        int[] intArr = new int[s.length()];

        int ct = -1; 

        for (int i = 0; i < s.length(); i++) {
            int flag = 0;
            for (int j = 0; j <= ct; j++) {
                if (chArr[j] == s.charAt(i)) {
                    intArr[j] = intArr[j] + 1;
                    flag = 1;
                }
            }

            if (flag == 0) {
                ct++;
                chArr[ct] = s.charAt(i);
                intArr[ct] = 1;
            }
        }


        System.out.println("Character counts:");
        for (int i = 0; i <= ct; i++) {
            System.out.println("'" + chArr[i] + "': " + intArr[i]);
        }
    }
}
