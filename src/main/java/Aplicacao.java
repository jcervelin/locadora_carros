import domains.Bicicleta;
import domains.Carro;
import domains.Locacao;
import domains.Onibus;
import domains.Veiculo;
import validacoes.ValidaAnoVeiculo;
import validacoes.ValidaMarca;
import validacoes.ValidacaoVeiculo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;


public class Aplicacao {

    public static void main(String[] args) {

        Veiculo fuscao = new Carro("Volks", "Fuscao");
        Veiculo lamborghini = new Carro("Lamborghini", "Aventator");
        Veiculo onibus = new Onibus("Mercedes", "Busao");
        Veiculo tesla = new Carro("Tesla", "XYZ");
        Veiculo onibusVeio = new Onibus("Mercedes", "Véio", BigDecimal.valueOf(20_000), 1945);

        // Uso do clone
        final Object novoFusca = fuscao.clone();
        System.out.println("Novo fusca: " + novoFusca);
        System.out.println(" fusca normal: " + fuscao);

        final Comparator<Veiculo> veiculoComparator =
                Comparator.comparing(Veiculo::getMarca)
                        .thenComparing(Veiculo::getModelo)
                        .thenComparing(Veiculo::getPreco, Comparator.nullsLast(Comparator.naturalOrder()));

        Locacao locacao = new Locacao(veiculoComparator,
                new ValidacaoVeiculo(
                        Set.of(new ValidaAnoVeiculo(), new ValidaMarca())
                )
        );

        locacao.incluirVeiculo(new Bicicleta("", "Ceci"));
        locacao.incluirVeiculo(new Bicicleta("Caloi", "Ceci"));
        locacao.incluirVeiculo(onibusVeio);
        locacao.incluirVeiculo(new Carro("Fiat", "147", BigDecimal.valueOf(10_000), 1960));
        locacao.incluirVeiculo(fuscao);
        locacao.incluirVeiculo(fuscao);
        locacao.incluirVeiculo(lamborghini);
        locacao.incluirVeiculo(lamborghini);
        locacao.incluirVeiculo(onibus);
        locacao.incluirVeiculo(tesla);

        final Collection<Veiculo> disponiveis = locacao.disponiveis();

        System.out.println("Veiculos ordenados pelo comparator" + disponiveis);

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