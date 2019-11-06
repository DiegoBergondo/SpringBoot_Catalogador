/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DiegoBergondo.SpringBoot_Catalogador.Repositorios;

import com.DiegoBergondo.SpringBoot_Catalogador.model.Datosarticulosql;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DiegoBergondo
 */
public interface Repositorio extends CrudRepository<Datosarticulosql, Long> {
    
}
