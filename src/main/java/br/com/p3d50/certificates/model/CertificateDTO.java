package br.com.p3d50.certificates.model;


public class CertificateDTO {

	private String title;
	private String imageUrl;
	private String imageBase64;

	
	public CertificateDTO(String title, String imageUrl) {
		this.title = title;
		this.imageUrl = imageUrl;
	}

	
	public CertificateDTO(String title, String imageUrl,String imageBase64) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.imageBase64 = imageBase64;
	}

	public CertificateDTO() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}
	
	@Override
    public String toString() {
        return "Certificado{" +
                "title='" + title + '\'' +
                '}';
    }

}
