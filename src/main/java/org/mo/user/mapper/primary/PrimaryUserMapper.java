/** 
* @author  mo
* @date 创建时间：2017年11月25日 下午11:28:18 
* @version 1.0 
* @return  
*/

package org.mo.user.mapper.primary;

import org.mo.user.bean.User;

/** 
* @author  mo
* @date 创建时间：2017年11月25日 下午11:28:18 
* @version 1.0 
* @return  
*/
public interface PrimaryUserMapper {
	
	public User findByName(String name);
}
