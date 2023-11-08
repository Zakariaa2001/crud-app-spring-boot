package com.getYourCouse.getYourCouse.controller;


import com.getYourCouse.getYourCouse.dto.CategoryDto;
import com.getYourCouse.getYourCouse.entities.Category;
import com.getYourCouse.getYourCouse.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class categoryController {
   private CategoryService categoryService;

   @GetMapping("/admin/categories")
   public String categories(Model model) {
       List<CategoryDto> categories = categoryService.getAllCategories();
       model.addAttribute("categories",categories);
       return "categories";
   }
    @GetMapping("/admin/addCategory")
    private String addCategory(Model model){
        model.addAttribute("category",new Category());
        return "addCategory";
    }
    @PostMapping("/admin/saveCategory")
    public String saveCategory(@Valid @ModelAttribute("Categpry") CategoryDto categoryDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "addCategory";
        categoryService.saveCategory(categoryDto);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/category/{category_id}/edit")
    public String editCategory(@PathVariable("category_id") Long categoryId , Model model) {
       CategoryDto category = categoryService.findCourseById(categoryId);
       model.addAttribute("category",category);
       return "category-edit";
    }
    @PostMapping("/admin/category/{category_id}/edit")
        public String updateCategory(@Valid @ModelAttribute("category") CategoryDto categoryDto,
                                    Model model,BindingResult bindingResult) {
            if (bindingResult.hasErrors()) return "category-edit";
            categoryService.updateCategory(categoryDto);
            return "redirect:/admin/categories";
        }

}
