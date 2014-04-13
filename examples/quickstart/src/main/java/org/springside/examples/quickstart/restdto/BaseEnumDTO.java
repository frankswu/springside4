
package org.springside.examples.quickstart.restdto;

import java.util.Date;
import org.springside.examples.quickstart.entity.TMBaseEnum;
import org.springside.modules.utils.Collections3;
import org.springside.modules.mapper.BeanMapper;



public class BaseEnumDTO {

	
    /**  */
    private long id;
    /** 基础枚举类型 */
    private String enumType;
    /** 枚举值 */
    private String enumValue;
    /** 枚举值描述 */
    private String enumDesc;


	
    /** get  */
    public long getId(){
    	return this.id;
    }

    /** set  */
    public void setId(long id){
    	this.id = id;
    }
    
    /** get 基础枚举类型 */
    public String getEnumType(){
    	return this.enumType;
    }

    /** set 基础枚举类型 */
    public void setEnumType(String enumType){
    	this.enumType = enumType;
    }
    
    /** get 枚举值 */
    public String getEnumValue(){
    	return this.enumValue;
    }

    /** set 枚举值 */
    public void setEnumValue(String enumValue){
    	this.enumValue = enumValue;
    }
    
    /** get 枚举值描述 */
    public String getEnumDesc(){
    	return this.enumDesc;
    }

    /** set 枚举值描述 */
    public void setEnumDesc(String enumDesc){
    	this.enumDesc = enumDesc;
    }
    


}
