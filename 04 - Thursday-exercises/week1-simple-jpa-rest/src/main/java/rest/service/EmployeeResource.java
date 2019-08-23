package rest.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.EmployeeDTO;
import entities.Employee;
import facades.EmployeeFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("employee")
public class EmployeeResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");; 
    EmployeeFacade facade =  EmployeeFacade.getFacadeExample(emf);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployeeByID(@PathParam("id") Long id){
        Employee employee = facade.getEmployeeById((id-1));
        EmployeeDTO eDTO = new EmployeeDTO(employee);
        return Response.ok().entity(gson.toJson(eDTO)).build();
    }
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllEmployee(){
        List<Employee> employee = facade.allEmployees();
        List<EmployeeDTO> eDTOL = new ArrayList();
        for (Employee e : employee) {
            eDTOL.add(new EmployeeDTO(e));
        }
        return Response.ok().entity(gson.toJson(eDTOL)).build();
    }
    
      @GET
    @Path("/highestpaid")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getHighestPaid(){
        List<Employee> employee = facade.getEmployeesWithHighestSalary();
        List<EmployeeDTO> eDTOL = new ArrayList();
        for (Employee e : employee) {
            eDTOL.add(new EmployeeDTO(e));
        }
        return Response.ok().entity(gson.toJson(eDTOL)).build();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Employee entity) {
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployeeByName(@PathParam("name") String name){
        Employee employee = facade.getEmployeesByName(name);
        EmployeeDTO eDTO = new EmployeeDTO(employee);
        return Response.ok().entity(gson.toJson(eDTO)).build();
    }
   
    
}
