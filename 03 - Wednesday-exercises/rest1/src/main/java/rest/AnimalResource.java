/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.Animal;
import java.util.ArrayList;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author jacobfolkehildebrandt
 */
@Path("animal")
public class AnimalResource {

    ArrayList<Animal> animals = new ArrayList();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    // @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "Hello from my first web service";
    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    public ArrayList<Animal> createAnimals() {
        animals.add(new Animal("Dog", 1994, "Miauw"));
        animals.add(new Animal("Cat", 1995, "Muuuuuuuuuuuuuuuuuh"));
        animals.add(new Animal("Sheep", 1996, "Wuf"));
        animals.add(new Animal("Cow", 1997, "Cow"));
        return animals;
    }

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimal() {
        createAnimals();
        Random r = new Random();
        int x = r.nextInt(animals.size());
      
        return new Gson().toJson(animals.get(x));
        
    }

}
