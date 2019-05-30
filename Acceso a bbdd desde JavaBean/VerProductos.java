package javaBean;

import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class VerProductos {
	static Producto productoEncontrado = new Producto();
	static Objects<Producto> objectsproducto = null;
	static Objects<Pedido> objectspedido= null;
	static BBDOOProducto bbddooproducto= null;
	static BBDDOOPedido bbddoopedido= null;
	static ODB odbproducto= null;
	static ODB odbpedido = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bbddooproducto = new BBDOOProducto();
		bbddoopedido = new BBDDOOPedido();
		
		odbproducto = bbddooproducto.obtenerBBDDOO();
		odbpedido = bbddoopedido.obtenerBBDDOO();
		
		Scanner leer;
		int accion;
		
		do {
			System.out.println("Que quieres hacer?");
			System.out.println("<0>Ver productos");
			System.out.println("<1>Ver Pedido");
			leer = new Scanner(System.in);
			accion = leer.nextInt();
			switch(accion) {
				case 0:
					System.out.println("Producto/s");
					objectsproducto = odbproducto.getObjects(Producto.class);
					for(Producto producto : objectsproducto) {
						System.out.println("Id del producto: " + producto.getIdproducto() + 
											", Descripcion: "+  producto.getDescripcion() + 
											", Stock actual: " + producto.getStockactual() + 
											", Stock minimo: " + producto.getStockminimo() + 
											", PVP: " + producto.getPvp());
					}
					bbddooproducto.cerrarBBDOO();
					break;
				
				case 1:
					System.out.println("Pedido/s");
					objectspedido = odbpedido.getObjects(Producto.class);
					for(Pedido pedido : objectspedido) {
						System.out.println("Numero de pedido: " + pedido.getNumeroPedido() + 
											", Producto: " + pedido.getProducto() + 
											", Fecha: " + pedido.getFecha() + 
											", Cantidad: " + pedido.getCantidad());
					}
					bbddoopedido.cerrarBBDOO();
					break;
					
			}
			System.out.println("Otra vez?");
			System.out.println("<0>No");
			System.out.println("<1>Si");
			accion = leer.nextInt();
			
		}while(accion==1);
		
		System.out.println("Para insertar un nuevo pedido, modifica el stock de un producto. Dame el id del producto que quieres modificar: ");
		int idproducto = leer.nextInt();
		
		objectsproducto = odbproducto.getObjects(Producto.class);
		
		for(Producto producto : objectsproducto) {
			if(idproducto == producto.getIdproducto()) {
				System.out.println("Se ha encontrado el producto: ");
				System.out.println("Id del producto: " + producto.getIdproducto() + 
						", Descripcion: "+  producto.getDescripcion() + 
						", Stock actual: " + producto.getStockactual() + 
						", Stock minimo: " + producto.getStockminimo() + 
						", PVP: " + producto.getPvp());
				productoEncontrado = producto;
				break;
			}			
		}
		
		modificarStock(odbproducto, odbpedido, leer);
		

	}

	private static void modificarStock(ODB odbproducto, ODB odbpedido, Scanner leer) {
		bbddooproducto = new BBDOOProducto();
		bbddoopedido = new BBDDOOPedido();
		
		int accion;
		System.out.println("Dime su nuevo stock:");
		int nuevoStock = leer.nextInt();
		
		productoEncontrado.setStockactual(nuevoStock);
		
		do {
			System.out.println("Que quieres hacer?");
			System.out.println("<0>Ver productos");
			System.out.println("<1>Ver Pedido");
			leer = new Scanner(System.in);
			accion = leer.nextInt();
			switch(accion) {
				case 0:
					System.out.println("Producto/s");
					objectsproducto = odbproducto.getObjects(Producto.class);
					for(Producto producto : objectsproducto) {
						System.out.println("Id del producto: " + producto.getIdproducto() + 
											", Descripcion: "+  producto.getDescripcion() + 
											", Stock actual: " + producto.getStockactual() + 
											", Stock minimo: " + producto.getStockminimo() + 
											", PVP: " + producto.getPvp());
					}
					bbddooproducto.cerrarBBDOO();
					break;
				
				case 1:
					System.out.println("Pedido/s");
					objectspedido = odbpedido.getObjects(Producto.class);
					for(Pedido pedido : objectspedido) {
						System.out.println("Numero de pedido: " + pedido.getNumeroPedido() + 
											", Producto: " + pedido.getProducto() + 
											", Fecha: " + pedido.getFecha() + 
											", Cantidad: " + pedido.getCantidad());
					}
					bbddoopedido.cerrarBBDOO();
					break;
					
			}
			System.out.println("Otra vez?");
			System.out.println("<0>No");
			System.out.println("<1>Si");
			accion = leer.nextInt();
			
		}while(accion==1);
	}

}
