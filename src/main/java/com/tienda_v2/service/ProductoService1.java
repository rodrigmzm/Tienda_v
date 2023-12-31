package com.tienda_v2.service;

import com.tienda_v2.domain.Producto;
import java.util.List;

public interface ProductoService1 {
    
    //Se obtiene un array List con todas las productos de la tabla
    public List<Producto> getProductos(boolean avtivo);   
    
    //Se obtiene una Producto segun el Id pasado por parametro
    public Producto getProducto(Producto producto);
    
    //Se actualiza una producto o se inserta una nueva... (Si no hay id es un insert)
    public void save(Producto producto);
    
    //Se elimina una cateogoria segun el Id pasado
    
    public void delete(Producto producto);
    
    // Metodo Query para obtener un listado de productos filtrado por precio, ordenado por descripcion
    public List<Producto> consultaQuery(double precioInf, double precioSup);
    
    // Metodo JPQL para obtener un listado de productos filtrado por precio, ordenado por descripcion
    public List<Producto> consultaJPQL(double precioInf, double precioSup);
    
    // Metodo SQL para obtener un listado de productos filtrado por precio, ordenado por descripcion
    public List<Producto> consultaSQL(double precioInf, double precioSup);
}
