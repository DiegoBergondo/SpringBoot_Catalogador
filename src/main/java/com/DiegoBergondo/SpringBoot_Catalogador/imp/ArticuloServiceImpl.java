/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DiegoBergondo.SpringBoot_Catalogador.imp;

import com.DiegoBergondo.SpringBoot_Catalogador.commons.GenericImpl;
import com.DiegoBergondo.SpringBoot_Catalogador.model.Datosarticulosql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.DiegoBergondo.SpringBoot_Catalogador.Repositorios.Repositorio;
import com.DiegoBergondo.SpringBoot_Catalogador.Servicios.ArticuloService;

/**
 *
 * @author DiegoBergondo
 */
@Service
public class ArticuloServiceImpl extends GenericImpl<Datosarticulosql, Long> implements ArticuloService {

    @Autowired
    private Repositorio articuloRep;
    
    @Override
    public CrudRepository<Datosarticulosql, Long> getDao() {
        return articuloRep;
    }
    
}