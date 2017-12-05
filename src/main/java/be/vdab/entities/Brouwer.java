package be.vdab.entities;

import be.vdab.valueobjects.Adres;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "brouwers")
public class Brouwer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private String naam;
	@Min(0)
	@NumberFormat(pattern = "#,##0.00")
	private Integer omzet;
	@NotNull
	@Valid
	@Embedded
	private Adres adres;

	public Brouwer(long id, String naam, Integer omzet, Adres adres) {
		this.id = id;
		this.naam = naam;
		this.omzet = omzet;
		this.adres = adres;
	}

	public Brouwer() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Integer getOmzet() {
		return omzet;
	}

	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}
}
