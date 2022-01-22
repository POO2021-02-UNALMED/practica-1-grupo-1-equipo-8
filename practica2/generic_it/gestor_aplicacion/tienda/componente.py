class componente:
    def __init__ (self, _nombre, _averiado):
        self._nombre = _nombre
        self._averiado = _averiado
        precio = 0

    def setNombre(self, nombre):
        self._nombre = nombre

    def getNombre(self):
        return self._nombre

    def isAveriado(self):
        return self._averiado

    def getPrecio(self):
        return self._precio

    def setPrecio(self, precio):
        self.precio = precio

    def toString(self):
        return self._nombre

    
