import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static int count;
    private static int qtd_vizinhos = 0;
    private static int num_entradas = 0;
    private static ArrayList<Castelo> lista;

    public static void main(String[] args) {
        String[] data;
        int tam_castelo_principal = 0;
        int count = 0;
        int num_arquivo = 0;
        Scanner in = new Scanner(System.in);

        String[] files = new String[]{"caso30.txt", "caso32.txt", "caso34.txt", "caso36.txt", "caso38.txt",
                "caso40.txt", "caso42.txt", "caso44.txt", "caso46.txt", "caso48.txt", "caso50.txt", "caso60.txt"};

        System.out.println("Escolha qual caso de teste executar: ");
        for (int i = 0; i < files.length; i++) {
            System.out.println(i + " - " + files[i]);
        }
        int escolha = in.nextInt();
        if (escolha >= 0 && escolha <= 11) {
            num_arquivo = escolha;
        }else{
            System.out.println("Arquivo escolhido inexistente, por favor tente novamente");
            return ;
        }
        long startTime = System.currentTimeMillis();
        lista = new ArrayList<>();
        // Leitura e inicialização dos castelos
        try {
            Path path1 = Paths.get("res/" + files[num_arquivo]);
            BufferedReader reader = new BufferedReader(Files.newBufferedReader(path1, Charset.forName("utf8")));
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
        System.out.println("Castelos conquistados: " + avancaExercito());
        long endTime = System.currentTimeMillis();
        long end = endTime - startTime;
        System.out.println("Tempo de execução da aplicação em milissegundos: " + end);
    }

    public static int avancaExercito() {
        boolean[] vetor_visitou = new boolean[qtd_vizinhos];
        avancaExercito(vetor_visitou, 0, count);
        return count;
    }

    private static void avancaExercito(boolean[] vetor_visitou, int casteloAtual, int terrasInvadidas) {
        vetor_visitou[casteloAtual] = true;
        for (Castelo c : lista.get(casteloAtual).getCastelosProximos()) {
            int castleTarget = c.getNumero_castelo();
            if (!vetor_visitou[castleTarget] && verificaCasteloDisponivel(lista.get(casteloAtual), c)) {
                avancaExercito(vetor_visitou, castleTarget, terrasInvadidas + 1);
            }
        }
        if (terrasInvadidas > count) {
            count = terrasInvadidas;
        }
        vetor_visitou[casteloAtual] = false;
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

