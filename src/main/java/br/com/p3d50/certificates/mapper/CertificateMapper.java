package br.com.p3d50.certificates.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.p3d50.certificates.model.Certificate;
import br.com.p3d50.certificates.model.CertificateDTO;

@Mapper
public interface CertificateMapper {
    CertificateMapper INSTANCE = Mappers.getMapper(CertificateMapper.class);

    @Mapping(source = "imageUrl", target = "imageName")
    Certificate toEntity(CertificateDTO dto);

    @Mapping(source = "imageName", target = "imageUrl")
    CertificateDTO toDTO(Certificate entity);

   
}

