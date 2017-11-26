/** 
* @author  mo
* @date 创建时间：2017年11月26日 上午12:05:04 
* @version 1.0 
* @return  
*/

package org.mo.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/** 
* @author  mo
* @date 创建时间：2017年11月26日 上午12:05:04 
* @version 1.0 
* @return  
*/
@Component
public class Task {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Scheduled(cron="*/3 * * * * *")
	public void reportCurrentTime(){
		System.out.println("-------------------------------------");
		logger.info("======================");
	}
}
