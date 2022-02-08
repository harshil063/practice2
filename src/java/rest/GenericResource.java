/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.BookBeanLocal;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Harshil
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;
    
    @EJB BookBeanLocal bc;
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    @POST
    @Path("/addbookcat/{bookcatname}")
    public void AddBookCat(@PathParam("bookcatname")String bookcatname){
        bc.AddBookcat(bookcatname);
    }
    
    @PUT
    @Path("/updatebookcat/{bookcatid}/{bookcatname}")
    public void updatebookcat(@PathParam("bookcatid")Integer bookcat_id, @PathParam("bookcatname")String bookcat_name){
        bc.UpdateBookcat(bookcat_id, bookcat_name);
    }
    
    @DELETE
    @Path("/deletebookcat/{bookcatid}")
    public void deletebookcat(@PathParam("bookcatid")Integer bookcat_id){
        bc.RemoveBookcat(bookcat_id);
    }
    /**
     * Retrieves representation of an instance of rest.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
