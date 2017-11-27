package be.vdab.entities;

import be.vdab.valueobjects.Adres;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Brouwer implements Serializable {

	private static final long serialVersionUID = 1L;
	private long brouwerNr;
	@NotBlank
	private String naam;
	@Min(0)
	@NumberFormat(pattern = "#,##0.00")
	private Integer omzet;
	@NotNull
	@Valid
	private Adres adres;

	public Brouwer(long brouwerNr, String naam, Integer omzet, Adres adres) {
		this.brouwerNr = brouwerNr;
		this.naam = naam;
		this.omzet = omzet;
		this.adres = adres;
	}

	public Brouwer() {
	}

	public long getBrouwerNr() {
		return brouwerNr;
	}

	public void setBrouwerNr(long brouwerNr) {
		this.brouwerNr = brouwerNr;
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
