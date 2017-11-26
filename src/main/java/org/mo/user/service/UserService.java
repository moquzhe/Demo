/** 
* @author  mo
* @date 创建时间：2017年11月25日 下午11:30:04 
* @version 1.0 
* @return  
*/

package org.mo.user.service;

import org.mo.user.bean.User;

/** 
* @author  mo
* @date 创建时间：2017年11月25日 下午11:30:04 
* @version 1.0 
* @return  
*/
public interface UserService {
	
	public User findByName(String name);
	
}
