'''
@File    :   inicio.py
@Time    :   2022/01/29
@Author  :   Erik Gonzalez
@Version :   1.0
@Desc    :   Ventana de inicio, es la primera en mostrarse cuando se ejecuta el programa
'''

from tkinter import Tk
from .hoja_vida import HojaVida
from .bienvenida import Bienvenida

class VentanaInicio(Tk):
    def __init__(self):
        super().__init__()
        self.title('Inicio')
        self.init_content()

    def init_content(self):
        hoja_vida = HojaVida(self)
        bienvenida = Bienvenida(self)
        hoja_vida.grid(row=0, column=1)
        bienvenida.grid(row=0, column=0)