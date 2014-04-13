
package org.springside.examples.quickstart.restdto;

import java.util.Date;
import org.springside.examples.quickstart.entity.TMBaseEnum;
import org.springside.modules.utils.Collections3;
import org.springside.modules.mapper.BeanMapper;



public class BaseCityDTO {

	
    /**  */
    private long id;
    /** 城市名称 */
    private String cityName;
    /** 城市类型 */
    private String cityType;


	
    /** get  */
    public long getId(){
    	return this.id;
    }

    /** set  */
    public void setId(long id){
    	this.id = id;
    }
    
    /** get 城市名称 */
    public String getCityName(){
    	return this.cityName;
    }

    /** set 城市名称 */
    public void setCityName(String cityName){
    	this.cityName = cityName;
    }
    
    /** get 城市类型 */
    public String getCityType(){
    	return this.cityType;
    }

    /** set 城市类型 */
    public void setCityType(String cityType){
    	this.cityType = cityType;
    }
    


}
