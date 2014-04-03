package edu.oakland.uPortalTesterWebapp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

@Controller
public class Application {

    private static final Log log = LogFactory.getLog(Application.class);

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView home = new ModelAndView("home");
        home.addObject("running", getRunning());
        return home;
    }

    private boolean getRunning() {
        Process child = null;
        try {
            child = Runtime.getRuntime().exec("wget -q -O - \"$@\" http://localhost:8080/uPortal");
            BufferedReader input = new BufferedReader(new InputStreamReader(child.getInputStream()));

            String temp;
            while((temp = input.readLine()) != null)
                if(temp.contains("eBill"))
                    return true;
	}
	catch (IOException e) { 
            e.printStackTrace();
        }
	catch (Exception e) { 
            e.printStackTrace();
        }
        finally { 
            if (child != null) {
              child.destroy();
	    }
	}

        return false;
    }
}
