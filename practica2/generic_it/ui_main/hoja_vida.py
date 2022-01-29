from tkinter import Label, Entry, Button, Text, PhotoImage, Frame, INSERT

class HojaVida(Frame):
    def __init__(self, window):
        super().__init__(window)
        self.text = Text(self)
        self.photo = None
        self.cargar_hv(1)
        self.cargar_hv_imagen(1)


    def cargar_hv_imagen(self, numero):
        self.photo = PhotoImage(file="./assets/goku.png")
        l = Label(self, image=self.photo)
        l.pack()

    def cargar_hv(self, numero):
        path = './assets/hv{0}.txt'.format(numero)
        with open(path, "r+") as hv_text:
            self.text.insert(INSERT, hv_text.read())
        self.text.pack()
