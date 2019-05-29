
import java.io.BufferedReader;
import java.util.ArrayList;

public class App {

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private static int count;
    private static int qtd_vizinhos = 0;
    private static int num_entradas = 0;
    private static ArrayList<Castelo> lista;

    public static void main(String[] args) {
        String[] data;
        int tam_castelo_principal = 0;
        int count = 0;
        

        lista = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader("./res/caso44.txt"));


            String line = reader.readLine();
            data = line.split(" ");

            tam_castelo_principal = Integer.parseInt(data[0]);
            qtd_vizinhos = Integer.parseInt(data[1]);
            num_entradas = Integer.parseInt(data[2]);

            qtd_vizinhos++;

            Castelo c2 = new Castelo(0, tam_castelo_principal);
            lista.add(c2);

            while (reader.ready()) {
                line = reader.readLine();
                data = line.split(" ");

                if (count < qtd_vizinhos - 1) {
                    Castelo c = new Castelo(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
                    lista.add(c);
                    count++;
                } else {
                    lista.get(Integer.parseInt(data[0])).addCastelo(lista.get(Integer.parseInt(data[1])));
                    lista.get(Integer.parseInt(data[1])).addCastelo(lista.get(Integer.parseInt(data[0])));
                }

            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


//		  for(Castelo c: lista) {
//			  System.out.println("Castelo: " + c.getNumero_castelo() + ", exercito: " + c.getTamanho_exercito());
//			System.out.print("Caminhos: ");
//			  for(Castelo caminho: c.getCastelosProximos()) {
//					System.out.print(caminho.getNumero_castelo() + " ");
//				}
//			  System.out.println("");
//		  }


        System.out.println("QUI Castelos conquistados: " + avancaExercito());

    }


    public static int avancaExercito() {
        boolean[] vetor_visitou = new boolean[qtd_vizinhos]; //um vetor de boolean para auxiliar as passadas entre os filhos dos castelos
        avancaExercito(vetor_visitou, 0, count); //passa-se o vetor com os passos, 0 por ser o castelo do siberio, count por ser a variavel onde ficara o resultado
        return count;
    }

    private static void avancaExercito(boolean[] vetor_visitou, int casteloAtual, int terrasInvadidas) {
        vetor_visitou[casteloAtual] = true; //todo castelo que entrar ja fica marcado como passado
        for (Castelo c : lista.get(casteloAtual).getCastelosProximos()) { //for each para todos os adjacentes do castelo atual
            int castleTarget = c.getNumero_castelo(); //pega identificador do castelo adjacentes de cada iteracao
            if (!vetor_visitou[castleTarget] && verificaCasteloDisponivel(lista.get(casteloAtual), c)) { //verifica se o castelo nao foi visitado e se tem exercito para conquistar
                avancaExercito(vetor_visitou, castleTarget, terrasInvadidas + 1); //caso tenha, executa o metodo recursivo novamente
            }
        }
        //sempre que sair da iteracao ele verifica se precisa atualizar o contador global
        if (terrasInvadidas > count) {
            count = terrasInvadidas;
        }

        vetor_visitou[casteloAtual] = false; //define falso o para o castelo que ja foi utilizado e nao vai mais ser neste laco
    }


    private static boolean verificaCasteloDisponivel(Castelo c1, Castelo c2) {

        int novoExercito = ((c1.getExercito_restante() - 50) - (c2.getTamanho_exercito() * 2));
        int proximoAtaque = novoExercito - 50;

        if (proximoAtaque > 0) {
            c2.setExercito_restante(novoExercito);
            return true;
        }
        return false;
    }


}

