package com.fimc.hello.resource;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CalculatorResponse implements Serializable{
	private String action;
	private BigDecimal result;
}
