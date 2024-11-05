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
        nombreMascota.sendKeys("Hannah");
        raza.sendKeys("Husky");
        edad.sendKeys("4");
        peso.sendKeys("18");
        enfermedad.sendKeys("vecio");
        fotoMascota.sendKeys("https://huskysiberianshadi.com/wp-content/uploads/2021/01/87B42900-7968-4AA2-9818-C8220F10C4BA.jpeg");
        optionCliente.click();
        btnAddMascota2.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mascota")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-mascota")));
        nombreSearch = driver.findElement(By.id("search-mascota"));
        nombreSearch.sendKeys("Hannah");
        WebElement btnSearchMascota = driver.findElement(By.id("btn-search-mascota"));
        btnSearchMascota.click();

        driver.get("http://localhost:4200/");
        botonLogin = driver.findElement(By.id("login"));
        botonLogin.click();
        WebElement cedulaCliente = driver.findElement(By.id("cedula"));
        cedulaCliente.sendKeys("123456789");
        btnIngresar = driver.findElement(By.id("btn-login"));
        btnIngresar.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mis-mascotas")));
        WebElement btnMisMascotas = driver.findElement(By.id("mis-mascotas"));
        btnMisMascotas.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mascota")));

        WebElement nombreMascotaTable = driver.findElement(By.id("mascota-nombre"));

        Assertions.assertThat(nombreMascotaTable.getText()).isEqualTo("Hannah");

    }


    @Test
    public void SystemTest_AddTratamiento() {

        driver.get("http://localhost:4200/");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        WebElement botonLogin = driver.findElement(By.id("login"));
        botonLogin.click();
        
        WebElement btnAdmin = driver.findElement(By.id("btn-admin"));
        btnAdmin.click();

        WebElement cedulaAdmin = driver.findElement(By.id("cedula"));
        cedulaAdmin.sendKeys("123456");

        WebElement passwordAdmin = driver.findElement(By.id("password"));
        passwordAdmin.sendKeys("0000");

        WebElement btnIngresar = driver.findElement(By.id("btn-login"));
        btnIngresar.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dashboard")));
        WebElement btnDashboard = driver.findElement(By.id("dashboard"));
        btnDashboard.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("kpi-value")));
        WebElement kpiValue = driver.findElement(By.id("kpi-value"));
        Assertions.assertThat(kpiValue.getText()).isEqualTo("$0.00");

        WebElement tratamientosTotales = driver.findElement(By.id("total-tratamientos"));
        Integer numtratamientos = Integer.parseInt(tratamientosTotales.getText());



        driver.get("http://localhost:4200/");
        botonLogin = driver.findElement(By.id("login"));
        botonLogin.click();
        
        WebElement btnDoctor = driver.findElement(By.id("btn-doctor"));
        btnDoctor.click();

        WebElement cedulaVeterinario = driver.findElement(By.id("cedula"));
        cedulaVeterinario.sendKeys("2222");

        WebElement passwordVeterinario = driver.findElement(By.id("password"));
        passwordVeterinario.sendKeys("0001");


        btnIngresar = driver.findElement(By.id("btn-login"));
        btnIngresar.click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-mascotas")));

        WebElement btnMascotas = driver.findElement(By.id("btn-mascotas"));
        btnMascotas.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mascota")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-mascota")));
        WebElement nombreSearch = driver.findElement(By.id("search-mascota"));
        nombreSearch.sendKeys("Misu");
        WebElement btnSearchMascota = driver.findElement(By.id("btn-search-mascota"));
        btnSearchMascota.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mostar-mascota")));
        WebElement mostrarMascota = driver.findElement(By.id("mostar-mascota"));
        mostrarMascota.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-tratamiento")));
        WebElement btnAddTratamiento = driver.findElement(By.id("add-tratamiento"));
        btnAddTratamiento.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("form-tratamiento")));
        WebElement droga = driver.findElement(By.id("droga"));
        droga.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("droga3")));
        WebElement droga3 = driver.findElement(By.id("droga3"));
        droga3.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cantidad")));
        WebElement cantidad = driver.findElement(By.id("cantidad"));
        cantidad.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cantidad1")));
        WebElement cantidad1 = driver.findElement(By.id("cantidad1"));
        cantidad1.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-submit-tratamiento")));
        WebElement btnSubmitTratamiento = driver.findElement(By.id("btn-submit-tratamiento"));
        btnSubmitTratamiento.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tratamiento1")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-tratamiento")));
        nombreSearch = driver.findElement(By.id("search-tratamiento"));
        nombreSearch.sendKeys("Misu");
        WebElement btnSearchTratamiento = driver.findElement(By.id("btn-search-tratamiento"));
        btnSearchTratamiento.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tratamiento11")));
        WebElement nombreVet = driver.findElement(By.id("nombre-veterinario11"));
        WebElement nombreMascota = driver.findElement(By.id("nombre-mascota11"));
        WebElement nombreDroga = driver.findElement(By.id("nombre-droga11"));
        WebElement cantidadTratamiento = driver.findElement(By.id("cantidad11"));

        Assertions.assertThat(nombreVet.getText()).isEqualTo("Dr. Juan Pérez");
        Assertions.assertThat(nombreMascota.getText()).isEqualTo("Misu");
        Assertions.assertThat(nombreDroga.getText()).isEqualTo("ACUIMIX");
        Assertions.assertThat(cantidadTratamiento.getText()).isEqualTo("1");

        driver.get("http://localhost:4200/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        botonLogin = driver.findElement(By.id("login"));
        botonLogin.click();
        
        btnAdmin = driver.findElement(By.id("btn-admin"));
        btnAdmin.click();

        cedulaAdmin = driver.findElement(By.id("cedula"));
        cedulaAdmin.sendKeys("123456");

        passwordAdmin = driver.findElement(By.id("password"));
        passwordAdmin.sendKeys("0000");

        btnIngresar = driver.findElement(By.id("btn-login"));
        btnIngresar.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dashboard")));
        btnDashboard = driver.findElement(By.id("dashboard"));
        btnDashboard.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("kpi-value")));
        kpiValue = driver.findElement(By.id("kpi-value"));
        Assertions.assertThat(kpiValue.getText()).isIn("$114,800.00", "$22,960.00");

        WebElement numtratamientos2 = driver.findElement(By.id("total-tratamientos"));
        String numtratamientosString = String.valueOf(numtratamientos+1);
        Assertions.assertThat(numtratamientos2.getText()).isEqualTo(numtratamientosString);
    }

}