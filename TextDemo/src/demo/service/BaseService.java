package demo.service;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.BaseDao;

@Service("baseservice")
public class BaseService {
	@Resource(name="basedao")
	private BaseDao baseDao;
	
	@Transactional
	public void add(Object obj){
		baseDao.add(obj);
	}
	
	@Transactional
	public void update(Object obj){
		baseDao.add(obj);
	}
	
	@Transactional
	public void del(Object obj){
		baseDao.add(obj);
	}
	
	public Object find(Class clazz,Integer id){
		return baseDao.find(clazz, id);
	}
	
	public List findAll(String hql,Object[] obj){
		return baseDao.findAll(hql, obj);
	}
}
