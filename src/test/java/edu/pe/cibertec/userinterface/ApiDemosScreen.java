package edu.pe.cibertec.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ApiDemosScreen {
    private ApiDemosScreen() {
    }

    public static Target opcionMenu(String nombre) {
        // En ApiDemos los items del menu son TextView que exponen el rotulo en @text;
        // se acepta tambien @content-desc por si la vista lo define.
        return Target.the("opcion de menu '" + nombre + "'")
                .located(By.xpath("//android.widget.TextView[@text='" + nombre + "' or @content-desc='" + nombre + "']"));

    }
}
