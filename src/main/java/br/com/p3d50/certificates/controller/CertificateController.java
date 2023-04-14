package br.com.p3d50.certificates.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.p3d50.certificates.model.CertificateDTO;
import br.com.p3d50.certificates.service.CertificateService;

@RestController
public class CertificateController {

	private final CertificateService certificateService;

	public CertificateController(CertificateService certificateService) {
		this.certificateService = certificateService;
	}

	@PostMapping("/certificates")
	public ResponseEntity<List<CertificateDTO>> downloadCertificate(@RequestParam("usuario") String usuario,
			@RequestParam("senha") String senha) {

		try {
			// Use os valores dos parâmetros para fazer o que você precisa
			List<CertificateDTO> certificates = certificateService.getCertificates(usuario, senha);
			return ResponseEntity.ok(certificates);
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
