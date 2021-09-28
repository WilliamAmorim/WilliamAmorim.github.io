import java.util.Scanner;

public class Exercicio02 {
    private Scanner teclado = new Scanner(System.in);
    private static int qtdCandidatos;
    private static String[] nomeCandidatos;
    private static int[] codigo;
    private static int[] votos;
    private static int nulo = 0,branco = 0;


    public void urna(){
            boolean run = true;
            while (run) {
                    menu();
                    System.out.print("Escolha uma opção:");
                    int opcao = teclado.nextInt();

                    switch (opcao) {
                        case 1:
                            inicializar();
                            break;
                        case 2:
                            votar();
                            break;
                        case 3:
                            resultado();
                            break;
                        case 4:
                            run = false;
                            break;
                    }
            }

            System.out.println("Fim do programa");
    }

    public void resultado(){
        String leftAlignFormat = "| %-15s | %-15s | %-15s |%n";

        System.out.format("+-----------------+-----------------+-----------------+%n");
        System.out.format("| Candidato       | Codigo          | Votos           |%n");
        System.out.format("+-----------------+-----------------+-----------------+%n");
        for(int i = 1; i <= qtdCandidatos-1; i++){
            System.out.format(leftAlignFormat,nomeCandidatos[i], codigo[i],votos[i]);
        }
        System.out.format("+-----------------+-----------------+-----------------+%n");



        String leftAlignFormat2 = "| %-15s | %-15s |%n";

        System.out.format("+-----------------+-----------------+%n");
        System.out.format("| Votos           | Quantidade      |%n");
        System.out.format("+-----------------+-----------------+%n");
        System.out.format(leftAlignFormat2,"Branco", branco);
        System.out.format(leftAlignFormat2,"Nulos", nulo);
        System.out.format("+-----------------+-----------------+%n");

        vencedor();
    }

    public void votar(){

        while(true) {
            System.out.print("Digite aqui seu titulo de eleito:");
            int titulo = teclado.nextInt();

            if(titulo < 0){
                break;
            }

            tableCandidato();

            System.out.print("Escolha um candidato:");
            int codigoCandidato = teclado.nextInt();
            for (int i = 1; i <= qtdCandidatos - 1; i++) {
                if (codigoCandidato == codigo[i]) {
                    votos[i] = (votos[i] + 1);
                    System.out.println("Voto confirmado");
                }else if(codigoCandidato == 4){
                    branco = (branco+1);
                }else if(codigoCandidato == 5){
                    nulo = (nulo+1);
                }
            }
        }
    }

    public void tableCandidato(){
        String leftAlignFormat = "| %-15s | %-15s |%n";

        System.out.format("+-----------------+-----------------+%n");
        System.out.format("| Candidato       | Codigo          |%n");
        System.out.format("+-----------------+-----------------+%n");
        System.out.format(leftAlignFormat,"Branco", "4");
        System.out.format(leftAlignFormat,"Nulo", "5");
        for(int i = 1; i <= qtdCandidatos-1; i++){
            System.out.format(leftAlignFormat,nomeCandidatos[i], codigo[i]);
        }
        System.out.format("+-----------------+-----------------+%n");
    }

    public void menu(){
        String leftAlignFormat = "| %-15s | %-15s |%n";

        System.out.format("+-----------------+-----------------+%n");
        System.out.format("| Opção           | Codigo          |%n");
        System.out.format("+-----------------+-----------------+%n");
        System.out.format(leftAlignFormat,"Nova Eleição", "1");
        System.out.format(leftAlignFormat,"Votar", "2");
        System.out.format(leftAlignFormat,"Resultado", "3");
        System.out.format(leftAlignFormat,"Sair", "4");
        System.out.format("+-----------------+-----------------+%n");
    }

    public void inicializar(){
        System.out.print("Numero de candidatos:");
        qtdCandidatos = (teclado.nextInt()+1);

        nomeCandidatos = new String[qtdCandidatos];
        codigo = new int[qtdCandidatos];
        votos = new int[qtdCandidatos];
        nulo = 0;branco = 0;
        for(int i = 1; i <= qtdCandidatos-1; i++){
            votos[i] = 0;
        }


        while(true) {
            for(int i = 1; i <= qtdCandidatos-1; i++){

                System.out.print("Escolha um nome para o "+i+"º candidato:");
                nomeCandidatos[i] = teclado.next();

                System.out.print("Escolha um codigo para o "+i+"º candidato:");
                codigo[i] = teclado.nextInt();
            }
            break;
        }
    }

    private void vencedor(){
        int vencedor = 0,index = 0;
        boolean impate = false;
        for(int i = 1; i <= qtdCandidatos-1; i++){
            if(i == 1) vencedor = votos[i];
            if(votos[i] > vencedor){
                vencedor = votos[i];
                index = i;
                impate = false;
            }else if(votos[i] == vencedor && i != 1){
                impate = true;
            }
        }
        if(!impate) {
            System.out.println("vencedor da eleição foi o " + nomeCandidatos[index] + " com " + votos[index] + " votos");
        }else{
            System.out.println("impate");
        }
    }


}
