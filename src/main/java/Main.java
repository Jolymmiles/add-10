import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, i = 0, ans = 0, n1 = 0;

        do {
            n1 = sc.nextInt();
            n += n1;
            if (n1 == 0) break;
            i += 1;
            if (n == 10 & ans == 0) ans = i;
        }while (n != 0);

        System.out.println(ans);
    }
}