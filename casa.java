   //launch(args);
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
//Declaração de variaveis
        int numdocanal = 1;
        int np = 0;
        int canal3 = 0;
        int canal5 = 0;
        int canal8 = 0;
        int canal11 = 0;
        int canal13 = 0;
        int casas = 0;
        int totalpessoas = 0;
        double porcentagem = 0;
        DecimalFormat DecimalFormat = new DecimalFormat("#,##0.00%");
        System.out.println("Informe a quantidade de casas que participaram da pesquisa");
        casas = sc.nextInt();
        System.out.println("Total de casas participando da pesquisa " + casas);
        System.out.println("Informe quantas pessoas estão assistindo o canal ");
        np = sc.nextInt();

        while (np > 0 && numdocanal>0) {

            System.out.println("Informe qual canal você está assistindo:"
                    + "\n" + "1- Canal 3"
                    + "\n" + "2- Canal 5"
                    + "\n" + "3- Canal 8"
                    + "\n" + "4- Canal 11"
                    + "\n" + "5- Canal 13");
            numdocanal = sc.nextInt();
            switch (numdocanal) {
                case 1:
                    canal3 = canal3 + 1;
                    break;
                case 2:
                    canal5 = canal5 + 1;
                    break;
                case 3:
                    canal8 = canal8 + 1;
                    break;
                case 4:
                    canal11 = canal11 + 1;
                    break;
                case 5:
                    canal13 = canal13 + 1;
                    break;
                default:
                    System.out.println("Opção invalida");

            }
        }
        totalpessoas = canal3 + canal5 + canal8 + canal11 + canal13;

        if(totalpessoas > 0) {
            porcentagem = 100 / totalpessoas;

 porcentagem = 100 / totalpessoas;
            double n =  porcentagem * canal3;
            System.out.println("PORCENTAGEM DE AUDIÊNCIA");
            System.out.println("Audiencia do Canal 3 : " + n+"%");
            System.out.println("Audiencia do Canal 5 : " + porcentagem * canal5+"%");
            System.out.println("Audiencia do Canal 8 : " + porcentagem * canal8+"%");
            System.out.println("Audiencia do Canal 11 : " + porcentagem * canal11+"%");
            System.out.println("Audiencia do Canal 13 : " + porcentagem * canal13+"%");
            System.out.println(" Total de pessoas "+totalpessoas);

        }


    }
