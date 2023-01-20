
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastro {

	@Test

	public void deveCriarUsuarioCorretamente() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/");

		driver.findElement(By.id("nome")).sendKeys("Regina Azzi");
		driver.findElement(By.id("cpf")).sendKeys("89961265009");
		driver.findElement(By.id("celular")).sendKeys("11111111111");
		driver.findElement(By.id("dt-nascimento")).sendKeys("30/11/1977");
		driver.findElement(By.id("btn-salvar")).click();
		
		driver.quit();

	}

	@Test

	public void deveCriarUsuarioInformandoSimboloNoNome() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/");

		driver.findElement(By.id("nome")).sendKeys("?");
		driver.findElement(By.id("cpf")).sendKeys(" ");
		driver.findElement(By.id("celular")).sendKeys(" ");
		driver.findElement(By.id("dt-nascimento")).sendKeys(" ");
		driver.findElement(By.id("btn-salvar")).click();

		driver.quit();
	}

	@Test

	public void deveCriarUsuarioComDadosDuplicado() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/");

		driver.findElement(By.id("nome")).sendKeys("Regina Azzi");
		driver.findElement(By.id("cpf")).sendKeys("89961265009");
		driver.findElement(By.id("celular")).sendKeys("11111111111");
		driver.findElement(By.id("dt-nascimento")).sendKeys("30/11/1977");
		driver.findElement(By.id("btn-salvar")).click();
		

		driver.quit();

	}

	@Test

	public void deveBuscarUmUsuarioCadastrado() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/");

		driver.findElement(By.id("input-search")).sendKeys("Regina Azzi");
		driver.findElement(By.xpath("//*[@id=\"app\"]/form[2]/button")).click();
		Assert.assertEquals("Regina Azzi",
				driver.findElement(By.xpath("//*[@id=\"tabela-usuarios\"]/tbody/tr[1]/td[1]")).getText());

		driver.quit();

	}

	@Test

	public void deveBuscarTodosUsuariosCadastrados() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/");

		driver.findElement(By.id("input-search")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"app\"]/form[2]/button")).click();
		
		
		driver.quit();

	}

	@Test

	public void deveExcluiTodosUsuariosCadastrados() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/");

		driver.findElement(By.id("input-search")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"app\"]/button")).click();
		Assert.assertEquals("Nome CPF: Celular: Data de nascimento:",
				driver.findElement(By.id("tabela-usuarios")).getText());
		
		driver.quit();

	}
}
