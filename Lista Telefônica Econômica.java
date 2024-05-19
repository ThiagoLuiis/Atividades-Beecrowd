import java.io.IOException;
import java.util.*;

class Numero {
    String num;
}

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n, i, j;
        int cont;
        Numero comp;

        while (scanner.hasNext()) {
            n = scanner.nextInt();
            scanner.nextLine();
            Numero[] array = new Numero[n];
            cont = 0;
            for (i = 0; i < n; i++) {
                array[i] = new Numero();
                array[i].num = scanner.nextLine();
            }

            Arrays.sort(array, (a, b) -> a.num.compareTo(b.num));

            comp = array[0];
            for (i = 1; i < n; i++) {
                for (j = 0; j < array[i].num.length(); j++) {
                    if (comp.num.charAt(0) != array[i].num.charAt(0)) {
                        comp = array[i];
                        break;
                    } else if (comp.num.charAt(j) == array[i].num.charAt(j)) {
                        cont++;
                    } else {
                        comp = array[i];
                        break;
                    }
                }
            }
            System.out.println(cont);
        }
        scanner.close();
    }
 
}
