import random
import Empleado
import Servicio
import Tecnico


class Dependiente(Empleado):

    dependientes = []
    _MARGEN_GANANCIA = 1.5

    def __init__(self, nombre, cedula, caja):
        super.__init__(nombre,cedula)
        self._cajaRegistradora = caja
        Dependiente.dependientes.append(self)

    def getCajaRegistradora(self):
        return self._cajaRegistradora
    
    def setCajaRegistradora(self, caja):
        self._cajaRegistradora = caja
    
    def __str__(self):
        return "Dependiente: " + self.getNombre()
    
    def getDependientes(self):
        return Dependiente.dependientes
    
    def setDependientes(self, dependientes):
        Dependiente.dependientes = dependientes
    
    def getMargenGanancia(self):
        return Dependiente._MARGEN_GANANCIA

    def quitarServicio(self, servicio):
        self.getServicios().remove(servicio)

    def asignarServicio(self, servicio):
        self.getServicios().append(servicio)

    def finalizarServicio(self,servicio):
        self.notificarCliente(servicio)
        self.entregarProducto(servicio)

    def generarServicio(self, tecnico, producto, cliente):
        servicio = Servicio(tecnico, producto, cliente, self)
        tecnico.asignarServicio(servicio)
        self.asignarServicio(servicio)

    def atenderCliente(self, cliente, producto):
        if len(cliente.getRecibos()) == 0:
            rand = random.randint(0, len(Tecnico.tecnicos))
            tecnico = Tecnico.tecnicos[rand]
            self.generarServicio(tecnico, producto, cliente)
    
    def registrarPago(self, servicio):
        self._cajaRegistradora.registrarVenta(servicio.getCosto() * Dependiente._MARGEN_GANANCIA, servicio)
        self.quitarServicio(servicio)
    
    def notificarCliente(self, servicio):
        cliente = servicio.getCliente()
        recibo = """Factura # {} 
                    \nCliente: {} con cedula {}
                    \nCostoTotal: {} 
                    \nRecibir el producto: {}""".format(str(servicio.getIdentificador()), str(cliente.getNombre()), str(cliente.getCedula()), str(servicio.getCosto() * Dependiente._MARGEN_GANANCIA), servicio.getProducto.__str__())
        cliente.recibirRecibo(recibo)
    
    def entregarProducto(self, servicio):
        servicio.getCliente().recibirProducto(servicio.getProducto())
    
    def cobrarServicio(self, servicio):
        cobro = servicio.getCosto() * Dependiente._MARGEN_GANANCIA
        servicio.getCliente().pagartServicio(servicio, cobro)
        if not servicio.isPagado():
            self._cajaRegistradora.registrarVenta(cobro, servicio)
            servicio.setPagado(True)
    
    def cobrarSalario(self, caja):
        porcentaje = 0.01
        self.cartera += caja.descontar(porcentaje)
    
    def liquidar(self):
        caja = self._cajaRegistradora

        liquidaciones = []
        contador = 0

        for empleado in Empleado.getEmpleados():
            carterainicial = empleado.getCartera()

            empleado.cobrarSalario(caja)

            carteraAhora = empleado.getCartera()
            liquidado = carteraAhora - carterainicial

            contador += liquidado
            liquidaciones.append("El {} ha recibido {} por su trabajo.".format(empleado.__str__(), str(round(liquidado))))
        
        caja.setTotalIngresos(caja.getTotalIngresos() - contador)
        return liquidaciones



