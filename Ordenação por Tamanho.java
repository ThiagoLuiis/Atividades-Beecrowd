import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numConjuntos = scanner.nextInt();
        scanner.nextLine(); 
        
        for (int i = 0; i < numConjuntos; i++) {
            String linha = scanner.nextLine();
            String[] strings = linha.split(" ");

            ordenarPorTamanho(strings);

            System.out.println(String.join(" ", strings));
        }

        scanner.close();
    }
    
    public static void ordenarPorTamanho(String[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].length() < array[j + 1].length()) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}