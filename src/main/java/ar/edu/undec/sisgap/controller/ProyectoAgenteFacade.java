/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.undec.sisgap.controller;

import ar.edu.undec.sisgap.model.ProyectoAgente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hugo
 */
@Stateless
public class ProyectoAgenteFacade extends AbstractFacade<ProyectoAgente> {
    @PersistenceContext(unitName = "ar.edu.undec_SYSGAP_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoAgenteFacade() {
        super(ProyectoAgente.class);
    }
    
     public List<ProyectoAgente> buscarEquipoTrabajo(int proyectoid) {

        try {
            return em.createQuery("SELECT p FROM ProyectoAgente p WHERE p.proyectoAgentePK.proyectoid = :proyectoid", ProyectoAgente.class).setParameter("proyectoid", proyectoid).getResultList();
        } catch (Exception e) {
            System.out.println("No se pudo realizar la consulta" + e);
            return null;
        }

    }
     
     public void removebyProyecto(int proyectoid) {

        try {
            em.createQuery("Delete FROM ProyectoAgente p WHERE p.proyectoAgentePK.proyectoid = :proyectoid", ProyectoAgente.class).setParameter("proyectoid", proyectoid).getResultList();
        } catch (Exception e) {
            System.out.println("No se pudo realizar la eliminacion" + e);
           
        }

    }
     
      public Double sumarHorasAgenteProyectos(int agenteid) {

        try {
            return em.createQuery("select pa.agenteid, sum(horasdedicadas) from ProyectoAgente pa where pa.agenteid = "+agenteid+" group by pa.agenteid", Double.class).getSingleResult();
        } catch (Exception e) {
           
           return null;
        }

    }
}
