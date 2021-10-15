

import exz01.PilhaNaoOrdenada;

/**
 *
 * @author labsi
 */
public class Exercicio01 {

    public class Pilha {

        int num;
        Pilha prox;
    }

    Pilha inicio;
    Pilha aux;

    public void exercicio(int[] numeros) {
        addItens(numeros);
        
        listarElementos();
    }

    private void addItens(int[] n) {
        for (int i = 0; i < n.length; i++) {            
                Pilha novo = new Pilha();
                novo.num = n[i];
                novo.prox = inicio;
                inicio = novo;            
        }
    }

    private void listarElementos() {
        aux = inicio;
        while (aux != null) {
            if ((aux.num % 2) == 0) {
                System.out.println(aux.num);
            }
            aux = aux.prox;
        }
    }

}
