package br.com.fiap.service;

import java.util.List;
import br.com.fiap.model.Email;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class EmailService {

  @Inject
  SpamControlService spamControlService;
  
  public List<Email> listarTodos() {
    return Email.listAll();
  }

  public List<Email> listarPorCliente(Long id) {
    return Email.list("idRemetente = ?1", id);
  }

  public List<Email> listarFavoritosPorCliente(Long id) {
    return Email.list("idRemetente = ?1 AND favorito = true", id);
  }
   
  @Transactional
  public Email criarEmail(Email email) {
    if (!spamControlService.podeEnviarEmail(email.getIdRemetente())) {
      throw new WebApplicationException("Limite de requisições atingido. Tente novamente mais tarde.", Response.Status.TOO_MANY_REQUESTS);
    }
      email.persist();
      return email;
  }

  @Transactional
  public Email marcarFavorito(Long id, boolean favorito) {
    Email email = Email.findById(id);
    if (email != null) {
      email.setFavorito(favorito);
      email.persist();
    }
    return email;
  }
  
}
