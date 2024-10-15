package backend.data.merchandising;

public class MerchandisingDTO {
    private String codigoCompra;

    // Constructor
    public MerchandisingDTO(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    // Getters y Setters
    public String getCodigoCompra() { return codigoCompra; }
    public void setCodigoCompra(String codigoCompra) { this.codigoCompra = codigoCompra; }
}

