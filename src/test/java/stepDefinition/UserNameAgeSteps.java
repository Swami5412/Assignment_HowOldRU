package stepDefinition;


import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pages.UserNameAgePage;

public class UserNameAgeSteps {

    UserNameAgePage userNameAgePage = new UserNameAgePage(DriverFactory.getDriver());

    @Given("user is on Howoldru web page")
    public void user_is_on_howoldru_web_page() {
        DriverFactory.getDriver().get("https://howoldru.m-messiah.cc/");
        String url = userNameAgePage.url();
        Assert.assertThat(url, Matchers.equalTo("https://howoldru.m-messiah.cc/"));
    }

    @When("user enters {string} in required field")
    public void userEntersInRequiredField(String nm) {
        userNameAgePage.setYourname(nm);
    }

    @And("enters {string} in birthday-input box")
    public void entersInBirthdayInputBox(String birthday) {
        userNameAgePage.setBirthday(birthday);
    }

    @When("click on submit button")
    public void click_on_submit_button() {
        userNameAgePage.setSubmit();
    }

    @Then("user must see name with age no.")
    public void user_must_see_name_with_age_no() {
        String age = userNameAgePage.setresult();
        Assert.assertThat(age, Matchers.notNullValue());
    }

    @When("user enters name {string} and dob {string} in require fields")
    public void userEntersNameAndDobInRequireFields(String name, String Dob) {
        userNameAgePage.setYourname(name);
        userNameAgePage.setBirthday(Dob);

    }

    @Then("user must get error message")
    public void user_must_get_message() {
        String textMsg = userNameAgePage.setMessage();
        if (textMsg.equals("your birthday must be in the past")) {
            System.out.println("your birthday must be in the past");
        } else {
            System.out.println("test is fail");
        }
    }

    @Then("notify by text")
    public void receivesTheText() {
        String text = userNameAgePage.settext();
        Assert.assertThat(text, Matchers.equalToIgnoringCase("Incorrect symbols"));
    }

    @When("user enters name {string} and dob {string} in required fields")
    public void userEntersNameAndDobInReqireFields(String name1, String Dob1) {
        userNameAgePage.setYourname(name1);
        userNameAgePage.setBirthday(Dob1);
    }
}
