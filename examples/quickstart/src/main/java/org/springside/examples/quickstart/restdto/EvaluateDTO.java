
package org.springside.examples.quickstart.restdto;


import org.springside.examples.quickstart.entity.TMBaseEnum;
import org.springside.modules.mapper.BeanMapper;



public class EvaluateDTO {

	
    /**  */
    private long id;
    /** 评价 */
    private String evaluate;
    /** 评分 */
    private double score;
    /** 评论分类 */
    private TMBaseEnum categoryModel;


	
    /** get  */
    public long getId(){
    	return this.id;
    }

    /** set  */
    public void setId(long id){
    	this.id = id;
    }
    
    /** get 评价 */
    public String getEvaluate(){
    	return this.evaluate;
    }

    /** set 评价 */
    public void setEvaluate(String evaluate){
    	this.evaluate = evaluate;
    }
    
    /** get 评分 */
    public double getScore(){
    	return this.score;
    }

    /** set 评分 */
    public void setScore(double score){
    	this.score = score;
    }
    
    public Long getCategoryModelId(){
    	return this.categoryModel.getId();
    }

    public BaseEnumDTO getCategoryModelDTO(){
    	return BeanMapper.map(this.categoryModel,BaseEnumDTO.class);
    }
    /** get 评论分类 */
    public TMBaseEnum getCategoryModel(){
    	return this.categoryModel;
    }

    /** set 评论分类 */
    public void setCategoryModel(TMBaseEnum categoryModel){
    	this.categoryModel = categoryModel;
    }
    


}
