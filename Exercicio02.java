public class Exercicio02 {

    public class Pilha {

        String letra;
        Pilha prox;
    }

    Pilha inicio;
    Pilha aux;

    public void setPalavra(String palavra) {
        for (int i = 0; i < palavra.length(); i++) {
            Pilha novo = new Pilha();
            novo.letra = palavra.substring(i, i+1);
            novo.prox = inicio;
            inicio = novo;
        }
    }

    public void getLetras() {
        aux = inicio;
        while (aux != null) {
            System.out.println(aux.letra);
            aux = aux.prox;
        }
    }
}
