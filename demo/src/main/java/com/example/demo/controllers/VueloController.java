package com.example.demo.controllers;

import com.example.demo.entities.Vuelo;
import com.example.demo.services.ReservaServiceImpl;
import com.example.demo.services.VueloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins="*")
@RequestMapping(path = "vuelos")
public class VueloController extends BaseControllerImpl<Vuelo, VueloServiceImpl>{

    private VueloServiceImpl vueloServiceImpl;

    @Autowired
    private ReservaServiceImpl reservaService;

    public VueloController(VueloServiceImpl vueloServiceImpl) {

        this.vueloServiceImpl = vueloServiceImpl;
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam String origen,
                         @RequestParam String destino,
                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha,
                         @RequestParam(defaultValue = "1") String pasajeros,
                         @RequestParam(defaultValue = "economica") String clase,
                         Model model){
        try{
            List<Vuelo> vuelos = vueloServiceImpl.buscarVuelos(origen, destino, fecha);

            // Crear un mapa para verificar qué vuelos están reservados
            Map<Long, Boolean> vuelosReservados = new HashMap<>();
            for (Vuelo vuelo : vuelos) {
                vuelosReservados.put(vuelo.getId(), reservaService.estaVueloReservado(vuelo.getId()));
            }

            // Agregar datos al modelo para la vista de resultados
            model.addAttribute("vuelos", vuelos);
            model.addAttribute("vuelosReservados", vuelosReservados); // Nuevo: mapa de vuelos reservados
            model.addAttribute("origen", origen);
            model.addAttribute("destino", destino);
            model.addAttribute("fecha", fecha);
            model.addAttribute("pasajeros", pasajeros);
            model.addAttribute("clase", clase);
            model.addAttribute("pageTitle", "Resultados de Búsqueda");

            return "resultados";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("pageTitle", "Error");
            return "error";
        }
    }
}

