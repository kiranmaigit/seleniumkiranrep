package tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"D:\\selenium\\workspace\\org.selenium.BDD\\src\\test\\resources\\features\\Feature1.feature"},
                  glue= {"gluecode"},
                  monochrome=true,
                  plugin= {"pretty","html:target\\res1","rerun:target\\failed.txt"})

public class Runner1
{

}
