package com.spring.app.utilities;

public class MyValidationUtils {
/*
	protected boolean checkMandatorySelectField(AbstractSelect field, String messageKey) {
		boolean isValid = true;
		if (field.getValue() == null) {
			//this.errors.add(I18N.message("field.required.1", new String[] { I18N.message(messageKey) }));
			isValid = false;
		}
		return isValid;
	}

	protected boolean checkMandatoryField(AbstractTextField field, String messageKey) {
		boolean isValid = true;
		if (StringUtils.isEmpty((String) field.getValue())) {
			//this.errors.add(I18N.message("field.required.1", new String[] { I18N.message(messageKey) }));
			isValid = false;
		}
		return isValid;
	}

	protected boolean checkMandatoryField(MaskedField field, String messageKey) {
		boolean isValid = true;
		if (StringUtils.isEmpty(field.getValue())) {
			//this.errors.add(I18N.message("field.required.1", new String[] { I18N.message(messageKey) }));
			isValid = false;
		}
		return isValid;
	}

	protected boolean checkMandatoryDateField(DateField field, String messageKey) {
		boolean isValid = true;
		if (field.getValue() == null) {
			//this.errors.add(I18N.message("field.required.1", new String[] { I18N.message(messageKey) }));
			isValid = false;
		}
		return isValid;
	}

	protected boolean checkMaxLengthField(AbstractTextField field, String messageKey, int maxLength) {
		boolean isValid = true;
		if ((StringUtils.isNotEmpty((String) field.getValue())) && (((String) field.getValue()).length() < maxLength)) {
			//this.errors.add(I18N.message("field.max.length.incorrect", new String[] { I18N.message(messageKey), String.valueOf(maxLength) }));
			isValid = false;
		}
		return isValid;
	}

	protected boolean checkDuplicatedCode(Class entityClass, AbstractTextField field, Long exceptedId, String messageKey) {
		boolean isFound = ControlUtils.checkDuplicatedCode(entityClass, field, exceptedId, messageKey);
		if (isFound) {
			//this.errors.add(I18N.message("field.already.exists.1", new String[] { I18N.message(messageKey) }));
		}
		return isFound;
	}

	protected boolean checkDuplicatedField(Class entityClass, String fieldName, AbstractTextField field, Long exceptedId, String messageKey) {
		boolean isFound = ControlUtils.checkDuplicatedField(entityClass, fieldName, field, exceptedId, messageKey);
		if (isFound) {
			//this.errors.add(I18N.message("field.already.exists.1", new String[] { I18N.message(messageKey) }));
		}
		return isFound;
	}

	protected boolean checkRangeDateField(DateField start, DateField end) {
		boolean isValid = ControlUtils.checkRangeDateField(start, end);
		if (!(isValid)) {
			//this.errors.add(I18N.message("field.range.date.incorrect"));
		}
		return isValid;
	}

	protected boolean checkFloatField(AbstractTextField field, String messageKey) {
		boolean isValid = ControlUtils.checkFloatField(field);
		if (!(isValid)) {
			//this.errors.add(I18N.message("field.value.incorrect.1"));
		}
		return isValid;
	}

	protected boolean checkDoubleField(AbstractTextField field, String messageKey) {
		boolean isValid = true;
		if (StringUtils.isNotEmpty((String) field.getValue())) {
			try {
				Double.parseDouble((String) field.getValue());
			} catch (Exception e) {
				//this.errors.add(I18N.message("field.value.incorrect.1", new String[] { I18N.message(messageKey) }));
			}
		}
		return isValid;
	}

	public boolean checkBigDecimalField(AbstractTextField field, String messageKey) {
		boolean isValid = true;
		if (StringUtils.isNotEmpty((String) field.getValue())) {
			try {
				new BigDecimal((String) field.getValue());
			} catch (NumberFormatException e) {
				//this.errors.add(I18N.message("field.value.incorrect.1", new String[] { I18N.message(messageKey) }));
				isValid = false;
			}
		}
		return isValid;
	}

	protected boolean checkIntegerField(AbstractTextField field, String messageKey) {
		boolean isValid = true;
		if (StringUtils.isNotEmpty((String) field.getValue())) {
			try {
				Integer.parseInt((String) field.getValue());
			} catch (Exception e) {
				//this.errors.add(I18N.message("field.value.incorrect.1", new String[] { I18N.message(messageKey) }));
			}
		}
		return isValid;
	}

	protected boolean checkLongField(AbstractTextField field, String messageKay) {
		boolean isValid = true;
		if (StringUtils.isNotEmpty((String) field.getValue())) {
			try {
				Long.parseLong((String) field.getValue());
			} catch (Exception e) {
				//this.errors.add(I18N.message("field.value.incorrect.1", new String[] { I18N.message(messageKay) }));
			}
		}
		return isValid;
	}

	protected boolean checkBooleanField(AbstractTextField field, String messageKey) {
		boolean isValid = true;
		if (StringUtils.isNotEmpty((String) field.getValue())) {
			try {
				Boolean.parseBoolean((String) field.getValue());
			} catch (Exception e) {
				//this.errors.add(I18N.message("field.value.incorrect.1", new String[] { I18N.message(messageKey) }));
			}
		}
		return isValid;
	}

	protected boolean checkDateField(AbstractTextField field, String messageKey) {
		boolean isValid = true;
		if (StringUtils.isNotEmpty((String) field.getValue())) {
			try {
				DateUtils.string2DateDDMMYYYY((String) field.getValue());
			} catch (Exception e) {
				//this.errors.add(I18N.message("field.value.incorrect.1", new String[] { I18N.message(messageKey) }));
			}
		}
		return isValid;
	}*/

}
