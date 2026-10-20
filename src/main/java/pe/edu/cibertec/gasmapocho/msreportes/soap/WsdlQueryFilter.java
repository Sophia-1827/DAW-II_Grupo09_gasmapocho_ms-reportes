package pe.edu.cibertec.gasmapocho.msreportes.soap;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Spring WS publica el WSDL como /ws/reportes.wsdl. Este filtro acepta tambien la forma clasica
// /ws/reportes?wsdl (la que muestra el frontend) y la redirige internamente al mismo WSDL.
@Component
public class WsdlQueryFilter extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !("GET".equals(request.getMethod())
                // se revisa como parametro (no el texto exacto) porque al pasar por el gateway "?wsdl" puede llegar como "?wsdl="
                && request.getParameterMap().keySet().stream().anyMatch("wsdl"::equalsIgnoreCase)
                && request.getRequestURI().endsWith("/ws/reportes"));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        request.getRequestDispatcher("/ws/reportes.wsdl").forward(request, response);
    }
}
