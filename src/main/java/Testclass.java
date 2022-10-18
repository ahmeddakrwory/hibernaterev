

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import test.hiber.nate.entity.Employee;
import test.hiber.nate.entity.HibernateUtil;

public class Testclass {
	HibernateUtil hibernateUtil=new HibernateUtil();
	 Session  session= hibernateUtil.getSession();
	@SuppressWarnings("unchecked")
	 public static void main(String[] args) {
		Testclass testclass =new Testclass();
          String  quiry1 = "select * from Departments where in() ";
          List<String>  param=null;
//          param.add("and id=102 ");
//          param.add("and first_name = 'Lex'");
//          List<Object[]> lists= testclass.excuesql(quiry1, param);

List<Object[]>datas=testclass.testsuperwirnges();
	
	}
static List<Object[]> excuesql(String quiry,List<String> param){
	
	Testclass testclass =new Testclass();
	 Query      query = testclass.session.createSQLQuery(quiry+param);
	            // param = and id=100 and name = ahmed
     List<Object[]> rows = query.list();
     System.out.println(rows.size());
     for (Object[] object : rows) {
		System.out.println(object[0]+" "+object[1]);	
	}
     return rows;
}
public static List<?> convertObjectToList(Object obj) {
    List<?> list = new ArrayList<>();
    if (obj.getClass().isArray()) {
        list = Arrays.asList((Object[])obj);
    } else if (obj instanceof Collection) {
        list = new ArrayList<>((Collection<?>)obj);
    }
    return list;
}
@SuppressWarnings("unchecked")
public List<Object[]> testsuperwirnges(){
	Testclass testclass=new Testclass(); 
	String ids="Steven,Neena";         
	 StringBuilder builder=new StringBuilder(ids);
	  String[] ides = ids.split(",");
	  String jpql = " FROM Employee WHERE firstName IN (:ids)";
	  List<Object[]>  data=null; 
	try {
		Query q= testclass.session.createQuery(jpql);
	 q.setParameterList("ids",ides );
	   data= q.getResultList();
	 for (Object[] objects : data) {
		String o= objects[1];
	}
	 
	//for (Employee e : data) {
//		System.out.print("s +  "+e.getEmail());

	//for (int i=0;i<data.size();i++) {
	//Object[]data2=data.get(i);
	//
	//List Row= convertObjectToList(data2[0]);
	//System.out.print("System ="+Row);
	//
	//
	//	
	//}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return data;
}
}
