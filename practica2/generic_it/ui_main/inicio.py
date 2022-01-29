from tkinter import Text, Frame, INSERT

class Inicio(Frame):
    def __init__(self, window):
        super().__init__(window)
        text = Text(self)
        with open("instrucciones.txt", "r+") as instrucciones:
            text.insert(INSERT, instrucciones.read())
        text.pack()

