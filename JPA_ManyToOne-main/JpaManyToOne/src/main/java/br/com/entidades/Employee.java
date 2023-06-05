package br.com.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity /* criacao da tabela */
public class Employee implements Serializable{
	/*
	Serializable = Ela dá capacidade da classe produzir um formato em que os dados do objeto sejam usados de forma externa ao 
	código, 
	em geral ele é persistido em alguma forma de armazenamento temporário ou permanente ou é transmitido para outro recurso*/
	private static final long serialVersionUID = 1L;
	
	
   @Id /*chave primaria */
   @GeneratedValue( strategy= GenerationType.IDENTITY)  /*auto incrementa por responsabilidade do bd */
   private int eid;
   private String ename;
   private double salary;
   private String deg;
   
   @ManyToOne /*relacao muitos para um */
   private Department department;

   /*metodo construtor */
   public Employee(int eid, 
   String ename, double salary, String deg) 
   {
      super( );
      this.eid = eid;
      this.ename = ename;
      this.salary = salary;
      this.deg = deg;
   }
   public Employee( ) 
   {
      super();
   }
	//@Override
	public String toString() {
		return "Employee [id=" + eid + ", nome=" + ename + ", Salary=" + salary + ", Deg=" + deg + ", Department=" + department +"]";
	}
   public int getEid() {
	return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDeg() {
		return deg;
	}
	public void setDeg(String deg) {
		this.deg = deg;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}	
	
}
