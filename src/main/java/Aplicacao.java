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

        final List disponiveis = locacao.disponiveis();

        System.out.println(disponiveis);
        System.out.println(disponiveis.size());

        locacao.incluirVeiculo(new Bicicleta("Caloi", "Ceci"));
        locacao.incluirVeiculo(new Bicicleta("Caloi", "Ceci"));

        System.out.println(disponiveis);
        System.out.println(disponiveis.size());

        final List naoOrdenado = locacao.disponiveis();

        System.out.println("Nao Ordenada" + naoOrdenado);

        final List<Veiculo> ordenadoPorMarca = locacao.retornaOrdenadoMarca();
        System.out.println("Ordenado por Marca" + ordenadoPorMarca);

        final List<Veiculo> ordenadoPorModelo = locacao.retornaOrdenadoModelo();
        System.out.println("Ordenado por Modelo" + ordenadoPorModelo);

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Digite a marca");
//        final String marca = scanner.nextLine();
//        List buscaPorMarca = null;
//        try {
//            buscaPorMarca = locacao.buscaPorMarca(marca);
//        } catch (ParametroNaoInformadoException ex) {
//            System.out.println("Parametro nao encontrado");
//        } finally {
//            scanner.close();
//        }

//        System.out.println(buscaPorMarca);
//
    }


}
