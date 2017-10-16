import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.xpath.internal.operations.Or;

import demo.bean.Org;
import demo.bean.Teachers;
import demo.service.BaseService;

public class main {

	public static void main(String[] args) {
		ApplicationContext applic=new ClassPathXmlApplicationContext("/app-core.xml");
		BaseService bs=(BaseService)applic.getBean("baseservice");
		
		Org org=(Org) bs.find(Org.class,2);
//		
//		Org o=new Org();
//		o.setOrg_name("组织1");
//		o.setO(org);
//		
//		bs.add(o);
		
		Teachers t=new Teachers();
		t.setEmp_no("1001");
		t.setName("李四");
		t.setSex("男");
		t.setDegree("高中");
		t.setUpdate_date(new Date(117,8,1));
		t.setOrg(org);
		org.getSet().add(t);
		bs.add(org);
	}

}
