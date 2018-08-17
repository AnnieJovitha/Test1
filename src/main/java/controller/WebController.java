package controller;


import models.RateConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.ConversionRateRepository;

@RestController
public class WebController {
    @Autowired
    ConversionRateRepository repository;

//    @RequestMapping("/save")
//    public String process(){
//        // save a single Customer
//        repository.save(new Customer("Jack", "Smith"));
//
//        // save a list of Customers
//        repository.save(Arrays.asList(new Customer("Adam", "Johnson"), new Customer("Kim", "Smith"),
//                new Customer("David", "Williams"), new Customer("Peter", "Davis")));
//
//        return "Done";
//    }


    @RequestMapping("/findall")
    public String findAll(){
        String result = "";

        for(RateConvertor rate : repository.findAll()){
            result += rate.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }

    @RequestMapping("/findbyfromcurrency")
    public String fetchDataByLastName(@RequestParam("fromcurrency") String fromCurrency){
        String result = "";

        for(RateConvertor rate: repository.findByFromCurrency(fromCurrency)){
            result += rate.toString() + "<br>";
        }

        return result;
    }
}
