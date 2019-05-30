package javaBean;

import java.math.BigDecimal;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;
public class BBDDOOPedido {
	static ODB odb=null;
	static String nombreBBDDOO="Pedido_Ped.BD";
	
	public void abrirBBDOO() {
		this.odb = ODBFactory.open(nombreBBDDOO);
	}
	
	public void cerrarBBDOO() {
		this.odb.close();
		
	}
	public ODB obtenerBBDDOO() {
		return odb;
	}
	
	public int pedidoMaximo() {
		Values query = odb.getValues(new ValuesCriteriaQuery(Pedido.class).max("numPedido", "ped_max"));
		ObjectValues objVal = query.nextValues();
		BigDecimal maxima= (BigDecimal) objVal.getByAlias("ped_max");
		
		return maxima.intValue();
	}
	
	public void insertarPedido(Pedido pedidoInsert) {
		this.odb.store(pedidoInsert);
		
	}

}
