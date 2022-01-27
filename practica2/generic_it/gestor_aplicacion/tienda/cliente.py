'''
@File    :   cliente.py
@Time    :   2022/01/26
@Author  :   Erik Gonzalez
@Version :   1.0
@Desc    :   El cliente tiene tres funcionalidades. solicitar una reparacion,
             pagar es servicio que se se presto y recibir su producto. El cliente
             muchas veces puede pa
'''

class Cliente():
    _clientes = []

    def __init__(self, nombre, cedula, productos, dependiente, cartera, direccion = None):
        self._direccion = direccion if direccion != None 
        self._nombre = nombre
        self._cedula = cedula
        self._productos = productos
        self._dependiente = dependiente
        self._cartera = cartera
        Cliente._clientes.append(self)

    def solicitarReparacion(self, producto):
        self._productos.append(producto)

    def pagarServcio(self, servicio, cobro):
        if(!servicio.isPagado() && self._cartera >= cobro):
            self._cartera -= cobro

    def recibirProducto(self, producto):
        self._productos.append(producto)

    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        return self._nombre = nombre

    def getCedula(self, cedula):
        return self._cedula = cedula

    def getProductos(self):
        return self._productos

    def setProductos(self, productos):
        return self._productos = productos

    def getDependiente(self):
        return self._dependiente

    def setDepediente(self, dependiente):
        return self.dependiente = dependiente

    def recibirRecibo(self, recibo):
        self._recibos.append(recibo)

    def getRecibos(self):
        return self._recibos

    @classmethod
    def getClientes(cls):
        return cls._clientes

    @classmethod
    def setClientes(cls, clientes):
        return cls._clientes = clientes

    def getCartera(self):
        return self._cartera

    def __str__(self):
        return "Nombre: " + self._nombre + " CC: " + self._cedula + " Cartera: " + self._cartera + " Direccion: " + self._direccion
