package com.spring.app.utilities;

import java.util.Date;

/**
 * 
 * @author kimchhoin.sok
 *
 */
public class DateRange {
	private Date creationDate;
	private Date expirationDate;

	public DateRange(Date creationDate, Date expirationDate) {
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
