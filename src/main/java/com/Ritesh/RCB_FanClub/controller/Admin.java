package com.Ritesh.RCB_FanClub.controller;


import com.Ritesh.RCB_FanClub.Model.Matches;
import com.Ritesh.RCB_FanClub.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/admin")
public class Admin {

    private AdminService adminService;
    public Admin(AdminService admin){
        this.adminService = admin;
    }

    @PostMapping("addMatch")
    public ResponseEntity<Matches> addMatch(@RequestBody Matches match){
            adminService.addMatch(match);
            return new ResponseEntity<>(match, HttpStatus.CREATED);
    }

    @GetMapping("/removeMatch/{no}")
    public ResponseEntity<Matches> removeMatch(@PathVariable Integer no){
        Matches match = adminService.removeMatch(no);
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    @DeleteMapping("/removeSeason")
    public ResponseEntity<String> removeSeason(){
        adminService.removeSeason();
        return new ResponseEntity<>("successfully removed", HttpStatus.OK);
    }

}
