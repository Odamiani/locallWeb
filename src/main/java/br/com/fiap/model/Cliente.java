package br.com.fiap.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends PanacheEntity {

  @Column(name = "USERNAME", nullable = false, unique = true)
  private String username;

  @Column(name = "SENHA", nullable = false)
  private String senha;

  @Column(name = "EMAIL", nullable = false)
  private String email;

  @Column(name = "DT_NSC")
  private LocalDate dataNascimento;
  
}
