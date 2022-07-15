package domains;

import java.math.BigDecimal;

public class Veiculo implements Cloneable {
    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Veiculo(String marca, String modelo, BigDecimal preco, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.ano = ano;
    }

    private String marca;
    private String modelo;

    private BigDecimal preco;

    private int ano;

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "domains.Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", preco=" + preco +
                ", ano=" + ano +
                '}';
    }

    public Veiculo clone() {
        try {
            Veiculo clone = (Veiculo) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

//    @Override
//    public int compareTo(Veiculo outro) {
//        return this.getMarca().compareTo(outro.getMarca());
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Veiculo)) return false;

        Veiculo veiculo = (Veiculo) o;

        if (ano != veiculo.ano) return false;
        if (marca != null ? !marca.equals(veiculo.marca) : veiculo.marca != null) return false;
        if (modelo != null ? !modelo.equals(veiculo.modelo) : veiculo.modelo != null) return false;
        return preco != null ? preco.equals(veiculo.preco) : veiculo.preco == null;
    }

    @Override
    public int hashCode() {
        int result = marca != null ? marca.hashCode() : 0;
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        result = 31 * result + ano;
        return result;
    }
}
