package com.Safari.Safari.controller;

import com.Safari.Safari.model.Safari;
import com.Safari.Safari.service.StafariService;
import com.Safari.Safari.service.StafariServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SafariController {

    //@Autowired
    private StafariServiceImpl stafariService;

    public SafariController(StafariServiceImpl stafariService) {
        this.stafariService = stafariService;
    }

    @GetMapping("/list")
    public String viewListPage(Model model){
//        model.addAttribute("listStudents", stafariService.getAllStudents());
//        return "list";
        return  findPaginated(1,"names", "asc", model);
    }

        @GetMapping("/showTripForm")
    public String showStudentForm(Model model){
        Safari safari = new Safari();
        model.addAttribute("safari", safari);
        return "new_trip";
    }
    @PostMapping("/saveTrip")
    public String saveTrip(@ModelAttribute("safari") @Valid Safari safari, BindingResult result) {
        if (result.hasErrors()) {
            // If there are validation errors, return to the form with error messages
            return "new_trip";
        }

        stafariService.saveTrip(safari);
        return "redirect:/list";
    }

    @GetMapping("/showTripUpdateForm/{id}")
    public String showFormUpdate(@PathVariable(value = "id")long id, Model model){
        Safari safari = stafariService.getTripById(id);
        model.addAttribute("safari", safari);
        return "update_trip";
    }

    @GetMapping("/deleteTrip/{id}")
    public String deleteStudent(@PathVariable(value = "id")long id){
        this.stafariService.deleteTrip(id);
        return "redirect:/list";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,  Model model){
        int pageSize = 5;
        Page<Safari> page = stafariService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Safari> listSafaris = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listSafaris", listSafaris);
        return "list";
    }
}
