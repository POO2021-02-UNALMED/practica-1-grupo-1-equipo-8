# @author: Emilio Porras
# @author: Esteban Garcia
# @author: Felipe Miranda
# @author: Erik Gonzalez
# @summary programa principal de la aplicacion
from ui_main.ventana_usuario import iniciar_ventana_usuario
from base_datos.deserializador import Deserializador

if __name__ == "__main__":
    Deserializador.deserializarTodo()
    iniciar_ventana_usuario()
