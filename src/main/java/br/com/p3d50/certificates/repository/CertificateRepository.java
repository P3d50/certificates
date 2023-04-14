package br.com.p3d50.certificates.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.p3d50.certificates.model.Certificate;


@Component
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

	<S> S save(Certificate certificate);

}

