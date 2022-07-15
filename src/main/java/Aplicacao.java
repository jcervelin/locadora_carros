import domains.Bicicleta;
import domains.Carro;
import domains.Locacao;
import domains.Onibus;
import domains.Veiculo;

import java.math.BigDecimal;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        Veiculo fuscao = new Carro("Volks","Fuscao");
        Veiculo lamborghini = new Carro("Lamborghini","Aventator");
        Veiculo onibus = new Onibus("Mercedes", "Busao");
        Veiculo tesla = new Carro("Tesla","XYZ");

        final Object novoFusca = fuscao.clone();

        System.out.println(" fusca normal: " + fuscao);
        System.out.println("Novo fusca: " + novoFusca);

        Locacao locacao = new Locacao(fuscao,
                lamborghini,onibus,tesla);

        final List<Veiculo> disponiveis = locacao.disponiveis();

        System.out.println(disponiveis);
        System.out.println(disponiveis.size());

        locacao.incluirVeiculo(new Bicicleta("Caloi", "Ceci"));
        locacao.incluirVeiculo(new Bicicleta("Caloi", "Ceci"));
        locacao.incluirVeiculo(new Onibus("Mercedes", "Véio", BigDecimal.valueOf(20_000),1945));
        locacao.incluirVeiculo(new Carro("Fiat", "147", BigDecimal.valueOf(10_000),1960));

        System.out.println(disponiveis);
        System.out.println(disponiveis.size());

        final List naoOrdenado = locacao.disponiveis();

        System.out.println("Nao Ordenada" + naoOrdenado);

        final List<Veiculo> ordenadoPorMarca = locacao.retornaOrdenadoMarca();
        System.out.println("Ordenado por Marca" + ordenadoPorMarca);

        final List<Veiculo> ordenadoPorModelo = locacao.retornaOrdenadoModelo();
        System.out.println("Ordenado por Modelo" + ordenadoPorModelo);

        final List<Veiculo> ordenadoPorPreco = locacao.retornaOrdenadoPreco();
        System.out.println("Ordenado por Preco" + ordenadoPorPreco);

        final List<Veiculo> ordenadoPorAno = locacao.retornaOrdenadoAno();
        System.out.println("Ordenado por Ano" + ordenadoPorAno);

    }


}

// quando se vai salvar um valor na tabela hash,
// o HashSet e o HashMap Java usam a seguinte formula

// (Capacidade do array interno - 1) & hascode

//15
//1111


// 0000
// 0001
// 0010
// 0011
// 0100
// 0101

//5

//1111
//0101
//0101