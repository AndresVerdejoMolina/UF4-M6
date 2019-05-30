package javaBean;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class LlenarProductos {
	static int accion_general_Int=0;

	public static void main(String[] args) {
		BBDOOProducto bbddoo = new BBDOOProducto();
		// TODO Auto-generated method stub
		Producto p1 = new Producto(1, "Duruss Cobalt", 10, 3, 220);
		p1.addPropertyChangeListener(new Pedido());
		Producto p2 = new Producto(2, "Varlion Avant Carbon", 5, 2, 176);
		Producto p3 = new Producto(3, "Star Vie Pyramid R50", 20, 5, 193);
		Producto p4 = new Producto(4, "Dunlop Titan", 8, 3, 85);
		Producto p5 = new Producto(5, "Vision King", 7, 1, 159);
		Producto p6 = new Producto(6, "Slazenger Reflex Pro", 5, 2, 80);
		
		p1.setStockactual(1);
		bbddoo.insertarProducto(p1);
		bbddoo.insertarProducto(p2);
		bbddoo.insertarProducto(p3);
		bbddoo.insertarProducto(p4);
		bbddoo.insertarProducto(p5);
		bbddoo.insertarProducto(p6);
		
		bbddoo.cerrarBBDOO();
	}

}
