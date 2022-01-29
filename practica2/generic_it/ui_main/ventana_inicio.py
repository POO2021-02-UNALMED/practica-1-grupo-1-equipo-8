from tkinter import Tk
from .hoja_vida import HojaVida

class VentanaInicio(Tk):
    def __init__(self):
        super().__init__()
        self.title('Inicio')
        hoja_vida = HojaVida(self)
        hoja_vida.pack()

