
import java.util.Scanner;

/**
 *
 * @author willi
 */
public class Pilha {
    
    
    // Pilha pilha = new Pilha();
    // Pilha.menu();
    public void menu() {

        try {
            Scanner teclado = new Scanner(System.in);
            int opcao = -1;
            do {
                System.out.println("*************************************************************************");
                System.out.println("01 - Cadastrar número");
                System.out.println("02 - Mostrar números pares entre o primeiro e o último número cadastrado");
                System.out.println("03 - Excluir número");
                System.out.println("04 - Sair");

                System.out.print("Opção:");
                opcao = teclado.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Número:");
                        push(teclado.nextInt());
                        break;
                    case 2:
                        listarPilha();
                        break;
                    case 3:
                        pop();
                        break;
                    default:
                        System.out.println("Opcao incorreta");
                        break;
                }
            } while (opcao != 4);

        } catch (Exception e) {
            System.out.println("Operação não realizada");
        }
    }

    public int numero;
    public Pilha prox;
    public Pilha topo = null;
    public Pilha aux;

    public void push(int numero) {
        Pilha novo = new Pilha();
        novo.numero = numero;
        novo.prox = topo;
        topo = novo;
        System.out.println("Número inserido na ... pilha!!");
    }

    public void pop() {
        if (topo == null) {

            System.out.println("Pilha vazia!! ");
        } else {

            System.out.println("Número " + topo.numero + " .... removido");
            topo = topo.prox;
        }
    }

    public void listarPilha() {
        if (topo == null) {
            System.out.println("Pilha vazia !!");
        } else {
            System.out.println("Consultando a .... pilha");
            aux = topo;
            while (aux != null) {
                if ((aux.numero % 2) == 0) {
                    System.out.println(aux.numero + " ");
                }
                aux = aux.prox;

            }
        }
    }

}
