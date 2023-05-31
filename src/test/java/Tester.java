import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Tester {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        String expected = "Welcome to Duotify!";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expected);
        Thread.sleep(1000);
        driver.findElement(By.id("hideLogin")).click();

        String str ="abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder sb = new StringBuilder(5);

        for (int i = 0; i < 5; i++) {
            int index
                    = (int)(str.length()
                    * Math.random());
            sb.append(str
                    .charAt(index));
        }
        String userName = sb.toString();

        driver.findElement(By.id("username")).sendKeys(userName);
        Thread.sleep(1000);
        driver.findElement(By.id("firstName")).sendKeys("John");
        Thread.sleep(1000);
        driver.findElement(By.id("lastName")).sendKeys("Smith");
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys(userName+"@yahoo.com");
        Thread.sleep(1000);
        driver.findElement(By.id("email2")).sendKeys(userName+"@yahoo.com");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("John123");
        Thread.sleep(1000);
        driver.findElement(By.id("password2")).sendKeys("John123");
        Thread.sleep(1000);
        driver.findElement(By.name("registerButton")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?");
        Thread.sleep(1000);
        //Assert.assertEquals(driver.findElement(By.id("nameFirstAndLast")),"John Smith");

        Assert.assertTrue(driver.getPageSource().contains("John Smith"));
        Thread.sleep(1000);
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(1000);
       // Assert.assertEquals(driver.findElement(By.className("userInfo")), "John Smith");
        //Thread.sleep(1000);
        driver.findElement(By.id("rafael")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        driver.findElement(By.id("loginUsername")).sendKeys(userName);
        Thread.sleep(1000);
        driver.findElement(By.id("loginPassword")).sendKeys("John123");
        Thread.sleep(1000);
        driver.findElement(By.name("loginButton")).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getPageSource().contains("You Might Also Like"));
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("rafael")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        driver.quit();


    }
}
