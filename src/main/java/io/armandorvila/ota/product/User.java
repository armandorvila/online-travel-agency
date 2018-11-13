package io.armandorvila.ota.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class User {

	@Getter
	private Long id;

	@Getter
	private String name;
}
