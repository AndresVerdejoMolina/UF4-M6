package javaBean;

public class PruebasFinales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleado empleado = new Empleado("24545020H", "AndreVerdejo");
		PanelEmpleado panelEmpleado =new PanelEmpleado();
		panelEmpleado.setEmpleado(empleado);

		empleado.addPropertyChangeListener(panelEmpleado);

		empleado.setsueldo(300);

	}

}
