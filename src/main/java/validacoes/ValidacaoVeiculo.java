package validacoes;

import exceptions.ParametroNaoInformadoException;
import exceptions.VeiculoNaoEncontradoException;

import java.util.List;

import static java.lang.String.format;

public class ValidacaoVeiculo {

    public static final String MARCA_NAO_ENCONTRADA_MSG = "O domains.Veiculo da marca %s nao foi encontrado";
    private static final String MARCA_NAO_INFORMADA_MSG = "Marca nao informada";


    public static void validaMarca(String marca) throws ParametroNaoInformadoException {
        if (marca == null) {
            String msg = MARCA_NAO_INFORMADA_MSG;
            System.out.println(msg);
            throw new ParametroNaoInformadoException(msg);
        }
    }


    public static void validaListaVeiculos(List veiculosPorMarca, String marca) {
        if (veiculosPorMarca.isEmpty()) {
            String msg = format(MARCA_NAO_ENCONTRADA_MSG, marca);
            System.out.println(msg);
            throw new VeiculoNaoEncontradoException(msg);
        }
    }




}
