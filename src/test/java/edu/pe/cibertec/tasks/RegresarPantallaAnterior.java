package edu.pe.cibertec.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class RegresarPantallaAnterior implements Task {

    public static RegresarPantallaAnterior llamada() {
        return new RegresarPantallaAnterior();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().navigate().back();
    }
}