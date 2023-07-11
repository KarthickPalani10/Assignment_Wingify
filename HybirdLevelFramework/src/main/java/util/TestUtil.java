package util;

import Base.TestBase;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtil extends TestBase {

   public static long PAGE_LOAD_TIMEOUT =20;
   public static long IMPLICIT_WAIT =10;

      public static void SoreList(){
         List<WebElement> elementList=driver.findElements(By.xpath(
                 "//tr/td[5]"));
         List<String> orginalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
         List<String> sortedList = orginalList.stream().sorted().collect(Collectors.toList());
         if (orginalList.equals(sortedList)){
            System.out.println("Values are sorted...");
         }
         else {
            System.out.println("Value are not sorted...");
         }
      }




}
