package gestorAplicacion.tienda;

public enum PrecioComponente {
	RAM_4GB(20000),  
	RAM_8GB(50000), 
	DISCO_DURO_HDD_512GB(100000), 
	DISCO_DURO_SSD_256GB(200000), 
	BATERIA_LAPTOP(150000), 
	BATERIA_CELULAR(120000), 
	PROCESADOR_INTEL(80000),
	PROCESADOR_QUALCOMM(70000),
	DISPLAY_LAPTOP(120000),
	DISPLAY_CELULAR(110000);
	
	double precio;
	private PrecioComponente(double p) {
		precio = p;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
