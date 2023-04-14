package br.com.p3d50.certificates.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import br.com.p3d50.certificates.model.CertificateDTO;
import io.github.bonigarcia.wdm.WebDriverManager;

@Component
public class ImageLoaderService {

	@Autowired
	private Environment env;

	@Autowired
	ImageDownloaderService imageDownloaderService;

	public List<CertificateDTO> loader(String usuario, String senha) throws Exception {
		// Configura o driver do Chrome
		WebDriverManager.chromedriver().setup();

		// Inicia o navegador
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		WebDriver driver = new ChromeDriver(options);

		// Variáveis de login e URL
		String loginUrl = env.getProperty("dio.page.login");
		String certificatesUrl = env.getProperty("dio.page.certificates");

		try {
			// Navega para a página de login
			driver.get(loginUrl);

			// Encontra os campos de login e preenche com as credenciais
			WebElement usernameField = driver.findElement(By.name("username"));
			WebElement passwordField = driver.findElement(By.name("password"));
			usernameField.sendKeys(usuario);
			passwordField.sendKeys(senha);

			// Encontra o botão de login e clica nele
			WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
			loginButton.click();

			// Navega diretamente para a página de certificados
			driver.get(certificatesUrl);

			// Espera até que a página seja carregada completamente
			WebDriverWait wait = new WebDriverWait(driver, 20); // alterado de Duration.ofSeconds(20)
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("#root > div > div > div > main > div")));
			Thread.sleep(3000);

			// Extrai a lista de certificados da página
			WebElement cardsContainer = driver.findElement(By.cssSelector("#root > div > div > div > main > div"));
			List<WebElement> cards = cardsContainer.findElements(By.cssSelector(".card"));

			List<CertificateDTO> certificates = new ArrayList<>();
			for (WebElement card : cards) {
				WebElement imageElement = card.findElement(By.cssSelector(".image img"));
				String imageUrl = imageElement.getAttribute("src");

				WebElement titleElement = card.findElement(By.cssSelector(".col-md-7 h5"));
				String title = titleElement.getText();

				certificates.add(new CertificateDTO(title, imageUrl));
			}

			// Fecha o navegador
			driver.quit();

			// Baixa as imagens e salva em disco
			imageDownloaderService.downloadAndSaveImages(certificates);

			return certificates;

		} catch (Exception e) {
			throw e;
		} finally {
			// Fecha o navegador
			driver.quit();
		}
	}
}
