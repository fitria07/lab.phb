/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.phb.suratkeluarwebapp.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import lab.phb.suratkeluarwebapp.entity.Keluar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import lab.phb.suratkeluarwebapp.repo.KeluarRepo;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author user
 */
@Controller
public class AppController {
    
    @Autowired
    private KeluarRepo klrRepo;
    
    @RequestMapping("/home")
    public void index() {}
    
    @RequestMapping("/daftar-suratkeluar")
    public void getDaftarMahasiswa(Model model) {
        model.addAttribute("daftarSuratKeluar",klrRepo.findAll());
    }

    @RequestMapping(value = "/tambah-data" , method = RequestMethod.GET)
    public void getFormTambahData(
    	@ModelAttribute("klr") Keluar klr, 
    	BindingResult result ) {}

    @RequestMapping(value = "/tambah-data" , method = RequestMethod.POST)
    public String simpanData(
    	@ModelAttribute("klr") Keluar klr, BindingResult result) {

    	System.out.println("id : " + klr.getId());
    	System.out.println("tgl_surat : " + klr.getTgl_surat());
    	System.out.println("judul : " + klr.getJudul());
        System.out.println("tujuan : " + klr.getTujuan());
    	klrRepo.save(klr);
    	return "redirect:daftar-suratkeluar";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public void getEditData(@RequestParam(name = "id", required =
    false) String id,
        @ModelAttribute("klr") Keluar keluar, BindingResult
        binding) {
        Keluar klr = klrRepo.findOne(id);
        keluar.setId(klr.getId());
        keluar.setTgl_surat(klr.getTgl_surat());
        keluar.setJudul(klr.getJudul());
        keluar.setTujuan(klr.getTujuan());
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditData(
        @ModelAttribute("klr") Keluar klr,
        BindingResult binding) {
        klrRepo.save(klr);
        return "redirect:/daftar-suratkeluar";
    }
    
    @RequestMapping("/delete")
    public String deleteData(
        @RequestParam(name = "id", required = true) String id) {
        klrRepo.delete(id);
        return "redirect:/daftar-suratkeluar";
    }
    
}
