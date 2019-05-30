package dao_prueba;

import java.util.Scanner;

import data_access_object.Departamento;
import data_access_object.DepartamentoDAO;
import data_access_object.DepartamentoImpl;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		DepartamentoDAO depDAO =  new DepartamentoImpl();
		
		//Insertando un nuevo departamento
		if(depDAO.InsertarDep(new Departamento(1, "Bloque 1", "Barcelona")) == false) {
			System.out.println("Error al crear el nuevo departamento.");
		}
		
		//Consultando un departamento con su id
		Departamento departamento = depDAO.ConsultarDep(1);
		
		if(departamento != null) {
			System.out.println("id:" + departamento.getDeptno());
			System.out.println("nombre:" + departamento.getDnombre());
			System.out.println("loc:" + departamento.getLoc());
		}
		
		//Modificando un departamento
		System.out.println(depDAO.Modificar(1, new Departamento(1, "Bloque 2", "Valencia")));
		
		//Eliminando departamento
		depDAO.EliminarDep(1);
	}

}
