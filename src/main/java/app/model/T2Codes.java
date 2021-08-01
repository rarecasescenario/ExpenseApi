package app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(property = "Code", generator = ObjectIdGenerators.PropertyGenerator.class)
@Entity
@Table(name = "T2_CODES")
public class T2Codes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("Code")
	@Id
	@Column(name = "CODE")
	private Integer code;
	
	@JsonProperty("CodeDescription")
	@Column(name = "CODE_DESCRIPTION")
	private String codeDescription;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getCodeDescription() {
		return codeDescription;
	}
	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}
	
	
}
