import java.util.Scanner;

public class Main {

    static class Node {
        int id;
        Node ant;
        Node proximo;

        Node(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int m = scanner.nextInt();

            if (n == 0) break;

            Node lista = fill(n);
            Node K = lista;
            Node M = lista.ant;

            while (contar(lista) > 2) {
                K = varrerNode(K, k, 0);
                M = varrerNode(M, m, 1);

                Node auxK, auxM;

                if (K.proximo == M)
                    auxK = M.proximo;
                else
                    auxK = K.proximo;

                if (M.ant == K)
                    auxM = K.ant;
                else
                    auxM = M.ant;

                if (K == M) {
                    System.out.printf("%3d,", M.id);
                    lista = deletar(lista, K);
                } else {
                    System.out.printf("%3d%3d,", K.id, M.id);
                    lista = deletar(lista, M);
                    lista = deletar(lista, K);
                }

                K = auxK;
                M = auxM;


            }

            if (contar(lista) == 2) {
                K = varrerNode(K, k, 0);
                M = varrerNode(M, m, 1);

                if (K == M)
                    System.out.printf("%3d,%3d\n", K.id, K.proximo.id);
                else
                    System.out.printf("%3d%3d\n", K.id, K.proximo.id);
            } else {
                System.out.printf("%3d\n", lista.id);
            }
        }
    }

    static Node fill(int tamanho) {
        Node inicio = null;
        Node nodeAnt = null;

        for (int i = 1; i <= tamanho; ++i) {
            Node node = new Node(i);

            if (inicio == null) {
                inicio = node;
            } else {
                nodeAnt.proximo = node;
                node.ant = nodeAnt;
            }

            nodeAnt = node;
        }

        inicio.ant = nodeAnt;
        nodeAnt.proximo = inicio;

        return inicio;
    }

    static Node deletar(Node lista, Node reg) {
        Node nodeAnt = reg.ant;
        Node nodeNext = reg.proximo;

        if (reg == lista) {
            lista = lista.proximo;
            nodeAnt.proximo = lista;
            lista.ant = reg.ant;
        } else {
            nodeAnt.proximo = nodeNext;
            nodeNext.ant = nodeAnt;
        }

        return lista;
    }

    static int contar(Node lista) {
        int i = 1;
        Node node = lista;
        while (lista != node.proximo) {
            node = node.proximo;
            i++;
        }

        return i;
    }

    static Node varrerNode(Node lista, int n, int direction) {
        Node node = lista;
        if (direction == 0) {
            while (--n > 0) {
                node = node.proximo;
            }
        } else {
            while (--n > 0) {
                node = node.ant;
            }
        }

        return node;
    }
}