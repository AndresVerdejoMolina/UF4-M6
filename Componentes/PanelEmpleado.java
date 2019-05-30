package javaBean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.HashMap;

public class PanelEmpleado implements Serializable, PropertyChangeListener {
	private double limiteVariacionSueldo;
	private PropertyChangeSupport propertySupport;
	public Empleado empleado;
	
	HashMap<String, String> listaDeCargos = new HashMap<String, String>();	
	
	public PanelEmpleado(int valor) {
		this.limiteVariacionSueldo = valor;
	}
	public PanelEmpleado() {
		this.limiteVariacionSueldo = 10;
	}
	
	public void propertyChange (PropertyChangeEvent evt) {
		listaDeCargos.put("Junior", "Junior");
		listaDeCargos.put("SemiSenior", "SemiSenior");
		listaDeCargos.put("Analista", "Analista");
		listaDeCargos.put("CEO", "CEO");
		
		if(evt.getPropertyName().equals("sueldo")){
			float oldValue = (float) evt.getOldValue();
			float newValue = (float) evt.getNewValue();
			float porcentage =  (float) 100f - (((newValue * 100f)/oldValue));
			System.out.printf("el porcentaje entre tu sueldo antiguo: %d%n%s%n%s%n", oldValue, " y el nuevo ", newValue, " es ", porcentage);
			
			if(porcentage > limiteVariacionSueldo) {

					throw new NullPointerException(); 

			}
	    	
		}else if(evt.getPropertyName().equals("cargo")) {			
			System.out.printf("cargo anterior: %d%n",evt.getOldValue());
	    	System.out.printf("cargo actual: %d%n",evt.getNewValue());
	    	
	    	String cargoEncontrado = listaDeCargos.get(evt.getNewValue());
	    	
	    	if(cargoEncontrado.isEmpty()) {
	    		System.out.println("El cargo " + evt.getNewValue() + " esta disponible.");
	    	}else {
	    		System.out.println("El cargo " + evt.getNewValue() + " no esta disponible.");
	    	}
	    	
		}
	}
	public void setLimiteVariacionSueldo(int limiteVariacionSueldo) {
		if(limiteVariacionSueldo >= 10 && limiteVariacionSueldo <= 50) {
			this.limiteVariacionSueldo = limiteVariacionSueldo;
		}
	}	
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
}
