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
import modelo.Usuario;

/**
 *
 * @author CRISTINA CALLE
 */
@Stateless
@Path("modelo.usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "RepasoBimestralPU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usuario entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Usuario entity) {
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
    public Usuario find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() {
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
    public String crear(@FormParam("nombre")String nombre,@FormParam("direc")String direccion,
        @FormParam("correo")String correo,@FormParam("telefono")Integer telefono,
        @FormParam("ciudad")String ciudad,@FormParam("edad")Integer edad,
        @FormParam("preferencia")Integer joyeriaPreferencia){
    Usuario usuario =new Usuario(nombre);
    super.create(usuario);
   
  return "Cliente creado con exito";
}
       @POST
@Path ("Update")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public String update(@FormParam("nombre")String nombre,@FormParam("direc")String direccion,
        @FormParam("correo")String correo,@FormParam("telefono")Integer telefono,
        @FormParam("ciudad")String ciudad,@FormParam("edad")Integer edad,
        @FormParam("preferencia")Integer joyeriaPreferencia){
    
    Usuario usuario=super.find(nombre);
    usuario.setNombre(nombre);
    usuario.setDireccion(direccion);
    usuario.setCorreo(correo);
    usuario.setTelefono(telefono);
    usuario.setCiudad(ciudad);
    usuario.setEdad(edad);
    usuario.setJoyeriaPreferencia(joyeriaPreferencia);
   
    return "cliente editado con exito";
}
@POST
@Path ("Consulta")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public List<Usuario> leer(@FormParam("preferencia")Integer joyeriaPreferencia){
    TypedQuery consulta=getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.joyeriaPreferencia = :joyeriaPreferencia",Usuario.class);
    consulta.setParameter("joyeriaPreferencia", joyeriaPreferencia);
    
    return consulta.getResultList();
}
@POST
@Path ("mayores")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public List<Usuario> mayoresEdad(@FormParam("edad")Integer edad){
    TypedQuery consulta=getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.edad > :edad",Usuario.class);
    consulta.setParameter("edad", edad);
    
    return consulta.getResultList();
}

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
