package main.domain.account;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class CPF {
	public static final CPF EMPTY = new CPF("000000000-00");
	private String value;
	private boolean parsed;
	
	public CPF(String value){
		try {
			if(value == null) throw new NullPointerException();
			String trimedValue = value.trim();
			if(trimedValue.length() != 12) throw new CPFFormatException();
			this.value = new MaskFormatter("#########-##").valueToString(trimedValue);
			parsed = true;
		} catch (ParseException | NullPointerException | CPFFormatException ignored) {
			this.value = "000000000-00";
			parsed = false;
		}
	}

	public String toString(){
		return value;
	}
	public boolean isValid() {
		return parsed && isNotAllDigitsTheSame() && isValidCPF();
	}
	
	private boolean isNotAllDigitsTheSame() {
		String cpf = value.substring(0,9);
		char first = cpf.charAt(0);
		for(int i = 0; i < cpf.length(); i++){
			if(first != cpf.charAt(i))
				return true;
		}
		return false;
	}

	private boolean isValidCPF() {		
		String cpf = value.substring(0,9);		
		cpf = cpf.concat(makeVerifyingDigit(cpf));
		cpf = cpf.concat(makeVerifyingDigit(cpf));
		cpf = cpf.substring(0,9).concat("-").concat(cpf.substring(9));
		
		return cpf.equals(value);
	}

	private String makeVerifyingDigit(String digits) {
		int sum = 0;
		for(int i = 0, j = digits.length()+1; i< digits.length(); i++, j--){
			sum += Character.getNumericValue(digits.charAt(i)) * j;
		}
		int mod = (sum*10)%11;
		if(mod == 10)
			return "0";
		return String.valueOf(mod);
	}

	public boolean equals(Object other){
		return this.getClass().isInstance(other) && equalsValue((CPF) other);
	}

	private boolean equalsValue(CPF other) {
		return value.equals(other.value);
	}
	
	private class CPFFormatException extends RuntimeException{
		private static final long serialVersionUID = 1L;
	}
}
