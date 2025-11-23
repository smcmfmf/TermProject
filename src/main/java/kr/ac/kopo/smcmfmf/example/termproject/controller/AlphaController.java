package kr.ac.kopo.smcmfmf.example.termproject.controller;

import kr.ac.kopo.smcmfmf.example.termproject.domain.Purchase;
import kr.ac.kopo.smcmfmf.example.termproject.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlphaController {

    @Autowired
    private PurchaseRepository purchaseRepository; // Repository 주입

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String requestMethod() { return "alpha"; }

    @GetMapping("/alpha1") public String alpha1() { return "alpha1"; }
    @GetMapping("/alpha2") public String alpha2() { return "alpha2"; }
    @GetMapping("/alpha3") public String alpha3() { return "alpha3"; }

    @PostMapping("/alpha4")
    public String showAlpha4(@RequestParam String car, @RequestParam String color, @RequestParam String why, @RequestParam String date, Model model) {
        model.addAttribute("car", car);
        model.addAttribute("color", color);
        model.addAttribute("why", why);
        model.addAttribute("date", date);
        return "alpha4";
    }

    @PostMapping("/order/save")
    public String saveOrder(Purchase purchase) {
        purchaseRepository.save(purchase);
        return "redirect:/alpha5";
    }

    @GetMapping("/alpha5")
    public String alpha5() {
        return "alpha5";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // ================= 관리자 모드 =================

    // 1. 목록 조회
    @GetMapping("/admin/list")
    public String adminList(Model model) {
        List<Purchase> list = purchaseRepository.findAll();
        model.addAttribute("list", list);
        return "admin"; // admin.html
    }

    // 2. 삭제
    @GetMapping("/admin/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        purchaseRepository.deleteById(id);
        return "redirect:/admin/list";
    }

    // 3. 수정 페이지 이동
    @GetMapping("/admin/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Purchase purchase = purchaseRepository.findById(id).orElse(null);
        model.addAttribute("item", purchase);
        return "admin_update"; // admin_update.html
    }

    // 4. 수정 처리
    @PostMapping("/admin/update")
    public String updateOrder(Purchase purchase) {
        purchaseRepository.save(purchase); // id가 있으면 update 수행
        return "redirect:/admin/list";
    }
}