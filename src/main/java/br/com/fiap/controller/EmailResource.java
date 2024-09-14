package br.com.fiap.controller;

import java.util.List;

import br.com.fiap.model.Email;
import br.com.fiap.service.EmailService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/emails")
public class EmailResource {

    @Inject
    EmailService emailService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Email> emails() {
        return emailService.listarTodos();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public List<Email> emailCliente(@PathParam("id") Long id) {
        return emailService.listarPorCliente(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/enviar")
    public Response criarEmail(Email email) {
        Email novoEmail = emailService.criarEmail(email);
        return Response.status(Response.Status.CREATED).entity(novoEmail).build();
    }
}
