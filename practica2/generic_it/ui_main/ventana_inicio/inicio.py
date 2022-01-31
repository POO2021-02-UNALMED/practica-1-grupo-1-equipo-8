'''
@File    :   inicio.py
@Time    :   2022/01/29
@Author  :   Erik Gonzalez
@Version :   1.0
@Desc    :   Ventana de inicio, es la primera en mostrarse cuando se ejecuta el programa
'''

from tkinter import Tk, Menu
from .hoja_vida import HojaVida
from .bienvenida import Bienvenida

class VentanaInicio(Tk):
    def __init__(self):
        super().__init__()
        self.title('Inicio')
        self.init_content()
        self.menubar = Menu(self)
        inicio = Menu(self.menubar)
        inicio.add_command(label="Descripcion")
        inicio.add_command(label="Salir", command=lambda : self.destroy())

        self.menubar.add_cascade(label="Inicio", menu=inicio)
        self.config(menu=self.menubar)

    def init_content(self):
        hoja_vida = HojaVida(self)
        bienvenida = Bienvenida(self)
        hoja_vida.grid(row=0, column=1)
        bienvenida.grid(row=0, column=0)
