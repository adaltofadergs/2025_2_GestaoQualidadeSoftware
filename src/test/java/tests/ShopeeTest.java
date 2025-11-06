package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

public class ShopeeTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // -------------------- CT01 --------------------
    @Test(priority = 1)
    public void CT01_LoginCorreto() {
        abrirPaginaLocal();
        driver.findElement(By.id("username")).sendKeys("teste@shopee.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("loginButton")).click();

        String msg = driver.findElement(By.id("message")).getText();
        Assert.assertTrue(msg.contains("sucesso"), "Falha no login correto!");
    }

    // -------------------- CT02 --------------------
    @Test(priority = 2)
    public void CT02_LoginIncorreto() {
        abrirPaginaLocal();
        driver.findElement(By.id("username")).sendKeys("teste@shopee.com");
        driver.findElement(By.id("password")).sendKeys("senhaErrada");
        driver.findElement(By.id("loginButton")).click();

        String msg = driver.findElement(By.id("message")).getText();
        Assert.assertTrue(msg.contains("incorretos"), "Mensagem de erro não exibida!");
    }

    // -------------------- CT03 --------------------
    @Test(priority = 3)
    public void CT03_RecuperacaoSenha() {
        abrirPaginaLocal();
        driver.findElement(By.id("forgotPassword")).click();

        String msg = driver.findElement(By.id("message")).getText();
        Assert.assertTrue(msg.contains("redefinição"), "Mensagem de recuperação não exibida!");
    }

    // -------------------- CT04 --------------------
    @Test(priority = 4)
    public void CT04_PesquisaProdutoMock() {
        File file = new File("src/main/resources/pesquisa_mock.html");
        driver.get(file.getAbsoluteFile().toURI().toString());

        driver.findElement(By.id("search")).sendKeys("notebook");
        driver.findElement(By.id("btnBuscar")).click();

        String resultado = driver.findElement(By.id("resultado")).getText();
        Assert.assertTrue(resultado.contains("notebook"),
                "Resultado da pesquisa não exibido corretamente!");
    }

    private void abrirPaginaLocal() {
        File file = new File("src/main/resources/login_mock.html");
        driver.get(file.getAbsoluteFile().toURI().toString());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
