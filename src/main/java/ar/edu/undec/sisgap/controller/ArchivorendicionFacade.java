/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.undec.sisgap.controller;

import ar.edu.undec.sisgap.model.Archivorendicion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mpaez
 */
@Stateless
public class ArchivorendicionFacade extends AbstractFacade<Archivorendicion> {
    @PersistenceContext(unitName = "ar.edu.undec_SYSGAP_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArchivorendicionFacade() {
        super(Archivorendicion.class);
    }
    
}
