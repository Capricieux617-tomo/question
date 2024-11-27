package com.example.samuraitravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.form.ReviewEditForm;
import com.example.samuraitravel.form.ReviewRegisterForm;
import com.example.samuraitravel.repository.ReviewRepository;
import com.example.samuraitravel.service.ReviewService;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
	private final ReviewRepository reviewRepository;
	private final ReviewService reviewService;
		
	public ReviewController(ReviewRepository reviewRepository,ReviewService reviewService) {
		this.reviewRepository = reviewRepository;
		this.reviewService = reviewService;
	}
	
//	@GetMapping
//	public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id", review = Review.ASC) Pageable pageable,@RequestParam(name = "house_id",required = false) Integer house_Id) {
//		Page<Review> reviewPage;
//	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id")Integer id, Model model) {
		Review review = reviewRepository.getReferenceById(id);
		
		model.addAttribute("review", review);
		return "reviews/show";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("reviewRegisterForm", new ReviewRegisterForm());
		return "review/reviews/register";
	}
	@PostMapping("/create")
	public String create(@ModelAttribute @Validated ReviewRegisterForm reviewRegisterForm,BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "reviews/register";
		}
		
		reviewService.create(null, null, reviewRegisterForm);
		redirectAttributes.addFlashAttribute("successMessage", "レビューを登録しました。");
		
		return "retirect:/reviews";
	}
	
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable(name = "house_id") Integer id, Model model) {
		House house = houseRepository.getReferenceById(id);
		Integer score = reviews.getScore();
		ReviewEditForm reviewEditForm = new ReviewEditForm(null,house.getId(), null, reviews.getScore(),reviews.getCreatedAt,reviews.getReview());
		
		model.addAttribute("house_id", house_id);
		model.addAttribute("reviewEditForm", reviewEditForm);
		
		return "reviews/edit";
		
	}
	
	@PostMapping("/{id}/update")
	public String update(@ModelAttribute @Validated ReviewEditForm reviewEditForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindResult.hasErrors()) {
			return "reviews/edit";
		}
		reviewService.update(reviewEditForm);
		redirectAttributes.addFlashAttribute("successMessage", "レビューを更新しました。");
		
		return "redirect:/reviews";
		
	}
		
}
