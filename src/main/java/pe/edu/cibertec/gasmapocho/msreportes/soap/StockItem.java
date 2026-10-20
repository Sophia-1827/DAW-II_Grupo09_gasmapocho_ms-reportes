package pe.edu.cibertec.gasmapocho.msreportes.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

// Una fila del reporte de stock (tipo "stockItem" del XSD).
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stockItem", propOrder = {"codigo", "nombre", "stock", "stockMinimo", "bajoMinimo"})
public class StockItem {

    private String codigo;
    private String nombre;
    private Integer stock;
    private Integer stockMinimo;
    private Boolean bajoMinimo;

    public StockItem() {
        // requerido por JAXB
    }

    public StockItem(String codigo, String nombre, Integer stock, Integer stockMinimo, Boolean bajoMinimo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.bajoMinimo = bajoMinimo;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Integer getStock() { return stock; }
    public Integer getStockMinimo() { return stockMinimo; }
    public Boolean getBajoMinimo() { return bajoMinimo; }
}
