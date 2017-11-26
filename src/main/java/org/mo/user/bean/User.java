/** 
* @author  mo
* @date 创建时间：2017年11月25日 下午11:25:07 
* @version 1.0 
* @return  
*/

package org.mo.user.bean;

/** 
* @author  mo
* @date 创建时间：2017年11月25日 下午11:25:07 
* @version 1.0 
* @return  
*/
public class User {
	private Integer id;
	private String name;
	private Integer age;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
