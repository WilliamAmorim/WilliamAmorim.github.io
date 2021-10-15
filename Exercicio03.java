public class Exercicio03 {

    public class Pilha {
        int num;
        Pilha prox;
    }

    Pilha inicio;
    Pilha aux;

    public void empilhar(int n) {
        Pilha novo = new Pilha();
        novo.num = n;
        novo.prox = inicio;
        inicio = novo;
    }

    public void desempilhar() {
        inicio = inicio.prox;
    }
    
    public void getPilha(){
        aux = inicio;
        while (aux != null) {
            System.out.println(aux.num);
            aux = aux.prox;
        }
    }

}
