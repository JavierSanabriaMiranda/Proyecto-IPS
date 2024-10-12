package backend.service.ventas.merchandising;

import java.util.Date;
import java.util.List;

import backend.model.Catalogo;
import backend.model.Pedido;
import backend.model.Producto;
import backend.service.ventas.VentaBase;

public class VentaMerchandising extends VentaBase{
	
	Catalogo catalogo = new Catalogo();
	Pedido pedido = new Pedido();
	
	public VentaMerchandising() {
		super();
		iniciar();
	}

	public Producto[] getMenuProducts() {
		return catalogo.getProducts();
	}
	
	public void iniciar() {
		pedido.initialize();
	}

	public void addProduct(Producto p, int unidades) {
		pedido.add(p, unidades);
	}

	public void removeProduct(Producto p, int unidades) {
		pedido.remove(p, unidades);
	}
	
	@Override
	public float getPrecio() {
		return pedido.getPrice();
	}
	
	public void saveOrder() {
		pedido.saveOrder();
	}
	
	public int getUnits(Producto p) {
		return pedido.getUnits(p);
	}
	
	public Producto[] filter(String tipo) {
		if(tipo.equals(""))
			return catalogo.getProducts();
		else
			return catalogo.filterByType(tipo);
	}
	
	public List<Producto> getOrder(){
		return pedido.getOrderList();
	}
	
	public String orderToString() {
		return pedido.toString();
	}

	@Override
	public Date getFecha() {
		return pedido.getFecha();
	}

}
