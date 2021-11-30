package regrasNegocio;

import javax.swing.*;
import java.text.DecimalFormat;

public class Classe {
    DecimalFormat formatador = new DecimalFormat("0.00");
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

    public void showMenu(){
        try {
            String leftAlignFormat = "| %-15s | %-15s |%n";

            System.out.format("+-----------------+-----------------+%n");
            System.out.format("| Opção           | Escolha         |%n");
            System.out.format("+-----------------+-----------------+%n");
            System.out.format(leftAlignFormat, "Novo Produto", "01");
            System.out.format(leftAlignFormat, "Adicionar Venda", "02");
            System.out.format(leftAlignFormat, "Numero Vendas", "03");
            System.out.format(leftAlignFormat, "Valor Vendas", "04");
            System.out.format(leftAlignFormat, "Media Anual", "05");
            System.out.format(leftAlignFormat, "Maior Venda", "06");
            System.out.format(leftAlignFormat, "Sair", "07");
            System.out.format("+-----------------+-----------------+%n");

            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma opção"));
            switch (opcao) {
                case 01:
                    String nome = JOptionPane.showInputDialog(null, "Nome Produto");
                    double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor Produto"));
                    setProduto(nome, valor);
                    showMenu();
                    break;
                case 02:
                    int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Mês"));
                    getAll();
                    int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Index do Produto"));
                    int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de vendas"));
                    setVendas((mes-1), index, qtd);
                    showMenu();
                    break;
                case 04:
                    getAllVendas();
                    showMenu();
                    break;
                case 03:
                    getAllValores();
                    showMenu();
                    break;
                case 05:
                    getPrecoMediaAnual();
                    showMenu();
                    break;
                case 07:

                    break;
            }
        }catch(Exception ex){
            System.out.println("Ocorreu um Erro");

        }
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
                        System.out.println("\nProduto Cadastrado com sucesso\n");
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
            System.out.println("\nVenda adicionada com sucesso\n");
            return true;
        }catch(Exception ex) {
            return false;
        }
    }


    /**
     *
     * @return
     */
    public void getAll(){
        String leftAlignFormat = "| %-15s | %-15s | %-15s |%n";
        String retorno[][] = new String[n][2];
        System.out.format("+-----------------+-----------------+-----------------+%n");
        System.out.format("| Index           | Produto         | Valor           |%n");
        System.out.format("+-----------------+-----------------+-----------------+%n");
        for(int i = 0;i < n;i++){
            if (produtos[i] != null) {
                System.out.format(leftAlignFormat, i,produtos[i], valores[i]);
                System.out.format("+-----------------+-----------------+-----------------+%n");
            }
        }
    }

    /**
     * Questão 02
     * @return
     */
    public void getAllVendas(){
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n";

        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("| Produtos        | Vendas          | Janeiro         | Fevereiro       | Março           | Abril           | Maio            | Junho           | Julho           | Agosto          | Setembro        | Outubro         | Novembro        | Dezembro        |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        for(int i = 0;i < n;i++){
            if (produtos[i] != null) {
                String[] r = getValorVendas(i);
                System.out.format(leftAlignFormat,produtos[i], valores[i],r[0],r[1],r[2],r[3],r[4],r[5],r[6],r[7],r[8],r[9],r[10],r[11]);
                System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
            }
        }
    }

    /**
     * Questão 03
     */
    public void getAllValores(){
        String retorno[] = new String[n];
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n";

        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("| Produtos        | Valor           | Janeiro         | Fevereiro       | Março           | Abril           | Maio            | Junho           | Julho           | Agosto          | Setembro        | Outubro         | Novembro        | Dezembro        |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        for(int i = 0;i < n;i++){
            if (produtos[i] != null) {
                String[] r = getVendas(i);
                System.out.format(leftAlignFormat,produtos[i], valores[i],r[0],r[1],r[2],r[3],r[4],r[5],r[6],r[7],r[8],r[9],r[10],r[11]);
                System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
            }
        }
    }

    /**
     * Questão 04 e 06
     */
    public void getPrecoMediaAnual(){
        String retorno[] = new String[n];
        String leftAlignFormat = "| %-15s | %-15s | %-15s |%n";

        System.out.format("+-----------------+-----------------+-----------------+%n");
        System.out.format("| Produtos        | Valor           | Media           |%n");
        System.out.format("+-----------------+-----------------+-----------------+%n");
        for(int i = 0;i < n;i++){
            if (produtos[i] != null) {
                double[] r = mediaAnual(getValorVendas(i));
                System.out.format(leftAlignFormat,produtos[i], valores[i],formatador.format((r[i]/12)));
                System.out.format("+-----------------+-----------------+-----------------+%n");
            }
        }
    }


    /**
     * Questãao 5
     */
    public void getMaiorVenda(){
//        double[] r = new double[n];
//        for(int i = 0;i < n;i++) {
//            r[i] = descobrirMaiorValor()
//        }
        //int i = descobrirMaiorIndex(mediaAnual(getValorVendas(1)));
        System.out.println("MaiorProduto:"+descobrirMaiorIndex(mediaAnual(getValorVendas(1))));
    }

    public int descobrirMaiorIndex(double[] array){
        // assign first element of array as maximum value
        double max = array[0];
        int index = -1;

        for (int i = 1; i < array.length; i++) {
            if(max > array[i]){
                index = i-1;
            }else if(max < array[i]){
                index = i;
            }

            max = Math.max(max, array[i]);

        }

        return index;
    }

    public double descobrirMaiorValor(double[] array){
        // assign first element of array as maximum value
        double max = array[0];


        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }

        return max;
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
