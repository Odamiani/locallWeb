package br.com.fiap.util;

import java.time.LocalDateTime;

public class ClienteRequestInfo {
  private LocalDateTime ultimaRequisicao;
  private int contadorRequisicoes;

  public ClienteRequestInfo(LocalDateTime ultimaRequisicao, int contadorRequisicoes) {
      this.ultimaRequisicao = ultimaRequisicao;
      this.contadorRequisicoes = contadorRequisicoes;
  }

  public LocalDateTime getUltimaRequisicao() {
      return ultimaRequisicao;
  }

  public void setUltimaRequisicao(LocalDateTime ultimaRequisicao) {
      this.ultimaRequisicao = ultimaRequisicao;
  }

  public int getContadorRequisicoes() {
      return contadorRequisicoes;
  }

  public void incrementarRequisicoes() {
      this.contadorRequisicoes++;
  }
}