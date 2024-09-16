package br.com.fiap.service;

import java.util.Map;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

import br.com.fiap.util.ClienteRequestInfo;

@ApplicationScoped
public class SpamControlService {
  private Map<Long, ClienteRequestInfo> requestMap = new ConcurrentHashMap<>();

  private final int LIMITE_REQUISICOES = 5;
  private final long INTERVALO_SEGUNDOS = 60;

  public boolean podeEnviarEmail(Long clienteId) {
    
    LocalDateTime agora = LocalDateTime.now();
    
    ClienteRequestInfo requestInfo = requestMap.get(clienteId);

    if (requestInfo == null) {
        requestMap.put(clienteId, new ClienteRequestInfo(agora, 1));
        return true;
    }

    long tempoDecorrido = java.time.Duration.between(requestInfo.getUltimaRequisicao(), agora).getSeconds();

    if (tempoDecorrido > INTERVALO_SEGUNDOS) {
        requestMap.put(clienteId, new ClienteRequestInfo(agora, 1));
        return true;
    }

    if (requestInfo.getContadorRequisicoes() < LIMITE_REQUISICOES) {
        requestInfo.incrementarRequisicoes();
        requestInfo.setUltimaRequisicao(agora);
        return true;
    }

    return false;
  }
}
