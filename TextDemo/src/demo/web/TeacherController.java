
package demo.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import demo.bean.Org;
import demo.bean.Teachers;
import demo.service.BaseService;

@Controller
public class TeacherController {
	@Resource(name="baseservice")
	private BaseService bs;
	
	@RequestMapping(value="/s",method=RequestMethod.GET)
	public ModelAndView s(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("add");
		return mav;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Teachers t){
		Org org = (Org) bs.find(Org.class, t.getOrg_id());
		t.setOrg(org);
		t.setUpdate_date(new Date());
		System.out.println("ÃÌº”£∫"+t);
		bs.add(t);
		return "redirect:/s.sw";
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(@RequestParam(name="name")String name,@RequestParam(name="id")Integer id){
		List<Object> list=new ArrayList<Object>();
		String hql="select t from Teachers t where 1=1 ";
		System.out.println(name+","+id);
		if(name!=null && !name.equals("")){
			hql+=" and t.name like ?";
			list.add("%"+name+"%");
		}
		if(id!=null&& !id.equals("")&& id!= 0){
			hql+=" and t.org_id=?";
			list.add(id);
		}
		hql+=" ORDER BY t.update_date DESC";
		System.out.println("hql”Ôæ‰£∫"+hql);
		return bs.findAll(hql,list.toArray());
	}
	
	@RequestMapping(value="/list2")
	@ResponseBody
	public Object list2(){
		System.out.println("≤ø√≈£∫"+bs.findAll("from Org",null));
		return bs.findAll("from Org",null);
	}

}
