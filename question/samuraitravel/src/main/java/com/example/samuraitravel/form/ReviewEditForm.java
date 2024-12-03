package com.example.samuraitravel.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewEditForm {
	@NotNull
	private Integer id;
	
	@NotNull
	private Integer userId;
	
	@NotNull
	private Integer houseId;
	
	@NotNull
	@Min(value = 1 )
	private Integer score;   //星は1以上つけてもらいたい
	
	@NotNull
	private String CreatedAt;
	
	@NotBlank
	private String content;

}
