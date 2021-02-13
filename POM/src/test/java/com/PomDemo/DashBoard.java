package com.PomDemo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
WebDriver driver;
	
	public  DashBoard(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//h3")
	private List<WebElement> courses;
	
	
	public void getCourses() {
		for(WebElement course : courses) {
			System.out.println(course.getText());
		}
	}
}
