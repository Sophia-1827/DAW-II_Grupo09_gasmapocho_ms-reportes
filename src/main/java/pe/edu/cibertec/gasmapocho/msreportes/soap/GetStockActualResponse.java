package pe.edu.cibertec.gasmapocho.msreportes.soap;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

// Respuesta SOAP: un <item> por cada tipo de balon.
@XmlRootElement(name = "getStockActualResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class GetStockActualResponse {

    @XmlElement(name = "item")
    private List<StockItem> items = new ArrayList<>();

    public List<StockItem> getItems() {
        return items;
    }
}
