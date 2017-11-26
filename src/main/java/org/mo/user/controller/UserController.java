/** 
* @author  mo
* @date 创建时间：2017年11月25日 下午11:33:42 
* @version 1.0 
* @return  
*/

package org.mo.user.controller;

import org.mo.user.bean.User;
import org.mo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @author  mo
* @date 创建时间：2017年11月25日 下午11:33:42 
* @version 1.0 
* @return  
*/
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	@Qualifier("primaryUserService")
	private UserService primaryUserService;
	
	@Autowired
	@Qualifier("secondaryUserService")
	private UserService secondaryUserService;
	
	@RequestMapping("/findByName")	
	public String findByName(String name){
		 User user1 = primaryUserService.findByName(name);
		 User user2 = secondaryUserService.findByName(name);
		 return user1.toString() + user2.toString();
	}
}
