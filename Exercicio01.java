import java.util.Scanner;

public class Exercicio01 {
    private Scanner teclado = new Scanner(System.in);
    public int nPessoas;
    public int c3,c5,c8,c11,c13;
    int totalPessoas = 0;

//    public void pesquisa(){
//        boolean run = true;
//        while (run) {
//            menu();
//            System.out.print("Escolha uma opção:");
//            int opcao = teclado.nextInt();
//            switch (opcao) {
//                case 1:
//                    //inicializar();
//                    break;
//                case 2:
//                    //votar();
//                    break;
//                case 3:
//                    //resultado();
//                    break;
//                default:System.out.println("Nenhuma opção selecionada");
//            }
//        }
//    }

    public  void coletarDados(){
        String mensagem = "Digite aqui Quantas pessoas asistem ao canal";

        while (true) {
            System.out.print("Digite aqui o mumero de pessoas:");
            nPessoas  = teclado.nextInt();

            totalPessoas += nPessoas;

            if(nPessoas == -1){
                break;
            }

            System.out.print(mensagem+" 3: ");
            c3 = teclado.nextInt();

            System.out.print(mensagem+" 5: ");
            c5 = teclado.nextInt();

            System.out.print(mensagem+" 8: ");
            c8 = teclado.nextInt();

            System.out.print(mensagem+" 11: ");
            c11 = teclado.nextInt();

            System.out.print(mensagem+" 13: ");
            c13 = teclado.nextInt();

            push(nPessoas,c3,c5,c8,c11,c13);

        }

        listarPilha();

    }

//    private void menu(){
//        String leftAlignFormat = "| %-15s | %-15s |%n";
//
//        System.out.format("+-----------------+-----------------+%n");
//        System.out.format("| Opção           | Codigo          |%n");
//        System.out.format("+-----------------+-----------------+%n");
//        System.out.format(leftAlignFormat,"Nova Pesquisa", "1");
//        System.out.format(leftAlignFormat,"Resultado", "2");
//        System.out.format(leftAlignFormat,"Sair", "3");
//        System.out.format("+-----------------+-----------------+%n");
//    }

//    private void resultadoPesquisa(){
//        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n";
//        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
//        System.out.format("| Casa            | Pessoas         | Canal 3         |Canal 5          |Canal 8          |Canal 11         |Canal 13         |%n");
//        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
//    }

    public Pilha topo = null;
    public Pilha aux;

    public void push(int nPessoas,int c3,int c5,int c8,int c11,int c13) {
        Pilha novo = new Pilha();

        novo.nPessoas = nPessoas;
        novo.c3 = c3;
        novo.c5 = c5;
        novo.c8 = c8;
        novo.c11 = c11;
        novo.c13 = c13;

        novo.prox = topo;
        topo = novo;
    }

    public void listarPilha() {
        c3 = 0;c5 = 0;c8 = 0;c11 = 0;c13 = 0;
        int index = 1;
        if (topo == null) {
            System.out.println("Pilha vazia !!");
        } else {
            String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n";
            System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
            System.out.format("| Casa            | Pessoas         | Canal 3         |Canal 5          |Canal 8          |Canal 11         |Canal 13         |%n");
            System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
            aux = topo;
            while (aux != null) {

                System.out.format(leftAlignFormat,index,aux.nPessoas,aux.c3,aux.c5,aux.c8,aux.c11,aux.c13);
                c3 += aux.c3;c5 += aux.c5;c8 += aux.c8;c11 += aux.c11;c13 += aux.c13;
                System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
                aux = aux.prox;
                index++;
            }

            porcentagem();
        }
    }

    public void porcentagem(){
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s |%n";
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("| Canal 3         |Canal 5          |Canal 8          |Canal 11         |Canal 13         |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format(leftAlignFormat,calcularPorcentagem(totalPessoas,c3),calcularPorcentagem(totalPessoas,c5),calcularPorcentagem(totalPessoas,c8),calcularPorcentagem(totalPessoas,c11),calcularPorcentagem(totalPessoas,c13));
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
    }

    public String calcularPorcentagem(int total,int p){
        return ((p  * 100) / total)+"%";
    }


}
