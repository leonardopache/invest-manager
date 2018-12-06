/**
 * 
 */
package com.pache.investments.server.springboot.model.personal;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.pache.investments.server.springboot.model.financemarket.Index;
import com.pache.investments.server.springboot.model.financemarket.ResourceType;

/**
 * @author lpache
 *
 */
public class Investments {

	@Id
	private ObjectId _id;
	private String name;
	private BigDecimal amountInvested;
	private BigDecimal amountActual;
	private LocalDate beginDate;
	private LocalDate endDate;
	private Users user;
	private ResourceType resourceType;
	private Index index;

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmountInvested() {
		return amountInvested;
	}

	public void setAmountInvested(BigDecimal amountInvested) {
		this.amountInvested = amountInvested;
	}

	public BigDecimal getAmountActual() {
		return amountActual;
	}

	public void setAmountActual(BigDecimal amountActual) {
		this.amountActual = amountActual;
	}

	public LocalDate getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public Index getIndex() {
		return index;
	}

	public void setIndex(Index index) {
		this.index = index;
	}

}
