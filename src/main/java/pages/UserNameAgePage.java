package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserNameAgePage {

    public WebDriver driver;

    By yourname = By.cssSelector("#inputName");
    By birthday = By.xpath("//input[@id='inputBirthday']");
    By submit = By.xpath("//button[@id='submitButton']");
    By resultAge = By.xpath("//span[@id='resultAge']");
    By message = By.xpath("//span[@id='help_birthday']");
    By text = By.xpath("//span[@id='help_name']");

    public UserNameAgePage(WebDriver driver) {
        this.driver = driver;
    }

    public String url() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public void setYourname(String name) {
        driver.findElement(yourname).sendKeys(name);
    }

    public void setBirthday(String birthdate) {
        driver.findElement(birthday).sendKeys(birthdate);
    }

    public void setSubmit() {

        driver.findElement(submit).click();
    }

    public String setresult() {
        WebElement wait = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(resultAge));
        String age = wait.getText();
        return age;
    }

    public String setMessage() {
        WebElement wait = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(message));
        String msg = wait.getText();
        return msg;
    }

    public String settext() {
        WebElement wait = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(text));
        String txt = wait.getText();
        return txt;
    }


}
