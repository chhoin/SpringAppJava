package com.spring.app.utilities;

public class Amount {
	private Double tiAmount;
	private Double vatAmount;
	private Double teAmount;
	private int nbDecimal;

	public Amount() {
		this.nbDecimal = 2;
	}

	public Amount(Double teAmount, Double vatAmount, Double tiAmount) {
		this(teAmount, vatAmount, tiAmount, 2);
	}

	public Amount(Double teAmount, Double vatAmount, Double tiAmount, int nbDecimal) {
		this.nbDecimal = 2;

		this.nbDecimal = nbDecimal;
		this.teAmount = Double.valueOf(MyMathUtils.roundTo(teAmount.doubleValue(), nbDecimal));
		this.vatAmount = Double.valueOf(MyMathUtils.roundTo(vatAmount.doubleValue(), nbDecimal));
		this.tiAmount = Double.valueOf(MyMathUtils.roundTo(tiAmount.doubleValue(), nbDecimal));
	}

	public Double getTiAmount() {
		return this.tiAmount;
	}

	public void setTiAmount(Double tiAmount) {
		this.tiAmount = tiAmount;
	}

	public Double getVatAmount() {
		return this.vatAmount;
	}

	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public Double getTeAmount() {
		return this.teAmount;
	}

	public void setTeAmount(Double teAmount) {
		this.teAmount = teAmount;
	}

	public void plusTiAmount(Double tiAmount) {
		if (tiAmount != null)
			this.tiAmount = Double.valueOf(MyNumberUtils.getDouble(this.tiAmount) + MyNumberUtils.getDouble(tiAmount));
	}

	public void minusTiAmount(Double tiAmount) {
		if (tiAmount != null)
			this.tiAmount = Double.valueOf(MyNumberUtils.getDouble(this.tiAmount) - MyNumberUtils.getDouble(tiAmount));
	}

	public void plusTeAmount(Double teAmount) {
		if (teAmount != null)
			this.teAmount = Double.valueOf(MyNumberUtils.getDouble(this.teAmount) + MyNumberUtils.getDouble(teAmount));
	}

	public void minusTeAmount(Double teAmount) {
		if (teAmount != null)
			this.teAmount = Double.valueOf(MyNumberUtils.getDouble(this.teAmount) - MyNumberUtils.getDouble(teAmount));
	}

	public void plusVatAmount(Double vatAmount) {
		if (vatAmount != null)
			this.vatAmount = Double.valueOf(MyNumberUtils.getDouble(this.vatAmount) + MyNumberUtils.getDouble(vatAmount));
	}

	public void minusVatAmount(Double vatAmount) {
		if (vatAmount != null)
			this.vatAmount = Double.valueOf(MyNumberUtils.getDouble(this.vatAmount) - MyNumberUtils.getDouble(vatAmount));
	}

	public int getNbDecimal() {
		return this.nbDecimal;
	}

	public void setNbDecimal(int nbDecimal) {
		this.nbDecimal = nbDecimal;
	}

	public void plus(Amount amount) {
		plusTeAmount(amount.getTeAmount());
		plusVatAmount(amount.getVatAmount());
		plusTiAmount(amount.getTiAmount());
	}

	public void minus(Amount amount) {
		minusTeAmount(amount.getTeAmount());
		minusVatAmount(amount.getVatAmount());
		minusTiAmount(amount.getTiAmount());
	}
}
