/** 
* @author  mo
* @date 创建时间：2017年11月25日 下午11:31:57 
* @version 1.0 
* @return  
*/

package org.mo.user.service.impl;

import org.mo.user.bean.User;
import org.mo.user.mapper.primary.PrimaryUserMapper;
import org.mo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
* @author  mo
* @date 创建时间：2017年11月25日 下午11:31:57 
* @version 1.0 
* @return  
*/
@Service("primaryUserService")
public class PrimaryUserServiceImpl implements UserService{

	@Autowired
	private PrimaryUserMapper primaryUserMapper;
	
	@Override
	public User findByName(String name) {
		return primaryUserMapper.findByName(name);
	}

}
