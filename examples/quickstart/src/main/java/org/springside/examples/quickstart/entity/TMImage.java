package org.springside.examples.quickstart.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author frankswu
 *
 */
@Entity
@Table(name = "tb_file_store")
@DiscriminatorValue("image")
public class TMImage extends TMFileStore {

}
