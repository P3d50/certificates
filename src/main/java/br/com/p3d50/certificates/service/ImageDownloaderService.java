package br.com.p3d50.certificates.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.p3d50.certificates.model.CertificateDTO;
@Service
public class ImageDownloaderService {

	private static final String CERTIFICATES_DIRECTORY = "Certificates";


	public void downloadAndSaveImages(List<CertificateDTO> certificates) throws IOException {

		// Cria a pasta se ela não existir
		File directory = new File(CERTIFICATES_DIRECTORY);
		if (!directory.exists()) {
			directory.mkdir();
		}

		for (CertificateDTO certificateDTO : certificates) {
			String fileTitle = certificateDTO.getTitle();
			System.out.println(certificateDTO);

			String imageUrl = certificateDTO.getImageUrl();
			String fileName = fileTitle.replaceAll("[^\\w_.)( -]", "").replaceAll("\\s+", "_") + ".jpg";

			URL url = new URL(imageUrl);
			InputStream inputStream = url.openStream();

			FileOutputStream outputStream = new FileOutputStream(CERTIFICATES_DIRECTORY + "/" + fileName);
			byte[] buffer = new byte[2048];
			int length;

			while ((length = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, length);
			}

			inputStream.close();
			outputStream.close();

			
			String imageBase64 = Base64.getEncoder()
					.encodeToString(Files.readAllBytes(Paths.get(CERTIFICATES_DIRECTORY + "/" + fileName)));
			//certificateDTO.setImageBase64(imageBase64);

		}
	}

}
