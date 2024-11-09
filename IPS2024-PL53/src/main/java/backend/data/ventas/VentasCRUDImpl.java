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

public class VentasCRUDImpl implements VentasCRUDService {

	@Override
	public VentaDto findByCodVentas(String cod_ventas) {
		return new FindByCodVentas(cod_ventas).execute();
	}

	@Override
	public void addVentas(VentaDto venta) {
		new AddVentas(venta).execute();
	}
	
	@Override
	public void addReserva(ReservaDto dto) {
		new AddReserva(dto).execute();
	}

	@Override
	public List<ReservaDto> cargarReservas() {
		return new CargarReservas().execute();
	}

	@Override
	public List<VentaDto> findVentasFechas(Date inicio, Date fin) {
		List<VentaDto> res = new ArrayList<>();
		try {
			res =  new FindVentasFechas(inicio,fin).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return res;
	}
	
	@Override
	public void addEntrada(EntradaDTO dto) {
		new AddEntrada(dto).execute();
	}

}
