package backend.data.ventas;

import java.util.Date;

public class VentaDto {

	public String idVenta;
	public String DNI;
	public Date fecha;
	public float coste;
	public String concepto;
	
	public VentaDto() {};
	
	public VentaDto(String id, String dni, Date fecha, float coste) {
		this.idVenta=id;
		this.DNI=dni;
		this.fecha=fecha;
		this.coste=coste;
	}
	
	public VentaDto(String id,Date fecha,float coste, String concepto) {
		this.idVenta=id;
		this.fecha=fecha;
		this.coste=coste;
		this.concepto=concepto;
	}

	public String getIdVenta() {return idVenta;}
	public void setIdVenta(String idVenta) {this.idVenta = idVenta;}
	
	public String getDNI() {return DNI;}
	public void setDNI(String dNI) {DNI = dNI;}
	
	public Date getFecha() {return fecha;}
	public void setFecha(Date fecha) {this.fecha = fecha;}

	public float getCoste() {return coste;}
	public void setCoste(float coste) {this.coste = coste;}
	
	public String getConcepto() {return concepto;}
	public void setConcepto(String concepto) {this.concepto = concepto;}
}

