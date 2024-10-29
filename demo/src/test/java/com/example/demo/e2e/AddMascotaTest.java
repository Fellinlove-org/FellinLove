package com.example.demo.e2e;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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
        chromeOptions.addArguments("--disable-notifications");

        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void SystemTest_AddMascota_LoginVeterinario() {
        
        driver.get("http://localhost:4200/mascotas/2222");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mascota")));

        
        /* 
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
        */
    }

}