package br.com.p3d50.certificates.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Certificate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private String title;

	@NotBlank
	@Column(nullable = false, length = 100000)
	private String imageBase64;

	@NotBlank
	@Column(nullable = false)
	private String imageName;

	public Certificate(String title, String imageBase64, String imageName) {
		this.title = title;
		this.imageBase64 = imageBase64;
		this.imageName = imageName;
		if (imageName == null || imageName.trim().isEmpty()) {
			throw new IllegalArgumentException("O nome da imagem não pode estar em branco.");
		}
	}

	public Certificate() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}
}
