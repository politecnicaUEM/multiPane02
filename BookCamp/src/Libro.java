public class Libro {
	String id;
	String titulo;
	String autor;
	String editorial;
	String anio;
	String stock;
	
	public Libro(String id, String titulo, String autor, String editorial, String anio, String stock){
		this.id=id;
		this.titulo=titulo;
		this.autor= autor;
		this.editorial=editorial;
		this.anio=anio;
		this.stock=stock;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor
				+ ", editorial=" + editorial + ", anio=" + anio + ", stock="
				+ stock + "]";
	}
	
	
}
