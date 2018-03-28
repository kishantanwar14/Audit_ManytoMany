package mpack;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name= "did")
	private int Did;
	
	@Column(name= "dname")
	private String Dname;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "created_on")
	 
	private Date createdOn;
	
	
	@ManyToMany(mappedBy= "department")
	private List<Employee> employee ;		// Referenece of Employee Class
	
	public int getDid() {
		return Did;
	}
	public void setDid(int did) {
		Did = did;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	
	
	public Date getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Department(int did, String dname, Date createdOn, List<Employee> employee) {
		super();
		Did = did;
		Dname = dname;
		this.createdOn = createdOn;
		this.employee = employee;
	}
	
	
}