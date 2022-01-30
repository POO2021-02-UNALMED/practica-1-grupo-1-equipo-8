'''
@File    :   hoja_vida.py
@Time    :   2022/01/29
@Author  :   Erik Gonzalez
@Version :   1.0
@Desc    :   La clase Bienvenida representa p1, basado en la figura 1 del documento practica 2
'''

from ui_main.ventana_usuario import iniciar_ventana_usuario
from tkinter import Label, Entry, Button, Text, PhotoImage, Frame, INSERT

class Bienvenida(Frame):
    def __init__(self, window):
        super().__init__(window)
        self._window = window
        self._p3 = Frame(self)
        self._p4 = Frame(self)
        self._next_el = 0
        saludo = Entry(self._p3, width=100)
        saludo.insert(INSERT, "Bienvenido al software de Generic IT")
        self._pantallazos = []
        for i in range(0, 5):
            path = './assets/pantallazo_{0}.png'.format(i)
            pantallazo = PhotoImage(file=path)
            self._pantallazos.append(pantallazo)

        self._label = Label(self._p4, image=self._pantallazos[0], height=500, width=750)
        self._label.bind('<Enter>', self.proximo)
        self._label.pack()

        button = Button(self._p4, text="Ventana Principal del Admin", command=self.abrir_ventana_principal)
        button.pack()
        saludo.grid()
        self._p3.pack()
        self._p4.pack()

    # Actualiza el proximo pantallazo de la aplicacion
    def proximo(self, _):
        if self._next_el < 4:
            self._next_el = self._next_el + 1
        else:
            self._next_el = 0

        self._label.configure(image=self._pantallazos[self._next_el])
        self._label.image = self._pantallazos[self._next_el]

    def abrir_ventana_principal(self):
        self._window.destroy()
        iniciar_ventana_usuario()
