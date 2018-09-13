package com.fimc.hello.resource;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@EqualsAndHashCode
public class CalculatorRequest implements Serializable {
	private  String operator;
	private  BigDecimal number1;
	private  BigDecimal number2;

	
}
