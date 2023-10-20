package com.tienda_v2.service;

import com.tienda_v2.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //Se obtiene un array List con todas las categorias de la tabla
    public List<Categoria> getCategorias(boolean avtivo);   
    
    //Se obtiene una Categoria segun el Id pasado por parametro
    public Categoria getCategoria(Categoria categoria);
    
    //Se actualiza una categoria o se inserta una nueva... (Si no hay id es un insert)
    public void save(Categoria categoria);
    
    //Se elimina una cateogoria segun el Id pasado
    
    public void delete(Categoria categoria);
}
