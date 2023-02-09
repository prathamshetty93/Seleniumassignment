import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.sql.Driver;
import java.util.List;

public class HelloWorld {
    WebDriver driver;
    WebElement searchBar,amazonLink;


    public void launchBrowser(){
        System.setProperty("Webdriver.chrome.driver","/Users/ppshetty/Downloads/chromedriver_mac64/chromedriver");
        driver=new ChromeDriver(); //instantiating the web browser
        driver.get("https://www.google.com"); //get method to launch the website
        searchBar =driver.findElement(By.name("q"));
        searchBar.sendKeys("amazon.in");
        searchBar.submit();
        amazonLink =driver.findElement(By.xpath("//h3[normalize-space()='Amazon.in']"));
        amazonLink.click();
    }

    //Displaying the All categories below the search bar
    public void searchCategories()  {

        //driver.findElement(By.linkText("All")).click();
        WebElement drpdwn=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        drpdwn.click();
        Select drp =new Select(drpdwn);
        //To print all the categories on the console
        List<WebElement> listdrpdwn=drp.getOptions();
        for(WebElement e: listdrpdwn){
            System.out.println(e.getText());
        }
        driver.navigate().refresh();
    }

    //search the Product sony bravia 55 inch
    public void searchProduct()  {

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Sony Bravia 55 inch");
        driver.findElement(By.id("nav-search-submit-text")).click();
        WebElement priceName = driver.findElement(By.className("a-price-whole"));
        System.out.println(priceName.getText());
        driver.quit();

    }

    //searching the electronics section
    public void searchSection()  {

        driver.findElement(By.linkText("Electronics")).click();
        driver.navigate().refresh();

    }


    public static void main(String[] args) throws InterruptedException {
        HelloWorld obj1 =new HelloWorld();
        obj1.launchBrowser();
        obj1.searchCategories();
        obj1.searchSection();
        obj1.searchProduct();
    }
}
