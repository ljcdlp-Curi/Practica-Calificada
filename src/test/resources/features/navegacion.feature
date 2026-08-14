# language: es

Característica: Navegacion en ApiDemos
  Como usuario de la aplicacion ApiDemos
  Quiero navegar por los menus
  Para verificar que las secciones se muestran correctamente


  @navegacion
  Esquema del escenario: Ingresar a las secciones principales
    Dado que Juan abre la aplicacion ApiDemos
    Cuando ingresa a la seccion "<seccion>"
    Entonces deberia visualizar la opcion "<opcion>"

    Ejemplos:
      | seccion    | opcion    |
      | App        | Activity  |
      | Animation  | Cloning   |
      | Preference | 9. Switch |