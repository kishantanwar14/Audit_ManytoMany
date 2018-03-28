package mpack;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MToMmain 
{
	public static void main(String[] args) 
	{
		create();
		//update();
	    //delete();
	}
	
	    public static void create()
	    {
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("auditManytoMany");
			EntityManager em = emf.createEntityManager();
			System.out.println("-----------Insertion in Database---------");
			em.getTransaction().begin();
						
			Employee e1 = new Employee();
	        e1.setEname("Aman");
	        e1.setCreatedOn(new Date());
	        
	        Employee e2 = new Employee();
	        e2.setEname("Atul");
	        e2.setCreatedOn(new Date());
	        
	        
	        Department d1 = new Department();
	        d1.setDname("IT");
	        d1.setCreatedOn(new Date());
	      	        
	        Department d2 = new Department();
	        d2.setDname("Account");
	        d2.setCreatedOn(new Date());
	      
	        
	        List<Employee> empList = new ArrayList<Employee>();
	        empList.add(e1);
	        empList.add(e2);
	        
			List<Department> deptList = new ArrayList<Department>();
		    deptList.add(d1);
		    deptList.add(d2);	
	   
	        
	        d1.setEmployee(empList);
	        d2.setEmployee(empList);
	       
	        e1.setDepartment(deptList);
	        e2.setDepartment(deptList);
	        
	        em.persist(e1);
		    em.persist(e2);
		    em.persist(d1);
		    em.persist(d2);
	        
	        em.getTransaction().commit();
			em.close();			
			emf.close() ;
	    }
	    
	  
	    public static void update() 
	    {
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("auditManytoMany");
			EntityManager em = emf.createEntityManager();
			System.out.println("-----------Starting updation in Database---------");
			em.getTransaction().begin();
			
			Employee e1 = em.find(Employee.class, 2);
			e1.setEname("Rahul");
			e1.setCreatedOn(new Date()); 
			
			/* String hql = "update Department d set d.departName=:dname where d.ID=2";
			Query query = em.createQuery(hql);
			query.setParameter("dname","Accounts modified");
			em.persist(updateCount);
			query.executeUpdate();*/
			
			Department dept = em.find(Department.class, 1);
			dept.setDname(" Business ");
			dept.setCreatedOn(new Date()); 
			
			
			em.getTransaction().commit();
			em.close();
			emf.close();
	    }
	    
	    
	   public static void delete()
	   {
		   	EntityManagerFactory emf = Persistence.createEntityManagerFactory("auditManytoMany");
			EntityManager em = emf.createEntityManager();
			System.out.println("-----------Starting deletion in Database---------");
			em.getTransaction().begin();
			
			Employee empdel = em.find(Employee.class, 2);
			em.remove(empdel);
			
			/*em.getTransaction().begin();
			Query query=em.createQuery("delete from Employee e where e.id=1");  
			query.executeUpdate(); */
			
			
			empdel.setCreatedOn(new Date());
			em.getTransaction().commit();
			em.close();
		    emf.close();
	   }
}


