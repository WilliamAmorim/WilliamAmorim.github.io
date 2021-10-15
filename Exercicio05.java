public class Exercicio05 {
    
    ArrayList media = new ArrayList();

    public class Fila {
        String nome;
        String horarioInicio;          
        
        Fila prox;
    }

    Fila inicio = null;
    Fila fim = null;
    Fila aux;

    public void addPaciente(String nome, String horarioInicio) {
        Fila novo = new Fila();       
        novo.nome = nome;
        novo.horarioInicio = horarioInicio;
        
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

    public void chamar(String horarioSaida) {
        if (inicio != null) {
            System.out.println("Proximo:"+inicio.nome);
                              
            media.add(inicio.nome+" Horaio de inicio:"+inicio.horarioInicio+" Horario saida:"+horarioSaida);
            
            inicio = inicio.prox;
            
        }else{
            System.out.println("Lista vazia");
        }
    }
    
    public void mostrarMedia(){
        for(int i = 0;i < media.size();i++){
            System.out.println(media.get(i));
        }
    }

}
