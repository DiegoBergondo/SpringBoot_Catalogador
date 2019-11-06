/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DiegoBergondo.SpringBoot_Catalogador.Controlador;

import com.DiegoBergondo.SpringBoot_Catalogador.model.Datosarticulosql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.DiegoBergondo.SpringBoot_Catalogador.Servicios.ArticuloService;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DiegoBergondo
 */
@Controller
public class Controlador {
    
    @Autowired
    private ArticuloService articuloService;
    
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("list", articuloService.getAll());
        return "index";
    }
    
    @RequestMapping("/lista")
    public String showSave(@RequestParam(value = "tipo", required = false) int tipo, Model model) {
        ArrayList<Datosarticulosql> listaArticulos = (ArrayList<Datosarticulosql>) articuloService.getAll();
        ArrayList<Datosarticulosql> listaArticulosAux = new ArrayList<Datosarticulosql>();
        for(int i=0; i < listaArticulos.size(); i++){
            if(listaArticulos.get(i).getTipo() == tipo)
                listaArticulosAux.add(listaArticulos.get(i));
        }
        model.addAttribute("list", listaArticulosAux);
        return "lista";
    }
    
    @GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id , Model model) {
		if(id != null && id != 0) {
			model.addAttribute("datosarticulosql", articuloService.get(id));
		}else {
			model.addAttribute("datosarticulosql", new Datosarticulosql());
		}
		return "save";
    }
    
    @PostMapping("/save")
    public String save(Datosarticulosql datosarticulosql, Model model){
        articuloService.save(datosarticulosql);
        return("redirect:/");
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        articuloService.delete(id);
        return("redirect:/");
    }
}
