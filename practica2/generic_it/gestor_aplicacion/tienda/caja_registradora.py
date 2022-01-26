'''
@File    :   caja_registradora.py
@Time    :   2022/01/26
@Author  :   Erik Gonzalez
@Version :   1.0
@Desc    :   La caja registradora lleva la contabilidad de la empresa
'''

class CajaRegistradora:
    def __init__(self):
        self.servicios = []
        self.totalIngresos = 0

    def registrarVenta(self, precio, servicio):
        self.servicios.append(servicio)
        self.totalIngresos += precio

    def getTotalIngresos(self):
        return self.totalIngresos

    def setTotalIngresos(self, totalIngresos):
        self.totalIngresos = totalIngresos

    def descontar(self, porcentaje):
        return self.totalIngresos * porcentaje
