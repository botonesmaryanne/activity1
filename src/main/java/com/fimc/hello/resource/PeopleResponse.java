package com.fimc.hello.resource;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleResponse {
	List<PeopleRequest> people;
}
