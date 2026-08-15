package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.questions.OpcionVisible;
import edu.pe.cibertec.tasks.ActivarWiFi;
import edu.pe.cibertec.tasks.IngresarASeccion;
import edu.pe.cibertec.tasks.RegresarPantallaAnterior;
import edu.pe.cibertec.userinterface.ApiDemosScreen;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class NavegacionStepDefinitions {

    @Before
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que {word} abre la aplicacion ApiDemos")
    public void que_abre_la_aplicacion_ApiDemos(String actor) {
        theActorCalled(actor);
    }

    @Cuando("ingresa a la seccion {string}")
    public void ingresa_a_la_seccion(String seccion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarASeccion.llamada(seccion)
        );
    }

    @Entonces("deberia visualizar la opcion {string}")
    public void deberia_visualizar_la_opcion(String opcion) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(OpcionVisible.llamada(opcion), is(true))
        );
    }

    @Cuando("regresa a la pantalla anterior")
    public void regresa_a_la_pantalla_anterior() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegresarPantallaAnterior.llamada()
        );
    }

    @Entonces("la opcion {string} deberia estar deshabilitada")
    public void la_opcion_deberia_estar_deshabilitada(String opcion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ApiDemosScreen.opcionMenu(opcion))
                        .isDisabled()
        );
    }

    @Cuando("activa la casilla {string}")
    public void activa_la_casilla(String casilla) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ActivarWiFi.llamada()
        );
    }

    @Entonces("la opcion {string} deberia estar habilitada")
    public void la_opcion_deberia_estar_habilitada(String opcion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ApiDemosScreen.opcionMenu(opcion))
                        .isEnabled()
        );
    }

    @Cuando("escribe {string} en el campo del dialogo")
    public void escribe_en_el_campo_del_dialogo(String texto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Enter.theValue(texto)
                        .into(ApiDemosScreen.DIALOG_INPUT)
        );
    }

    @Cuando("confirma el dialogo")
    public void confirma_el_dialogo() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ApiDemosScreen.DIALOG_CONFIRM)
        );
    }

    @Entonces("el campo del dialogo deberia contener {string}")
    public void el_campo_del_dialogo_deberia_contener(String texto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ApiDemosScreen.DIALOG_INPUT)
                        .attribute("text")
                        .isEqualTo(texto)
        );
    }
}