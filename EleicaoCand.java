import java.util.Scanner;

public class exe {

    public static void main(String[] args) {
// TODO code application logic here

        Scanner sc = new Scanner(System.in);
        //Declaração de variaveis
        int voto = 0;
        int cand1 = 0;
        int cand2 = 0;
        int cand3 = 0;
        int votob = 0;
        int voton = 0;
        
        //Entrada de dados
        while (voto >= 0) {
            System.out.println("Informe o código do candidato:"
                    + "\n" + "1- Candidato - A"
                    + "\n" + "2- Candidato - B"
                    + "\n" + "3- Candidato - C"
                    + "\n" + "4- Voto em branco"
                    + "\n" + "5- Voto nulo");
            voto = sc.nextInt();

            switch (voto) {
                case 1:
                    cand1++;
                    break;
                case 2:

                    cand2++;
                    break;
                case 3:
                    cand3++;
                    break;
                case 4:
                    votob++;
                    break;
                case 5:
                    voton++;
                    break;
                default:System.out.println("Opção invalida");
            }
        }

        System.out.println("Contagem dos votos");
        System.out.println("Candidato A " + cand1 + " Voto ");
        System.out.println("Candidato B " + cand2 + " Voto ");
        System.out.println("Candidato C " + cand3 + " Voto ");
        System.out.println("Voto em branco " + votob + " Voto ");
        System.out.println("Voto Nulo " + voton + " Voto ");
        System.out.println("CANDIDATO ELEITO");
        if ((cand1 > cand2) && (cand1 > cand3)) {
            System.out.println(" CANDIDATO A É O NOVO ELEITO");
        } else if ((cand2 > cand1) && (cand2 > cand3)) {
            System.out.println(" CANDIDATO B É O NOVO ELEITO");
        } else if ((cand3 > cand1) && (cand3 > cand2)) {
            System.out.println(" CANDIDATO C É O NOVO ELEITO");
        }
    }
}
