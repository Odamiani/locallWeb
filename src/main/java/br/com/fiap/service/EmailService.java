package br.com.fiap.service;

import java.util.List;
import br.com.fiap.model.Email;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmailService {
  
  public List<Email> listarTodos() {
    return Email.listAll();
  }

  public List<Email> listarPorCliente(Long id) {
    return Email.list("idRemetente = ?1", id);
  }
}
