class Empleado:
    _empleados = []

    def __init__(self, nombre, cedula):
        self._nombre = nombre
        self._cedula = cedula
        self._servicios = []
        self._cartera = 0
        Empleado._empleados.append(self)
    
    def getNombre(self):
        return self._nombre
    
    def setNombre(self, nombre):
        self._nombre = nombre
    
    def getCedula(self):
        return self._cedula
    
    def setCedula(self, cedula):
        self._cedula = cedula
    
    def getServicios(self):
        return self._servicios
    
    def setServicios(self, servicios):
        self._servicios = servicios
    
    def getCartera(self):
        return self._cartera
    
    def setCartera(self, cartera):
        self._cartera = cartera
    
    @classmethod
    def getEmpleados(cls):
        return cls._empleados
    
    @classmethod
    def setEmpleados(cls, empleados):
        cls._empleados = empleados
    
    def __str__():
        pass
