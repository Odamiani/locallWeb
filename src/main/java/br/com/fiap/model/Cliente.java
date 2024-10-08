package br.com.fiap.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "USERNAME", nullable = false, unique = true)
  private String username;

  @Column(name = "SENHA", nullable = false)
  private String senha;

  @Column(name = "EMAIL", nullable = false)
  private String email;

  @Column(name = "DT_CRI", nullable = false)
  private LocalDate dataCriacao;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "PAPEL", nullable = false)
  private Papel papel;

  @Enumerated(EnumType.STRING)
  @Column(name = "TEMA", nullable = false)
  private Tema tema = Tema.CLARO;

}
