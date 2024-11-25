package backend.data.ventas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.data.entradas.EntradaDTO;
import backend.data.entradas.commands.AddEntrada;
import backend.data.ventas.commands.AddReserva;
import backend.data.ventas.commands.AddVentas;
import backend.data.ventas.commands.CargarReservas;
import backend.data.ventas.commands.FindByCodVentas;
import backend.data.ventas.commands.FindVentasFechas;
import backend.data.ventas.commands.FindVentasPeriocidadAnual;
import backend.data.ventas.commands.FindVentasPeriocidadMensual;
import backend.util.log.LogManager;

public class VentasCRUDImpl implements VentasCRUDService {

	@Override
	public VentaDto findByCodVentas(String cod_ventas) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: VENTAS");
		return new FindByCodVentas(cod_ventas).execute();
	}

	@Override
	public void addVentas(VentaDto venta) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: VENTAS");
		new AddVentas(venta).execute();
	}
	
	@Override
	public void addReserva(ReservaDto dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: RESERVA");
		new AddReserva(dto).execute();
	}

	@Override
	public List<ReservaDto> cargarReservas() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: RESERVA");
		return new CargarReservas().execute();
	}

	@Override
	public List<VentaDto> findVentasFechas(Date inicio, Date fin) {
		List<VentaDto> res = new ArrayList<>();
		try {
			LogManager.logAction("Acceso a Base de Datos. Tabla: VENTAS");
			res =  new FindVentasFechas(inicio,fin).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return res;
	}
	
	@Override
	public void addEntrada(EntradaDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: ENTRADA");
		new AddEntrada(dto).execute();
	}

	@Override
	public List<VentaDto> findVentasPeriocidadAnual(int year) {
		return new FindVentasPeriocidadAnual(year).execute();
	}

	@Override
	public List<VentaDto> findVentasPeriocidadMensual(int mes, int year) {
		return new FindVentasPeriocidadMensual(mes, year).execute();
	}

}
