package com.example.demo;

import java.util.Date;

/**
 * Person类就是一个简单的JavaBean
 * @author Administrator
 *
 */
public class Person {
	private String name;
	private String sex;
	private int age;
	private boolean married;
	private Date birthday;
	private int num = 10;
	
	public Person(){
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public void setNum(int n){
		this.num = n;
	}
	public int getNum(){
		return num;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
