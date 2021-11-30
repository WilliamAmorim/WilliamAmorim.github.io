public class Classe {
    int n;
    String[] produtos;
    double[] valores;
    int[][] vendas;

    public Classe(int n){
        this.n = n;
        this.produtos = new String[n];
        this.valores = new double[n];
        this.vendas = new int[12][n];
    }


    /**
     * Cadastro de produtos
     * @param nome nome do produto
     * @param valor preço do produto
     * @return
     */
    public boolean setProduto(String nome,double valor){
        try {
            if(!nome.isEmpty()) {
                for (int i = 0; i < n; i++) {
                    if (produtos[i] == null) {
                        produtos[i] = nome;
                        valores[i] = valor;
                        return true;
                    }
                }
            }
            return false;
        }catch(Exception ex){
            System.out.println(ex);
            return false;
        }
    }

    /**
     *
     * @param mes
     * @param indexProduto
     * @param qtdVendas
     * @return
     */
    public boolean setVendas(int mes,int indexProduto,int qtdVendas){
        try{
            vendas[mes][indexProduto] = qtdVendas;
            return true;
        }catch(Exception ex) {
            return false;
        }
    }


    /**
     *
     * @return
     */
    public String[][] getAll(){
        String retorno[][] = new String[n][2];
        for(int i = 0;i < n;i++){
            if (produtos[i] != null) {
                System.out.println("[" + produtos[i] + "][" + valores[i] + "]"+getVendas(i));
                retorno[i][0] = produtos[i];
                retorno[i][1] = valores[i]+"";
            }
        }
        return retorno;
    }

    /**
     * Questão 02
     * @return
     */
    public void getAllVendas(){
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n";

        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("| Produtos        | Valor           | Vendas          | Janeiro         | Fevereiro       | Março           | Abril           | Maio            | Junho           | Julho           | Agosto          | Setembro        | Outubro         | Novembro        | Dezembro        |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        for(int i = 0;i < n;i++){
            if (produtos[i] != null) {
                String[] r = getValorVendas(i);
                System.out.format(leftAlignFormat,produtos[i], valores[i],r[0],r[1],r[2],r[3],r[4],r[5],r[6],r[7],r[8],r[9],r[10],r[11]);
                System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
            }
        }
    }

    /**
     * Questão 03
     */
    public void getAllValores(){
        String retorno[] = new String[n];
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n";

        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("| Produtos        | Valor           | Vendas          | Janeiro         | Fevereiro       | Março           | Abril           | Maio            | Junho           | Julho           | Agosto          | Setembro        | Outubro         | Novembro        | Dezembro        |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        for(int i = 0;i < n;i++){
            if (produtos[i] != null) {
                String[] r = getVendas(i);
                System.out.format(leftAlignFormat,produtos[i], valores[i],r[0],r[1],r[2],r[3],r[4],r[5],r[6],r[7],r[8],r[9],r[10],r[11]);
                System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
            }
        }
    }

    /**
     * Questão 04 e 06
     */
    public void getPrecoMedioAnual(){
        String retorno[] = new String[n];
        String leftAlignFormat = "| %-15s | %-15s | %-15s |%n";

        System.out.format("+-----------------+-----------------+-----------------+%n");
        System.out.format("| Produtos        | Valor           | Media           |%n");
        System.out.format("+-----------------+-----------------+-----------------+%n");
        for(int i = 0;i < n;i++){
            if (produtos[i] != null) {
                double[] r = mediaAnual(getValorVendas(i));

                System.out.format(leftAlignFormat,produtos[i], valores[i],(r[i]/12));
                System.out.format("+-----------------+-----------------+-----------------+%n");
            }
        }
    }

    public void getMaiorVenda(){


    }


    public String[] getVendas(int index) {
        String[] r = new String[12];
        for(int i = 0;i < 12;i++){
            r[i] = vendas[i][index]+"";
        }
        return r;
    }

    /**
     *
     * @param index
     * @return
     */
    public String[] getValorVendas(int index) {
        String[] r = new String[12];
        for(int i = 0;i < 12;i++){
            r[i]= (vendas[i][index]*valores[index])+"";
        }
        return r;
    }

    public double[] mediaAnual(String[] vendas){
        double[] r = new double[n];
        for(int i = 0;i < n;i++){
            r[i] = 0;
        }
        for(int i = 0;i < n;i++) {
            for (int i2 = 0; i2 < 12; i2++) {
                r[i] += Double.parseDouble(vendas[i2]);
            }
        }

        return r;
    }
}
