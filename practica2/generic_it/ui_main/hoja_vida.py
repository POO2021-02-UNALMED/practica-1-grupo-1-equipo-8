from tkinter import Label, Entry, Button, Text, PhotoImage, Frame, INSERT

class HojaVida(Frame):
    def __init__(self, window):
        super().__init__(window)
        p5 = Frame(self)
        p6 = Frame(self)
        text = Text(p5)
        photo = PhotoImage(file="./prueba.jpg")
        Label(p6, image=photo).pack()
        text.insert(INSERT, "Prueba")
        text.pack()

