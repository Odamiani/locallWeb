package br.com.fiap.controller;

import java.util.List;

import br.com.fiap.model.Cliente;
import br.com.fiap.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/clientes")
public class ClienteResource {
  
  @Inject
  ClienteService clienteService;
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Cliente> clientes() {
      return clienteService.listarTodos();
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/admins")
  public List<Cliente> listarAdministradores() {
      return clienteService.listarAdministradores();
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/criar")
  public Response criarCliente(Cliente cliente) {
      Cliente novoCliente = clienteService.criarCliente(cliente);
      return Response.status(Response.Status.CREATED).entity(novoCliente).build();
  }
}
