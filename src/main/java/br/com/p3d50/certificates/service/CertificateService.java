package br.com.p3d50.certificates.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.p3d50.certificates.model.CertificateDTO;


@Service
public class CertificateService {

	@Autowired
	ImageLoaderService imageLoader;
	
	public List<CertificateDTO> getCertificates(String usuario, String senha) throws IOException {

		try {
			return imageLoader.loader(usuario, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
