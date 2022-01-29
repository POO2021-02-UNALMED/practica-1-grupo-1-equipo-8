from tkinter import Label, Entry, Button, Text, PhotoImage, Frame, INSERT

class HojaVida(Frame):
    def __init__(self, window):
        super().__init__(window)
        self.p5 = Frame(self)
        self.p5.grid()
        entry = Entry(self.p5)
        entry.grid(row=0, column=0)
        entry.insert(INSERT, 'Hoja de vida')
        self.text = None
        self.next_hv = 0
        self.photo = None
        self.cargar_hv(0)
        self.cargar_hv_imagen(0, 0)

    def proximo(self, _):
        if self.next_hv < 3:
            self.next_hv = self.next_hv + 1
        else:
            self.next_hv = 0

        self.cargar_hv(self.next_hv)
        self.cargar_hv_imagen(self.next_hv, 0)

    def cargar_hv_imagen(self, hv_num, numero):
        path = './assets/hv_{0}_{1}.png'.format(hv_num, numero)
        self.photo = PhotoImage(file=path)
        l = Label(self, image=self.photo)
        l.grid(row=2, column=0)

    def cargar_hv(self, numero):
        self.text = Text(self.p5, height=10)
        self.text.grid(row=1, column=0)
        self.text.bind('<Button-1>', self.proximo)

        path = './assets/hv{0}.txt'.format(numero)

        with open(path, "r+") as hv_text:
            self.text.insert(INSERT, hv_text.read())
