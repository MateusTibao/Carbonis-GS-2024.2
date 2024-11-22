package serviços;

import modelos.Pontuacao;
import modelos.Usuario;

import java.util.ArrayList;

public class Ranking {
    private ArrayList<Pontuacao> pontuacoes;

    public Ranking() {
        this.pontuacoes = new ArrayList<>();
    }

    public void atualizarPontuacao(Pontuacao novaPontuacao) {
        for (int i = 0; i < pontuacoes.size(); i++) {
            if (pontuacoes.get(i).getUsuario().equals(novaPontuacao.getUsuario())) {
                pontuacoes.set(i, novaPontuacao);
                return;
            }
        }
        pontuacoes.add(novaPontuacao);
    }

    public void exibirRanking() {
        ArrayList<Pontuacao> listaOrdenada = quicksort(new ArrayList<>(pontuacoes));
        System.out.println("=== Ranking de Pontuações ===");
        for (int i = 0; i < listaOrdenada.size(); i++) {
            Pontuacao p = listaOrdenada.get(i);
            System.out.printf("%d. %s - Pontos: %.2f%n", i + 1, p.getUsuario().getLogin(), p.getPontos());
        }
    }

    private ArrayList<Pontuacao> quicksort(ArrayList<Pontuacao> array) {
        if (array.size() < 2) {
            return array;
        } else {
            Pontuacao pivo = array.get(0);
            ArrayList<Pontuacao> menores = new ArrayList<>();
            ArrayList<Pontuacao> maiores = new ArrayList<>();

            for (int i = 1; i < array.size(); i++) {
                if (array.get(i).getPontos() >= pivo.getPontos()) {
                    maiores.add(array.get(i));
                } else {
                    menores.add(array.get(i));
                }
            }

            ArrayList<Pontuacao> sortedList = new ArrayList<>();
            sortedList.addAll(quicksort(maiores));
            sortedList.add(pivo);
            sortedList.addAll(quicksort(menores));

            return sortedList;
        }
    }

    public Pontuacao consultarPontuacao(Usuario usuario) {
        for (Pontuacao p : pontuacoes) {
            if (p.getUsuario().equals(usuario)) {
                return p;
            }
        }
        return null;
    }
}
