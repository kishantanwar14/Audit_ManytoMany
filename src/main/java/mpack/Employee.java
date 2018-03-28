package mpack;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name="employee")

public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name= "eid")
	private int Eid;
	
	@Column(name = "ename")
	private String Ename;
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	private Date createdOn;

	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name="department_employee", 
			joinColumns= {@JoinColumn(name="eid")},
			inverseJoinColumns= { @JoinColumn(name="did")})	
	
	
	private List<Department> department;		//Reference of Department Class
	
	
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	
	public List<Department> getDepartment() {
		return department;
	}
	public void setDepartment(List<Department> department) {
		this.department = department;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int eid, String ename, Date createdOn, List<Department> department) {
		super();
		Eid = eid;
		Ename = ename;
		this.createdOn = createdOn;
		this.department = department;
	}
}