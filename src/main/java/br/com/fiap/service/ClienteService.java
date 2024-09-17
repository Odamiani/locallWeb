package br.com.fiap.service;

import java.util.List;

import br.com.fiap.model.Cliente;
import br.com.fiap.model.Papel;
import br.com.fiap.model.Tema;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

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

    @Transactional
    public Cliente atualizarTema(Long clienteId){
        Cliente cliente = Cliente.findById(clienteId);
        if (cliente == null){
            throw new NotFoundException("Cliente não encontrado");
        }
        if (cliente.getTema() == Tema.CLARO) {
            cliente.setTema(Tema.ESCURO);
        } else {
            cliente.setTema(Tema.CLARO);
        }
        cliente.persist();
        return cliente;
    }
}
