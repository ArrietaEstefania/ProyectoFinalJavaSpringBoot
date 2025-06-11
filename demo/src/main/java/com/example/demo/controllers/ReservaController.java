package com.example.demo.controllers;
import com.example.demo.entities.Reserva;
import com.example.demo.services.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@CrossOrigin(origins="*")
@RequestMapping(path = "reservas")
public class ReservaController {

    private final ReservaServiceImpl reservaService;

    @Autowired
    public ReservaController(ReservaServiceImpl reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping("/crear/{vueloId}")  // Cambiado para coincidir con la URL del HTML
    public String crearReserva(@PathVariable Long vueloId,  // Cambiado a @PathVariable
                               RedirectAttributes redirectAttributes) {

        if (vueloId == null) {
            redirectAttributes.addFlashAttribute("error", "Error: ID de vuelo no proporcionado.");
            return "redirect:/vuelos";
        }

        try {
            Reserva reserva = reservaService.crearReserva(vueloId);
            redirectAttributes.addFlashAttribute("success",
                    "¡Reserva realizada con éxito! Número de reserva: " + reserva.getNumeroReserva());
            return "redirect:/reservas/misReservas";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error",
                    "Error al crear la reserva: " + e.getMessage());
            return "redirect:/vuelos";
        }
    }

    @GetMapping("/confirmacion")
    public String confirmacionReserva(Model model) {
        model.addAttribute("pageTitle", "Reserva Confirmada");
        return "confirmacion_reserva";
    }

    @GetMapping("/misReservas")
    public String listarReservas(Model model) {
        try {
            model.addAttribute("pageTitle", "Mis Reservas");
            model.addAttribute("reservas", reservaService.traerReservas());
            return "misReservas";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las reservas: " + e.getMessage());
            return "misReservas";
        }
    }

}