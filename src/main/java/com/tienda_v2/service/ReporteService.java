package com.tienda_v2.service;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface ReporteService {
    
    //Se define la firma del método que genera los reportes, con los siguientes parámetros
    //1. reprote: es el nombre del archivo de reportes (.jasper)
    //2. parametros: un Map que contiene los parámetros del reporte... si los ocupa
    //3. tipo: es el tipo de reporte: vPdf, Pdf, Xls, Csv
    
    public ResponseEntity<Resource> generaReporte (String reporte, Map<String, Object> parametros, String tipo) throws IOException;  
}
