package edu.pe.cibertec.tasks;

import edu.pe.cibertec.userinterface.ApiDemosScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ActivarWiFi implements Task {

    public static ActivarWiFi llamada() {
        return new ActivarWiFi();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ApiDemosScreen.WIFI_CHECKBOX)
        );
    }
}