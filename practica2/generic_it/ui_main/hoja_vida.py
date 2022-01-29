from tkinter import Label, Entry, Button, Text, PhotoImage, Frame, INSERT

class HojaVida(Frame):
    def __init__(self, window):
        super().__init__(window)
        self.text = Text(self)
        self.next_hv = 0

        self.photo = None
        self.cargar_hv(0)
        self.cargar_hv_imagen(0, 0)

    def proximo(self, _):
        if self.next_hv < 4:
            self.next_hv = self.next_hv + 1
        else:
            self.next_hv = 0

        self.cargar_hv(self.next_hv)
        self.cargar_hv_imagen(self.next_hv, 0)

    def cargar_hv_imagen(self, hv_num, numero):
        path = './assets/hv_{0}_{1}.png'.format(hv_num, numero)
        self.photo = PhotoImage(file=path)
        l = Label(self, image=self.photo)
        l.pack()

    def cargar_hv(self, numero):
        path = './assets/hv{0}.txt'.format(numero)
        with open(path, "r+") as hv_text:
            self.text.insert(INSERT, hv_text.read())
        self.text.pack()
