package com.fimc.hello.resource;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("/calculator")
public class CalculatorResource {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response compute(CalculatorRequest calculatorRequest) {

		String operator = calculatorRequest.getOperator();
		BigDecimal number1 = calculatorRequest.getNumber1();
		BigDecimal number2 = calculatorRequest.getNumber2();
		BigDecimal result = null;
		String typeOfOperation = new String();
		if (!StringUtils.isEmpty(operator) && !StringUtils.isEmpty(number1) && !StringUtils.isEmpty(number2)) {
			if (operator.equals("+")) {
				result = number1.add(number2);
				typeOfOperation = "addition";
			} else if (operator.equals("-")) {
				result = number1.subtract(number2);
				typeOfOperation = "subtraction";
			} else if (operator.equals("*")) {
				result = number1.multiply(number2);
				typeOfOperation = "multiplication";
			} else if (operator.equals("/")) {
				result = number1.divide(number2);
				typeOfOperation = "division";
			}
			CalculatorResponse calcuRes = new CalculatorResponse();
			calcuRes.setAction(typeOfOperation);
			calcuRes.setResult(result.setScale(5, RoundingMode.HALF_UP));
			return Response.ok().entity(calcuRes).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
