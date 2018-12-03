package com.SportsWatchProject;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.SportsWatchProject.NBATeamStanding;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
    public class TeamController {
	@Autowired 
	private UserRepository userRepo;
	
	@GetMapping(path="/save")
	public String getdata(Model Display) {
		List<TeamsEntity> team = (List<TeamsEntity>) userRepo.findAll();
		Display.addAttribute("teams", team);
		return "index";
		
	}
		
	@GetMapping(path="/favteam")
	public @ResponseBody Iterable<TeamsEntity> getAllUsers() {
		return userRepo.findAll();
		
	}

	@GetMapping(path="/login")
	public String renderlogin() {
		return "login";
		
	}

	@RequestMapping("/FavTeam")
	public ModelAndView renderIndex() {
		ModelAndView mmatr = new ModelAndView();
		mmatr.setViewName("FavTeam");
		return mmatr;
	}

	
	@PostMapping("/save")
	public ModelAndView saveStuff(HttpServletRequest request,@RequestParam("Select_Team") String Select_Team) {
		ModelAndView aa = new ModelAndView("index");
		System.out.println(request.getParameter("Select_Team"));
		String s[]=Select_Team.split(",");
		System.out.println("sadasdsadsa"+s);
		userRepo.deleteAll();
		for( int i=0;i<s.length;i++)
		{
		TeamsEntity tr2=new TeamsEntity();
		String t[]=s[i].split("-");
		System.out.println("3"+t[0]);
		tr2.setFav_team_name(t[0]);
		tr2.setAbbreviation(t[1]);
		userRepo.save(tr2);
		}

		
		List<TeamsEntity> team=new ArrayList<>();
		team=userRepo.findAll();
		request.setAttribute("teams", team);
		return aa;
	}
}
