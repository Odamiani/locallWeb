package br.com.fiap.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@NoArgsConstructor
@AllArgsConstructor
public class Email extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ID_DES", nullable = false)
  private Long idDestinatario;

  @Column(name = "ID_REM", nullable = false)
  private Long idRemetente;

  @Column(name = "CORPO", nullable = true, length = 500)
  private String corpo;

  @Column(name = "TITULO", nullable = true, length = 50)
  private String titulo;

  @Column(name = "DT_CRI", nullable = false)
  private LocalDate data;
  
}
