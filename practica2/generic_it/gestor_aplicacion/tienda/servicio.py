

from queue import Empty


class servicio:
    servicios = list()
    def __init__(self, _tecnico, _producto, _cliente, _dependiente):
        self._tecnico = _tecnico
        self._producto = _producto
        self._cliente = _cliente
        self._dependiente = _dependiente
        self._reparado = False
        self._costo = 0
        self._diagnostico = ""
        if self.servicios is Empty:
            self.identificador = 0
        else:
            self.identificador = self.servicios.size
        self.servicios.append(self)

    def setPagado(self, _pagado):
        self._pagado = _pagado

    def getProducto(self):
        return self._producto

    def getDependiente(self):
        return self._dependiente

    def anadirCosto(self, precio):
        self.costo+=precio

    def getCosto(self):
        return self._costo

    def getDiagnostico(self):
        return self._diagnostico

    def isPagado(self):
        return self._pagado

    def setCosto(self, costo):
        self._costo=costo

    def getIdentificador(self):
        return self.identificador

    def getCliente(self):
        return self._cliente

    def setCliente(self, cliente):
        self._cliente = cliente

    @classmethod
    def getServicios(cls):
        return cls.servicios

    @classmethod
    def setServicios(cls, servicios):
        cls.servicios = servicios

    def getTecnico(self):
        return self._tecnico

    def isReparado(self):
        return self._reparado

    def setReparado(self, reparado):
        self._reparado = reparado

    def toString(self):
        return "\nIdentificador del servicio: " + self.identificador+ "\nCliente: " + self._cliente+ "\nProducto asociado: " + self._producto+ "\nReparado: " + self._reparado+ "\nPagado: " + self._pagado + "\n"