package com.example.samuraitravel.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewRegisterForm {
	@NotNull(message = "評価を入力してください")
	@Min(value = 1, message = "5段階で評価を入力してください")
	@Max(value = 5, message = "5段階で評価を入力してください")
	private Integer score;
	
	@NotBlank(message = "レビューを書き込んでください")
	private String review;
		
}
