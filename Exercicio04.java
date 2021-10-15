public class Exercicio04 {

    static int i = 1;

    public class Fila {

        String nome;
        String senha;
        int index;
        Fila prox;
    }

    Fila inicio = null;
    Fila fim = null;
    Fila aux;

    public void addPaciente(String nome, String senha) {
        Fila novo = new Fila();
        novo.index = i++;
        novo.nome = nome;
        novo.senha = senha;

        if (fim == null) {
            inicio = novo;
            fim = novo;
            fim.prox = null;
        } else {
            fim.prox = novo;
            fim = novo;
            fim.prox = null;
        }
    }

    public void chamarPaciente() {
        if (inicio != null) {
            System.out.println(inicio.index + " ==> " + inicio.nome + " - " + inicio.senha);
            if (i > 1) {
                inicio = inicio.prox;
            } else {
                inicio = null;
                fim = null;                
            }
        }else{
            System.out.println("Lista vazia");
        }
    }

}
