package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Prueba1;

@RestController
@RequestMapping("/user")
public class UserController {
    private List<Prueba1>  addData(){
        final List<Prueba1> nationalTeam = new ArrayList<>();
        nationalTeam.add(new Prueba1(37, "Claudio Bravo"));
        nationalTeam.add(new Prueba1(36, "Jean Beausejour"));
        nationalTeam.add(new Prueba1(34, "Gonzalo Jara"));
        nationalTeam.add(new Prueba1(33, "Gary Medel"));
        nationalTeam.add(new Prueba1(33, "bary Medel"));
        nationalTeam.add(new Prueba1(32, "Mauricio Isla"));
        nationalTeam.add(new Prueba1(31, "Charles Aránguiz"));
        nationalTeam.add(new Prueba1(33, "Arturo Vidal"));
        nationalTeam.add(new Prueba1(34, "Matias Fernandez"));
        nationalTeam.add(new Prueba1(36, "Jorge Valdivia"));
        nationalTeam.add(new Prueba1(31, "Alexis Sánchez"));
        nationalTeam.add(new Prueba1(30, "Eduardo Vargas"));
        return nationalTeam;
    }


    @GetMapping("/orderAge")
    public ResponseEntity<?> orderAge() {
        List<Prueba1>  data1 = addData();
        Map<Integer, List<Prueba1>> results = data1.stream().collect(Collectors.groupingBy(Prueba1::getAge, Collectors.toList()));
        return ResponseEntity.ok(results);
    }

    @GetMapping("/orderAlf")
    public ResponseEntity<?> orderAlfAndAge() {
        List<Prueba1> data2 = addData();

        Map<Integer, List<Prueba1>> results = data2.stream().sorted(Comparator.comparing(Prueba1::getName, String.CASE_INSENSITIVE_ORDER)).collect(Collectors.groupingBy(Prueba1::getAge));
        return ResponseEntity.ok(results);
    }

}
