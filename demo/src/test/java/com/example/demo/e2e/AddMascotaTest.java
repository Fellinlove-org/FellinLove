package com.example.demo.e2e;

import java.time.Duration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.xml.bind.annotation.XmlElement.DEFAULT;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) 
public class AddMascotaTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions chromeOptions = new ChromeOptions();

        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-extensions");

        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void SystemTest_AddMascota_LoginVeterinario() {
        
        driver.get("http://localhost:4200/");
        
        WebElement botonLogin = driver.findElement(By.id("login"));
        botonLogin.click();

        WebElement btnDoctor = driver.findElement(By.id("btn-doctor"));
        btnDoctor.click();

        WebElement cedulaVeterinario = driver.findElement(By.id("cedula"));
        cedulaVeterinario.sendKeys("2222");

        WebElement passwordVeterinario = driver.findElement(By.id("password"));
        passwordVeterinario.sendKeys("0001");


        WebElement btnIngresar = driver.findElement(By.id("btn-login"));
        btnIngresar.click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-mascotas")));
        WebElement btnClientes = driver.findElement(By.id("btn-clientes"));
        btnClientes.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-cliente")));
        WebElement btnAddCliente = driver.findElement(By.id("add-cliente"));
        btnAddCliente.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("form-cliente")));
        WebElement nombre = driver.findElement(By.id("nombre"));
        WebElement cedula = driver.findElement(By.id("cedula"));
        WebElement correo = driver.findElement(By.id("correo"));
        WebElement celular = driver.findElement(By.id("celular"));
        WebElement foto = driver.findElement(By.id("foto"));
        WebElement btnAdd = driver.findElement(By.id("btn-submit"));
        nombre.sendKeys("Daniel Escobar");
        cedula.sendKeys("123456789");
        correo.sendKeys("daniel@gmail.com");
        celular.sendKeys("321321321");
        foto.sendKeys("foto daniel");
        btnAdd.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cliente")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-cliente")));
        WebElement nombreSearch = driver.findElement(By.id("search-cliente"));
        nombreSearch.sendKeys("Daniel Escobar");
        WebElement btnSearch = driver.findElement(By.id("btn-search"));
        btnSearch.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("edit-cliente")));
        WebElement btnEdit = driver.findElement(By.id("edit-cliente"));
        btnEdit.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("form-cliente")));
        WebElement nombreEdit = driver.findElement(By.id("nombre"));
        nombreEdit.clear();
        nombreEdit.sendKeys("Daniel Teran");

        WebElement btnUpdate = driver.findElement(By.id("btn-submit"));
        btnUpdate.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cliente")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-cliente")));
        nombreSearch = driver.findElement(By.id("search-cliente"));
        nombreSearch.sendKeys("Daniel Teran");
        btnSearch = driver.findElement(By.id("btn-search"));
        btnSearch.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cliente")));
        WebElement newNombre = driver.findElement(By.id("nombre-cliente"));

        Assertions.assertThat(newNombre.getText()).isEqualTo("Daniel Teran");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-mascotas")));
        WebElement btnMascotas = driver.findElement(By.id("btn-mascotas"));
        btnMascotas.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-mascota")));
        WebElement btnAddMascota = driver.findElement(By.id("add-mascota"));
        btnAddMascota.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("form-mascota")));
        WebElement nombreMascota = driver.findElement(By.id("nombre-mascota"));
        WebElement raza = driver.findElement(By.id("raza-mascota"));
        WebElement edad = driver.findElement(By.id("edad-mascota"));
        WebElement peso = driver.findElement(By.id("peso-mascota"));
        WebElement enfermedad = driver.findElement(By.id("enfermedad-mascota"));
        WebElement fotoMascota = driver.findElement(By.id("foto-mascota"));
        WebElement btnAddMascota2 = driver.findElement(By.id("btn-submit-mascota"));
        WebElement optionCliente = driver.findElement(By.id("cliente-option"));
        nombreMascota.sendKeys("Misu");
        raza.sendKeys("Persa");
        edad.sendKeys("3");
        peso.sendKeys("4.2");
        enfermedad.sendKeys("Asma");
        fotoMascota.sendKeys("foto misu");
        optionCliente.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        btnAddMascota2.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mascota")));
    }

}