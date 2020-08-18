/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Joyerialocal;
import modelo.Usuario;

/**
 *
 * @author CRISTINA CALLE
 */
@Stateless
@Path("modelo.joyerialocal")
public class JoyerialocalFacadeREST extends AbstractFacade<Joyerialocal> {

    @PersistenceContext(unitName = "RepasoBimestralPU")
    private EntityManager em;

    public JoyerialocalFacadeREST() {
        super(Joyerialocal.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Joyerialocal entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Joyerialocal entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Joyerialocal find(@PathParam("id") String id) {
        return super.find(id);
    }
  
    

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Joyerialocal> findAll() {
        return super.findAll();
    }
    @POST
    @Path ("Chao")
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String despedida(){
        String mensaje= "chao a todos ";
        return mensaje;
    }
      @POST
    @Path("crear")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("nombre")String nombre,@FormParam("ubi")String ubicacion,
        @FormParam("dire")String direccion,@FormParam("encargado")String nomEncargado,
        @FormParam("dimension")Integer dimension,@FormParam("ciudad")String ciudad){
    Joyerialocal joyeria =new Joyerialocal(nombre, ubicacion, direccion, nomEncargado, dimension, ciudad);
    super.create(joyeria);
   
    return "Joyeria creado con exito";
}
    @POST
@Path ("Update")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public String update(@FormParam("nombre")String nombre,@FormParam("ubi")String ubicacion,
        @FormParam("dire")String direccion,@FormParam("encargado")String nomEncargado,
        @FormParam("dimension")Integer dimension,@FormParam("ciudad")String ciudad){
    
    Joyerialocal joyerialocal=super.find(nombre);
    joyerialocal.setNombre(nombre);
    joyerialocal.setUbicacion(ubicacion);
    joyerialocal.setDireccion(direccion);
    joyerialocal.setNomEncargado(nomEncargado);
    joyerialocal.setDimension(dimension);
    joyerialocal.setCiudad(ciudad);
    
    return "joyeria editado con exito";
}
@POST
@Path ("Eliminar")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public String eliminar(@FormParam("nombre")String nombre,@FormParam("ubi")String ubicacion,
        @FormParam("dire")String direccion,@FormParam("encargado")String nomEncargado,
        @FormParam("dimension")Integer dimension,@FormParam("ciudad")String ciudad){
    Joyerialocal joyerialocal =super.find(nombre);
     joyerialocal.setNombre(nombre);
    joyerialocal.setUbicacion(ubicacion);
    joyerialocal.setDireccion(direccion);
    joyerialocal.setNomEncargado(nomEncargado);
    joyerialocal.setDimension(dimension);
    joyerialocal.setCiudad(ciudad);
    super.remove(joyerialocal);
    return "eliminado correctamente";
}
@POST
@Path ("Consulta")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public List<Joyerialocal> leer(@FormParam("ciudad")String ciudad){
    TypedQuery consulta=getEntityManager().createQuery("SELECT j FROM Joyerialocal j WHERE j.ciudad = :ciudad",Usuario.class);
    consulta.setParameter("ciudad", ciudad);
    
    return consulta.getResultList();
}
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Joyerialocal> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
