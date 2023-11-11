package com.tienda_v2.controller;

import com.tienda_v2.domain.Categoria;
import com.tienda_v2.domain.Producto;
import com.tienda_v2.service.CategoriaService;
import com.tienda_v2.service.ProductoService1;
import com.tienda_v2.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/pruebas")

public class PruebasController {
    
    @Autowired
    private ProductoService1 productoService;
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
       
        var productos = productoService.getProductos(false);
        model.addAttribute("productos",productos);
        model.addAttribute("totalProductos",productos.size());
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias",categorias);
        return "/pruebas/listado";
    }
    
    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {
       
        var catego = categoriaService.getCategoria(categoria);
        var productos = catego.getProductos();
        
        model.addAttribute("productos",productos);
        model.addAttribute("totalProductos",productos.size());
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias",categorias);
        return "/pruebas/listado";
    }
    
    @GetMapping("/listado2")
    public String listado2(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos",productos);
        return "/pruebas/listado2";
    }
    
    @PostMapping("/query1")
    public String consulta1(@RequestParam(value="precioInf") double precioInf, @RequestParam(value="precioSup") double precioSup, Model model) {
        var productos = productoService.consultaQuery(precioInf, precioSup);
        model.addAttribute("productos",productos);
        model.addAttribute("precioInf",precioInf);
        model.addAttribute("precioSup",precioSup);
        return "/pruebas/listado2";
    }
    
    @PostMapping("/query2")
    public String consulta2(@RequestParam(value="precioInf") double precioInf, @RequestParam(value="precioSup") double precioSup, Model model) {
        var productos = productoService.consultaJPQL(precioInf, precioSup);
        model.addAttribute("productos",productos);
        model.addAttribute("precioInf",precioInf);
        model.addAttribute("precioSup",precioSup);
        return "/pruebas/listado2";
    }
    
    @PostMapping("/query3")
    public String consulta3(@RequestParam(value="precioInf") double precioInf, @RequestParam(value="precioSup") double precioSup, Model model) {
        var productos = productoService.consultaSQL(precioInf, precioSup);
        model.addAttribute("productos",productos);
        model.addAttribute("precioInf",precioInf);
        model.addAttribute("precioSup",precioSup);
        return "/pruebas/listado2";
    }

}