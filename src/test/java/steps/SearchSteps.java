package steps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class SearchSteps {


    WebDriver driver;

    @Given("Indexar pagina")
    public void indexPagina()    {

        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");


    }
    @When("Llenar Formulario")
    public void llenarFormulario() {

        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Matias");
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Escalona");
        driver.findElement(By.id("userEmail")).click();
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys("matiasescalona@gmail.com");
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys("34");
        driver.findElement(By.id("salary")).clear();
        driver.findElement(By.id("salary")).sendKeys("1000");
        driver.findElement(By.id("department")).clear();
        driver.findElement(By.id("department")).sendKeys("Santiago");

    }
    @And("Guardar Formulario")
    public void guardarFormulario()
    {
        driver.findElement(By.id("submit")).click();
    }
    @Then("Validar Llenado")
    public void validarLlenado()  {

        String title= driver.findElement(By.xpath("//*/text()[normalize-space(.)='Matias']/parent::*")).getText();

        Assert.assertEquals(title,"Matias");
    }
    @When("Editar Formulario")
    public void editarFormulario(){

        driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]")).click();
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Jesus");
    }
    @And("Guardar cambios")
    public void guardarCambios() throws InterruptedException {
        sleep(3000);
        driver.findElement(By.id("submit")).click();
    }
    @Then("Validar cambios")
    public void validarCambios() throws InterruptedException {

        String title= driver.findElement(By.xpath("//*/text()[normalize-space(.)='Jesus']/parent::*")).getText();

        Assert.assertEquals(title,"Jesus");
    }
    @And("Eliminar Formulario")
    public void eliminarFormulario(){

        driver.findElement(By.id("delete-record-1")).click();
        driver.findElement(By.id("delete-record-2")).click();
        driver.findElement(By.id("delete-record-3")).click();
    }
}
