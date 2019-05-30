package javaBean;

import org.neodatis.odb.ODB;


import org.neodatis.odb.ODBFactory;

public class BBDOOProducto {
	static ODB odb=null;
	static String nombreBBDDOO="Producto_Ped.BD";
	
	public BBDOOProducto() {
		this.odb = ODBFactory.open(nombreBBDDOO);
	}
	
	public void cerrarBBDOO() {
		this.odb.close();
		
	}
	
	public ODB obtenerBBDDOO() {
		return odb;
	}
	
	public void insertarProducto(Producto productoInsert) {
		this.odb.store(productoInsert);
		
	}

}
