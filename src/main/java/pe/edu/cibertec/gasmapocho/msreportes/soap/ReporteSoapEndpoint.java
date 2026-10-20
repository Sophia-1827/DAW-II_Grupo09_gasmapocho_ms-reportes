package pe.edu.cibertec.gasmapocho.msreportes.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pe.edu.cibertec.gasmapocho.msreportes.service.ReporteService;

// Endpoint SOAP del reporte de stock actual. Reutiliza el mismo ReporteService que el REST /api/reportes/stock-actual.
// Para consultar ms-balones se reenvia el header Authorization del request SOAP (ver FeignAuthConfig),
// asi que hay que llamarlo con "Authorization: Bearer <token>" igual que a los reportes REST.
@Endpoint
public class ReporteSoapEndpoint {

    public static final String NAMESPACE = "http://gasmapocho.cibertec.edu.pe/reportes";

    private final ReporteService reporteService;

    public ReporteSoapEndpoint(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getStockActualRequest")
    @ResponsePayload
    public GetStockActualResponse getStockActual(@RequestPayload GetStockActualRequest request) {
        GetStockActualResponse response = new GetStockActualResponse();
        reporteService.stockActual().forEach(s -> response.getItems().add(
                new StockItem(s.codigo(), s.nombre(), s.stock(), s.stockMinimo(), s.bajoMinimo())));
        return response;
    }
}
