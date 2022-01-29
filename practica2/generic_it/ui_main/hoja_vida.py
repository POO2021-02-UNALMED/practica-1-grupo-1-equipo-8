from tkinter import Label, Entry, Button, Text, PhotoImage, Frame, INSERT

class HojaVida(Frame):
    def __init__(self, window):
        super().__init__(window)
        text = Text(self)
        self.photo = PhotoImage(file="./assets/goku.png")
        text.insert(INSERT, "Prueba")
        text.pack()
        l = Label(self, image=self.photo)
        l.pack()

