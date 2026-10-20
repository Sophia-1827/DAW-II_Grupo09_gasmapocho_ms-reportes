package pe.edu.cibertec.gasmapocho.msreportes.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

// Peticion SOAP del reporte de stock actual (no lleva parametros).
@XmlRootElement(name = "getStockActualRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class GetStockActualRequest {
}
