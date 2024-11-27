package com.example.samuraitravel.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewEditForm {
	@NotNull
	private Integer id;
	
	@NotNull
	private Integer house_id;
	
	@NotNull
	private Integer user_id;
	
	@NotNull
	@Min(value = 1 )
	private Integer score;
	
	@NotBlank
	private String review;

}
