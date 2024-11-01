package backend.service.ventas.merchandising;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.service.ventas.VentaBase;

public class VentaMerchandising extends VentaBase {
    
    private List<Producto> orderList;
    private String codCompra;
    private Date fechaCompra;
    private float precioTotal;
    
    public VentaMerchandising(){
        orderList = new ArrayList<Producto>();
        initialize();    
    }
    
    public void initialize(){
        orderList.clear();
        fechaCompra = new Date();
        precioTotal = 0;
        codCompra="";
        generateCode();
    }
    
    // Getters y setters
    public String getCodCompra() { return codCompra; }
    public void setCodCompra(String codCompra) { this.codCompra = codCompra; }

    public List<Producto> getProductos() { return orderList; }
    public void setProductos(List<Producto> productos) { this.orderList = productos; }

    public float getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(float precioTotal) { 
        this.precioTotal = roundToTwoDecimals(precioTotal); 
    }

    public Date getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(Date fechaCompra) { this.fechaCompra = fechaCompra; }
    
    // Métodos de la lógica del programa 
    public void add(Producto item){
        Producto itemInOrder = null;
    
        for (Producto a : orderList){
            if (a.getCode().equals(item.getCode()))
            {
                itemInOrder = a;
                itemInOrder.setUnits(itemInOrder.getUnits()+1);
                break;
            }
        }
        
        if (itemInOrder == null){
            Producto itemToOrder = new Producto(item);
            itemToOrder.setUnits(1);
            orderList.add(itemToOrder);
        }
        
        calcularPrecioTotal();
    }
    
    public void remove(Producto item){
        Producto itemInOrder = null;
        
        for (Producto a : orderList){
            if (a.getCode().equals(item.getCode()))
            {
                itemInOrder = a;
                itemInOrder.setUnits(itemInOrder.getUnits()-1);
                
                if (itemInOrder.getUnits() == 0)
                    orderList.remove(itemInOrder);
                break;
            }
        }
        
        calcularPrecioTotal();
    }
    
    public void calcularPrecioTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Producto producto : orderList) {
            BigDecimal precioProducto = BigDecimal.valueOf(producto.getPrice());
            BigDecimal cantidad = BigDecimal.valueOf(producto.getUnits());
            total = total.add(precioProducto.multiply(cantidad));
        }
        precioTotal = roundToTwoDecimals(total.floatValue());
    }
    
    // Método para redondear a dos decimales
    private float roundToTwoDecimals(float value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.floatValue();
    }
    
    public int contarUnidades(Producto producto) {
        for(Producto p : orderList) {
            if(p.getCode().equals(producto.getCode())) {
                return p.getUnits();
            }
        }
        return 0;
    }
    
    @Override
    public String toString() {
        String lines = "";
        for(Producto p: orderList)
            lines += p.getName() + " - " + p.getUnits() + " uds.\n";
        return lines;
    }
    
    private void generateCode() {
        String base = "0123456789abcdefghijklmnopqrstuvwxyz";
        int longitudCodigo = 8;
        for(int i = 0; i < longitudCodigo; i++){ 
            int numero = (int)(Math.random() * (base.length())); 
            codCompra += base.charAt(numero);
        }
    }
}
