package demo.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="org")
public class Org {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String org_name;
	
	@Column(insertable=false,updatable=false)
	private Integer parent_id;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Org o;
	
	@OneToMany(mappedBy="org",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Teachers> set=new HashSet<Teachers>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Org getO() {
		return o;
	}

	public void setO(Org o) {
		this.o = o;
	}

	public Set<Teachers> getSet() {
		return set;
	}

	public void setSet(Set<Teachers> set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "Org [id=" + id + ", org_name=" + org_name + ", parent_id=" + parent_id + ", o=" + o + "]";
	}
	
	
}
