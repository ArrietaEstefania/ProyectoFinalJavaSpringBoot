package com.example.demo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) { // Inyecta HttpServletRequest
        model.addAttribute("pageTitle", "Inicio");
        // Añade la URL actual al modelo
        model.addAttribute("currentUrl", request.getRequestURI());
        return "index";
    }

    @GetMapping("/misReservas")
    public String misReservas(Model model) {
        model.addAttribute("pageTitle", "Mis Reservas - FlightBooker");
        // Aquí podrías cargar las reservas del usuario si ya tienes autenticación
        // model.addAttribute("reservas", servicioDeReservas.getReservasUsuario());
        return "misReservas"; // Esto renderiza src/main/resources/templates/misReservas.html
    }
    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("pageTitle", "Registrarse - FlightBooker");
        return "registro"; // Esto renderiza src/main/resources/templates/registro.html
    }
}

