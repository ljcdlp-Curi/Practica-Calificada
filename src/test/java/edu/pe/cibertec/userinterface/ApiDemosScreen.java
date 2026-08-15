package edu.pe.cibertec.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ApiDemosScreen {
    private ApiDemosScreen() {
    }

    public static Target opcionMenu(String nombre) {
        return Target.the("opcion de menu '" + nombre + "'")
                .located(By.xpath(
                        "//android.widget.TextView[@text='" + nombre + "' or @content-desc='" + nombre + "']"
                ));
    }

    public static final Target WIFI_CHECKBOX =
            Target.the("casilla WiFi")
                    .located(By.id("android:id/checkbox"));

    public static final Target WIFI_SETTINGS =
            Target.the("opcion WiFi settings")
                    .located(By.xpath(
                            "//android.widget.TextView[@text='WiFi settings']"
                    ));

    public static final Target DIALOG_INPUT =
            Target.the("campo del dialogo")
                    .located(By.id("android:id/edit"));

    public static final Target DIALOG_CONFIRM =
            Target.the("boton de confirmacion del dialogo")
                    .located(By.id("android:id/button1"));
}
