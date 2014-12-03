import java.util.ArrayList;

public class MainAct7 {
	  public static void main(String[] args) {
		Act7 obj = new Act7();
		ArrayList listaRecogida=null;
		listaRecogida=obj.leerCSV();
		//String nombre="pruebaLibrosXML";
		String archivoCVS = "./resources/Librosl.csv";
		//Act7 prueba=new Act7();
		Libro l= (Libro) listaRecogida.get(0);
		try {
			obj.crearElementoXML(listaRecogida);
			  System.out.println("Hecho: archivo XML creado con exito");

		} catch (Exception e) {
			// TODO: handle exception
		}
	  }
}
