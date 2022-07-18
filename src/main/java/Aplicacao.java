import dao.ClienteDao;
import domains.Bicicleta;
import domains.Carro;
import domains.Cliente;
import domains.Locacao;
import domains.Onibus;
import domains.Veiculo;
import validacoes.ValidaAnoVeiculo;
import validacoes.ValidaMarca;
import validacoes.ValidacaoVeiculo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class Aplicacao {

    public static void main(String[] args) {

        Veiculo fuscao = new Carro("Volks", "Fuscao", BigDecimal.valueOf(50), 1980);
        Veiculo lamborghini = new Carro("Lamborghini", "Aventator",  BigDecimal.valueOf(300), 2022);
        Veiculo onibus = new Onibus("Mercedes", "Busao", BigDecimal.valueOf(200), 2015);
        Veiculo tesla = new Carro("Tesla", "XYZ", BigDecimal.valueOf(200), 2022);
        Veiculo outroTesla = new Carro("Tesla", "ABC", BigDecimal.valueOf(200), 2022);
        Veiculo onibusVeio = new Onibus("Mercedes", "Véio", BigDecimal.valueOf(100), 1945);
        Veiculo bike = new Bicicleta("Caloi", "Ceci",BigDecimal.valueOf(15), 2022);

        final Comparator<Veiculo> veiculoComparator =
                Comparator.comparing(Veiculo::getMarca)
                        .thenComparing(Veiculo::getModelo)
                        .thenComparing(Veiculo::getPreco, Comparator.nullsLast(Comparator.naturalOrder()));

        Locacao locacao = new Locacao(veiculoComparator,
                new ValidacaoVeiculo(
                        Set.of(new ValidaAnoVeiculo(), new ValidaMarca())
                )
        );

        locacao.incluirVeiculo(bike);
        //locacao.incluirVeiculo(onibusVeio);
        locacao.incluirVeiculo(fuscao);
        locacao.incluirVeiculo(fuscao);
        locacao.incluirVeiculo(lamborghini);
        locacao.incluirVeiculo(lamborghini);
        locacao.incluirVeiculo(onibus);
        locacao.incluirVeiculo(tesla);

        lamborghini.adicionaSimilares(List.of(outroTesla, lamborghini, bike));

        final Collection<Veiculo> disponiveis = locacao.disponiveis();

        System.out.println("Veiculos ordenados pelo comparator" + disponiveis);

        System.out.println(lamborghini.getSimilares());

        final ClienteDao clienteDao = new ClienteDao();
        final Cliente joao = new Cliente("Joao", "joao@gmail.com");
        clienteDao.salvar(joao);

        clienteDao.print(List.of(joao));

        System.out.println("printer:");
        Printer.printLists(List.of(lamborghini));
        Printer.printLists(List.of(joao));
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