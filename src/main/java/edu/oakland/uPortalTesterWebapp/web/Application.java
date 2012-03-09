package edu.oakland.uPortalTesterWebapp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Application {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView home = new ModelAndView("home");
		home.addObject("running", getRunning()); 
		return home;	
	}

	private boolean getRunning(){
		try{
                        //Process child = Runtime.getRuntime().exec("wget -q -O - \"$@\" http://localhost:8080/uPortal | grep \"eBill\" >> /dev/null && echo \"Found\"");
                        Process child = Runtime.getRuntime().exec("wget -q -O - \"$@\" http://localhost:8080/uPortal");
                        BufferedReader input = new BufferedReader(new InputStreamReader(child.getInputStream()));

                        String temp;
                        while((temp = input.readLine()) != null)
                                if(temp.contains("eBill"))
					return true;
                } catch (Exception e) {
                        e.printStackTrace();
		}

		return false;
	}
}