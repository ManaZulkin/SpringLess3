package com.tasks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileControler {

    private int temp;
    private List<Costumer> costumers = new ArrayList<>();
    private File savedData = new File("savedData.txt");

    @GetMapping(value = "/enterData")
    public String enterData(){

        return "enterData.jsp";
    }

    @PostMapping(value = "/enterData")
    public ModelAndView enterData(@ModelAttribute("costumer") Costumer costumer,
                                  ModelAndView modelAndView){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(savedData))){

            costumers.add(costumer);
            modelAndView.setViewName("forward:saveData.jsp");
            modelAndView.addObject("costumer", costumer);
            outputStream.writeObject(costumers);
            temp += 1;
            costumer.setCount(costumer.getCount() + temp);
            System.out.println(costumer.getCount() + " : " + costumer);
            System.out.println(costumers);

        }catch (Exception e){
            e.printStackTrace();
        }
        return modelAndView;
    }

    @PostMapping(value = "/showData")
    public ModelAndView showData(@ModelAttribute("savedCostumers") ArrayList<Costumer> savedCostumers,
                           ModelAndView modelAndView){

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(savedData))){
            savedCostumers = (ArrayList) inputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(savedCostumers);

        modelAndView.setViewName("forward:showData.jsp");
        modelAndView.addObject("savedCostumers", savedCostumers);
        temp = 0;
        for (Costumer c: savedCostumers){
            modelAndView.addObject("costumer" + temp, c);
            temp++;
        }
        return modelAndView;
    }

}
