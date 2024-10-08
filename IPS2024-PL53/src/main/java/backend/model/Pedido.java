package backend.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.util.FileUtil;

public class Pedido {
	
	private List<Producto> orderList = null;
	private String code="";
	private Date fecha;
	
	public Pedido(){
		orderList = new ArrayList<Producto>();
		initialize();	
	}
	
	public void initialize(){
		orderList.clear();
		generateCode();
	}

	public void add(Producto item, int units){
		Producto itemInOrder = null;
	
		for (Producto a : orderList){
			if (a.getCode().equals(item.getCode()))
			{
				itemInOrder = a;
				itemInOrder.setUnits(itemInOrder.getUnits()+units);
				break;
			}
		}
		
		if (itemInOrder == null){
			Producto itemToOrder = new Producto(item);
			itemToOrder.setUnits(units);
			orderList.add(itemToOrder);
		}
	}
	
	public void remove(Producto item, int units){
		Producto itemInOrder = null;
		
		for (Producto a : orderList){
			if (a.getCode().equals(item.getCode()))
			{
				itemInOrder = a;
				itemInOrder.setUnits(itemInOrder.getUnits()-units);
				
				if (itemInOrder.getUnits() <= 0)
					orderList.remove(itemInOrder);
				break;
			}
		}
	}
	
	public String getCode() {
		return code;
	}

	public float getPrice(){
	    float total = 0.0f;
	    for (Producto a : orderList){
	        total += a.getPrice() * a.getUnits();
	    }
	    return Math.round(total * 100) / 100f;  // Redondear a 2 decimales
	}

	
	public void saveOrder(){
		FileUtil.saveToFile(code, orderList);
		LocalDate localDate = LocalDate.now();
        fecha =  Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	  }
	
	private void generateCode() {
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitudCodigo = 8;
		for(int i=0; i<longitudCodigo;i++){ 
			int numero = (int)(Math.random()*(base.length())); 
			code += base.charAt(numero);
		}
	}

	public List<Producto> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Producto> orderList) {
		this.orderList = orderList;
	}
	
	public int getUnits(Producto product) {
		for(Producto p: orderList)
			if(p.getCode().equals(product.getCode()))
				return p.getUnits();
		return 0;
			
	}
	
	@Override
	public String toString() {
		String lines = "";
		for(Producto p: orderList)
			lines+=p.getName() + " - " + p.getUnits() + "uds.\n";
		return lines;
	}

	public Date getFecha() {
		return fecha;
	}
}

