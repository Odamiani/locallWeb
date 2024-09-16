package br.com.fiap.service;

import java.util.List;

import br.com.fiap.model.Cliente;
import br.com.fiap.model.Papel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClienteService {

      public List<Cliente> listarTodos() {
        return Cliente.listAll();
    }

    public List<Cliente> listarAdministradores() {
        return Cliente.list("papel = ?1", Papel.ADM);
    }

    @Transactional
    public Cliente criarCliente(Cliente cliente) {
        cliente.persist();
        return cliente;
    }

    @Transactional
    public Cliente atualizarCliente(Cliente cliente) {
        cliente.persist();
        return cliente;
    }
  
}
