package com.zhangziqi;

import com.zhangziqi.dao.CourseMapper;
import com.zhangziqi.dao.StudentCourseMapper;
import com.zhangziqi.dao.StudentMapper;
import com.zhangziqi.entity.Student;
import com.zhangziqi.entity.StudentCourseKey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Alert;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class ZhangziqiApplicationTests {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentCourseMapper studentCourseMapper;
    @Autowired
    CourseMapper courseMapper;

    @Test
    void contextLoads() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8085/Login");
        /*driver.findElement(By.id("name")).sendKeys("root");
        driver.findElement(By.id("pwd")).sendKeys("root");
        driver.findElement(By.id("btn")).submit();*/
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("root");
        driver.findElement(By.id("pwd")).click();
        driver.findElement(By.id("pwd")).sendKeys("root");
        driver.findElement(By.id("btn")).click();
        driver.findElement(By.linkText("学生管理")).click();
        String name="测试";
        String grade="2021";
        String profession="测试专业";
        String gender;
        LinkedList<Student> students = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            gender=i%2==0?"男":"女";
            students.add(new Student(name+i,grade,profession+i,gender));
        }
        for (Student student : students) {
            driver.findElement(By.linkText("add")).click();
            driver.findElement(By.id("name")).click();
            driver.findElement(By.id("name")).sendKeys(student.getName());
            driver.findElement(By.id("grade")).click();
            driver.findElement(By.id("grade")).sendKeys(student.getGrade());
            driver.findElement(By.id("profession")).click();
            driver.findElement(By.id("profession")).sendKeys(student.getProfession());
            if(student.getGender().equals("男"))driver.findElement(By.cssSelector("label:nth-child(2) > .form-control")).click();
            else driver.findElement(By.cssSelector("label:nth-child(1) > .form-control")).click();
            driver.findElement(By.cssSelector(".btn")).click();
            assertThat(driver.switchTo().alert().getText(), is("add confirm?"));
            driver.switchTo().alert().accept();

        }
        /*driver.findElement(By.linkText("add")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("UserTest1");
        driver.findElement(By.id("grade")).click();
        driver.findElement(By.id("grade")).sendKeys("2021");
        driver.findElement(By.name("gender")).click();
        driver.findElement(By.id("profession")).click();
        driver.findElement(By.id("profession")).sendKeys("测试1");
        driver.findElement(By.cssSelector(".btn")).click();
        assertThat(driver.switchTo().alert().getText(), is("add confirm?"));
        driver.switchTo().alert().accept();*/

    }

}
