import java.util.List;

public class Veiculo implements Cloneable {
    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    private String marca;
    private String modelo;

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
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
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
//    public int compareTo(Object o) {
//        Veiculo outro = (Veiculo) o;
//        return this.getMarca().compareTo(outro.getMarca());
//    }
}
