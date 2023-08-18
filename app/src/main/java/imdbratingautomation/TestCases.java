package imdbratingautomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCases {

    public void endTest(WebDriver driver)
    {
        System.out.println("End Test: TestCases");
        driver.quit();

    }

    
    public  void testCase01(WebDriver driver){

        try {

            System.out.println("Start Test case: testCase01");
            
            //navigate to site
            driver.get("https://www.imdb.com/chart/top/");
            
            //Find sort by dropdown
            WebElement dropdown = driver.findElement(By.id("sort-by-selector"));
            
            //Object create for select class
            Select select = new Select(dropdown);

            //Select USER_RATING
            select.selectByValue("USER_RATING");
            Thread.sleep(2000);

            System.out.println("");

            //Print the highest rated movie
            String highestRatedMovie = driver.findElement(By.xpath("//li[contains(@class,'eypSaE')][1]//h3")).getText();
            System.out.println("Highest rated movie : " + highestRatedMovie);
            System.out.println("");

            //Collect all movies in one list
            List<WebElement> movies = new ArrayList<>();
            movies = driver.findElements(By.xpath("//li[contains(@class,'eypSaE')]"));

            //Print total movies included in a table
            System.out.println("Total movies included in a table : " + movies.size());
            System.out.println("");

            //Select RELEASE_DATE
            select.selectByValue("RELEASE_DATE");
            Thread.sleep(2000);

            //Print the oldest movie
            String oldestMovie = driver.findElement(By.xpath("//li[contains(@class,'eypSaE')][250]//h3")).getText();
            System.out.println("Oldest movie : " + oldestMovie);
            System.out.println("");
             
            //Print the most recent movie
            String  mostRecentMovie = driver.findElement(By.xpath("//li[contains(@class,'eypSaE')][1]//h3")).getText();
            System.out.println("Most recent movie : " + mostRecentMovie);
            System.out.println("");

            //Select USER_RATING_COUNT
            select.selectByValue("USER_RATING_COUNT");
            Thread.sleep(2000);

            //Print most user rating movie
            String mostUserRatingMovie = driver.findElement(By.xpath("//li[contains(@class,'eypSaE')][1]//h3")).getText();
            System.out.println("Most user rating movie : " + mostUserRatingMovie);
            System.out.println("");

            System.out.println("end Test case: testCase02");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
