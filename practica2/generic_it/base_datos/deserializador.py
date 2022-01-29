import pickle
from gestor_aplicacion.personal.empleado import Empleado
from gestor_aplicacion.tienda.cliente import Cliente
from gestor_aplicacion.personal.tecnico import Tecnico
from gestor_aplicacion.personal.dependiente import Dependiente
from gestor_aplicacion.tienda.servicio import Servicio
from gestor_aplicacion.tienda.componente import Componente
from gestor_aplicacion.tienda.bodega import Bodega
from gestor_aplicacion.tienda.producto import Producto
from gestor_aplicacion.tienda.caja_registradora import CajaRegistradora
import pathlib
import os

# save_path = '/base_datos'
# file_name = "test.txt"

# completeName = os.path.join(save_path, file_name)
# print(completeName)
print(pathlib.Path(__file__).parent.absolute())

class Deserializador():
    
    def deserializar(lista, className):
        def camino(className):
            string = os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\"+className+".txt")
            return string
        # Leo el archivo
        try:
            picklefile = open(camino(className), 'rb')
        except:
            picklefile = open(camino(className), 'x')
            picklefile = open(camino(className), 'rb')
        # unpickle los datos
        if os.path.getsize(camino(className)) > 0:
            lista += pickle.load(picklefile)
        # Cierro el archivo
        picklefile.close()
    
    def deserializarTodo():
        Deserializador.deserializar(Dependiente.dependientes, "Dependientes")
        Deserializador.deserializar(Tecnico.tecnicos, "Tecnicos")
        Deserializador.deserializar(CajaRegistradora.cajasRegistradoras, "CajasRegistradoras")
        Deserializador.deserializar(Cliente.clientes, "Clientes")
        Deserializador.deserializar(Componente.componentes, "Componentes")
        Deserializador.deserializar(Producto.productos, "Productos")
        Deserializador.deserializar(Servicio.servicios, "Servicios")
        Deserializador.deserializar(Bodega._componentes, "Componentes")
        Deserializador.deserializar(Empleado._empleados, "Empleados")
        
    