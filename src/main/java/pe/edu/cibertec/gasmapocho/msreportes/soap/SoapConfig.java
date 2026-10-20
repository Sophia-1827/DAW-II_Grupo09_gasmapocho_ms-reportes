package pe.edu.cibertec.gasmapocho.msreportes.soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

// Spring Boot registra el MessageDispatcherServlet en /ws (spring.webservices.path).
// El nombre del bean "reportes" define la URL del WSDL: /ws/reportes.wsdl
@Configuration
public class SoapConfig {

    @Bean(name = "reportes")
    public DefaultWsdl11Definition reportesWsdl(XsdSchema reportesSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("ReportesPort");
        wsdl.setLocationUri("/ws/reportes");
        wsdl.setTargetNamespace(ReporteSoapEndpoint.NAMESPACE);
        wsdl.setSchema(reportesSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema reportesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/reportes.xsd"));
    }
}
