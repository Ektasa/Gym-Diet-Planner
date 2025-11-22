package com.GymDietPlanner.controller;

import com.GymDietPlanner.Entity.Login;
import com.GymDietPlanner.Repository.WeeklyMealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private WeeklyMealPlanRepository weeklyMealPlanRepository;


//	@GetMapping("/dashboard")
//	public String index() {
//		return "index.html";
//	}
//    @GetMapping("/hom")
//    public String Loginpage(@RequestBody Login login) {
//
//        return "index.html";
//    }

	@GetMapping("/mote")
	public String mote(Model model) {
		model.addAttribute("title", "7 Days Diet Plan - Mote Log");
		if (weeklyMealPlanRepository != null) {
			model.addAttribute("plan", weeklyMealPlanRepository.findByDay("Monday"));
		} else {
			model.addAttribute("plan", getMotePlan());
		}
		return "mote";
	}

//	@GetMapping("/patle")
//	public String patle(Model model) {
//		model.addAttribute("title", "7 Days Diet Plan - Patle Log");
//		model.addAttribute("plan", getPatlePlan());
//		return "patle";
//	}

	private Map<String, String> getMotePlan() {
		Map<String, String> plan = new LinkedHashMap<>();
		plan.put("Monday", "Oats porridge, boiled egg, fruit");
		plan.put("Tuesday", "Vegetable salad, grilled chicken, brown rice");
		plan.put("Wednesday", "Smoothie (spinach+banana), quinoa salad");
		plan.put("Thursday", "Grilled fish, steamed vegetables");
		plan.put("Friday", "Yogurt with berries, mixed nuts");
		plan.put("Saturday", "Chicken soup, salad");
		plan.put("Sunday", "Light vegetable stir-fry, fruit");
		return plan;
	}

	private Map<String, String> getPatlePlan() {
		Map<String, String> plan = new LinkedHashMap<>();
		plan.put("Monday", "Full-fat milk, peanut butter sandwich, bananas");
		plan.put("Tuesday", "Avocado toast, eggs, smoothie with nut butter");
		plan.put("Wednesday", "Pasta with cheese and chicken");
		plan.put("Thursday", "Rice, lentils, paneer or tofu");
		plan.put("Friday", "Granola with yogurt, dried fruits");
		plan.put("Saturday", "Peanut butter smoothie, nuts");
		plan.put("Sunday", "Whole milk, potatoes, protein-rich meal");
		return plan;
	}

}
