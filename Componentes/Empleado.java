package javaBean;

import java.beans.ExceptionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;

public class Empleado implements Serializable  {
    private String nif;
    private String nombre;
    private String cargo;
    private int sueldo;
    private PropertyChangeSupport propertySupport;
    
    
    public Empleado () {
		propertySupport = new PropertyChangeSupport (this);
    }
    
    public void addPropertyChangeListener (PropertyChangeListener listener) {
		propertySupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener (PropertyChangeListener listener) {
		propertySupport.removePropertyChangeListener(listener);
	}
    
    public Empleado(String cargo, int sueldo) {    	
    	propertySupport = new PropertyChangeSupport(this);
    	this.cargo="Junior";
    	this.sueldo=1000;
    }
    public Empleado(String nif, String nombre) {
    	this();
    	this.nif=nif;
    	this.nombre=nombre;
    }

	public String getnif() {
		return nif;
	}

	public void setnif(String nif) {
		this.nif = nif;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public String getcargo() {
		return cargo;
	}

	public void setcargo(String cargo) {
		if(cargo.trim().isEmpty()) {
			try {
				propertySupport.firePropertyChange("se ha cambiado el cargo", this.cargo, cargo);
				this.cargo = cargo;
			}catch(Exception e) {
				System.out.println("Error en el porcentaje.");
			}
		}
	}

	public double getsueldo() {
		return sueldo;
	}

	public void setsueldo(int sueldo) {
		if(sueldo > 0) {
			try {
				propertySupport.firePropertyChange("se ha cambiado el sueldo", this.sueldo, sueldo);
				this.sueldo = sueldo;
			}catch(Exception e) {
				System.out.println("Error en el sueldo.");
			}
		}
	}

}
