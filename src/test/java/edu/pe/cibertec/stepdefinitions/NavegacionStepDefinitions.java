package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.questions.OpcionVisible;
import edu.pe.cibertec.tasks.IngresarASeccion;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class NavegacionStepDefinitions {

    @Before
    public void preparaEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que {word} abre la aplicacion ApiDemos")
    public void que_abre_la_aplicacion_ApiDemos(String actor){
        theActorCalled(actor);
    }

    @Cuando("ingresa a la seccion {string}")
    public void ingresa_a_la_seccion(String seccion){
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarASeccion.llamada(seccion)
        );
    }

    @Entonces("deberia visualizar la opcion {string}")
    public void deberia_visualizar_la_opcion(String opcion){
        OnStage.theActorInTheSpotlight().should(
            seeThat(OpcionVisible.llamada(opcion), is(true))
        );
    }

}
