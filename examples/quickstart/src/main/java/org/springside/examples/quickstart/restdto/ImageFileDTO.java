
package org.springside.examples.quickstart.restdto;

import java.util.Date;
import org.springside.examples.quickstart.entity.TMBaseEnum;
import org.springside.modules.utils.Collections3;
import org.springside.modules.mapper.BeanMapper;



public class ImageFileDTO {

	
    /**  */
    private long id;
    /** 文件名称 */
    private String fileName;
    /** 文件url */
    private String fileUrl;


	
    /** get  */
    public long getId(){
    	return this.id;
    }

    /** set  */
    public void setId(long id){
    	this.id = id;
    }
    
    /** get 文件名称 */
    public String getFileName(){
    	return this.fileName;
    }

    /** set 文件名称 */
    public void setFileName(String fileName){
    	this.fileName = fileName;
    }
    
    /** get 文件url */
    public String getFileUrl(){
    	return this.fileUrl;
    }

    /** set 文件url */
    public void setFileUrl(String fileUrl){
    	this.fileUrl = fileUrl;
    }
    


}
