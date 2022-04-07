package com.revature.pms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PokeBox")
public class PokeBox {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "boxnumber")
	private Integer boxNumber;
	@Column(name="tableid")
	private Integer tableId;
	
	
	public Integer getBoxNumber() {
		return boxNumber;
	}
	public void setBoxNumber(Integer boxNumber) {
		this.boxNumber = boxNumber;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
}