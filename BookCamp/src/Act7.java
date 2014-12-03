
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
 
public class Act7 {
	
	
	// Insercion de los datos del disco
	static void CrearElemento(String datoEmple, String valor,Element raiz, Document document){
		Element elem = document.createElement(datoEmple); // creamos hijo
		Text text = document.createTextNode(valor); //damos valor
		raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
		elem.appendChild(text); // pegamos el valor
	}
 
  public ArrayList<Libro> leerCSV() {
 
	String archivoCVS = "./resources/Librosl.csv";
	BufferedReader br = null;
	String linea = "";
	String separacionCVS = ";";
     //String archivoXML = "pruebaxml";
    ArrayList<Libro> listaLibros = new ArrayList<Libro>();
    
	try {
 
		br = new BufferedReader(new FileReader(archivoCVS));
		while ((linea = br.readLine()) != null) {
		        // use comma as separator
			String[] libroAct = linea.split(separacionCVS);   
			
			Libro l= new Libro(libroAct[0], libroAct[1], libroAct[2], libroAct[3], libroAct[4], libroAct[5]);
			listaLibros.add(l);
		}
		//for(Libro b: listaLibros)
		//	System.out.println(b.toString());
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
 
	System.out.println("Hecho: archivo CSV leido con exito");
	return listaLibros;
  }
  
  public ArrayList<Libro> escribirCSV(ArrayList<Libro> libro) {
	  
		String archivoCVS = "./resources/Librosl.csv";
		BufferedWriter br = null;
		String linea = "";
		String separacionCVS = ";";
	    ArrayList<Libro> listaLibros = new ArrayList<Libro>();
	    
		try {
			br = new BufferedWriter(new FileWriter(archivoCVS));
			for (int i = 0; i < 6; i++) {
			        // use comma as separator
				Libro l= listaLibros.get(i);
				String[] libroWrite = {l.getTitulo(), l.getAutor(), l.getEditorial(), l.getAnio(), l.getStock(), l.getId()};   
				//br.write(libroWrite);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	 
		System.out.println("Hecho: archivo CSV leido con exito");
		return listaLibros;
	  }
  /**
   * crear una estructura xml completa y guardarla en un archivo .xml en la raíz del proyecto.
   * @param nombre
   * @param keyLista
   * @param valoresLista
   * @throws Exception
   */
  public void crearElementoXML(ArrayList<Libro> lista) throws Exception{
	  if(lista.isEmpty()){
		  System.out.println("error");
	  }
	  else{
		  String nombre="libros";
		  DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		  DocumentBuilder constructor=factory.newDocumentBuilder();
		  DOMImplementation implementacion= constructor.getDOMImplementation();
		  org.w3c.dom.Document documento= implementacion.createDocument(null, nombre, null);
		  documento.setXmlVersion("1.0");
	
		  boolean firstLine=true;
		  //para cada libro creamos un item que contendra el tipo de elemento y el valor del libro en la lista
		  for(Libro libro: lista){
			  //nodo item
			  if(!firstLine){
			  Element itemNode= documento.createElement("ITEM");
			  
			  Element raiz = documento.createElement("Libro"); // nodo empleado
				documento.getDocumentElement().appendChild(raiz); // lo pegamos a la raíz del documento
				
				CrearElemento("id",libro.getId(), raiz, documento);// Añadir ID
				CrearElemento("titulo",libro.getTitulo(), raiz, documento);// Añadir titulo
				CrearElemento("autor",libro.getAutor(), raiz, documento);// Añadir autor
				CrearElemento("editorial",libro.getEditorial(), raiz, documento);// Añadir editorial
				CrearElemento("anio",libro.getAnio(), raiz, documento);// Añadir anio
				CrearElemento("stock",libro.getStock(), raiz, documento);// Añadir stock
				
			  //node keyLista
			  /**Element keyNode= documento.createElement("KEY-LISTA");
			  org.w3c.dom.Text valorKeyNode=documento.createTextNode(keyLista.get(i));
			  keyNode.appendChild(valorKeyNode);
			  //node keyValor
			  Element valorNode=documento.createElement("VALOR-LISTA");
			  org.w3c.dom.Text valorValorNode= documento.createTextNode(valoresLista.get(i));
			  valorNode.appendChild(valorValorNode);
			  
			  //ahora vamos a anadir los nodos que se refieren a keyLista y valorLista
			  //al nodo item
			  itemNode.appendChild(keyNode);
			  itemNode.appendChild(valorNode);
			  */
			  //para generar el fichero XML
			  Source source= new DOMSource(documento);
			  Result resultado= new StreamResult(new File(nombre+".xml"));
			  Transformer transformador= TransformerFactory.newInstance().newTransformer();
			  
			  transformador.setOutputProperty(OutputKeys.INDENT, "yes");
			  transformador.setOutputProperty(OutputKeys.METHOD, "xml");
			  transformador.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");			  
			  transformador.transform(source, resultado);
//			  todas estas lineas nos sirven para que el formato del archivoXML creado sea el de un fichero xml normal
			 // System.out.println("Libro "+i+": copiado satisfactoriamente");
			  }
			  firstLine=false;
		  }  
	  }
  }
}