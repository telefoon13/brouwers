package be.vdab.valueobjects;

import org.hibernate.validator.constraints.NotBlank;

public class BeginNaamForm {

	@NotBlank
	private String beginnaam;

	public String getBeginnaam() {
		return beginnaam;
	}

	public void setBeginnaam(String beginnaam) {
		this.beginnaam = beginnaam;
	}
}
