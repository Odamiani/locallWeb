package br.com.fiap.controller;

import java.util.List;

import br.com.fiap.model.Email;
import br.com.fiap.service.EmailService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
}
