from tkinter import Label, Entry, Button, Text, PhotoImage, Frame, INSERT

class HojaVida(Frame):
    def __init__(self, window):
        super().__init__(window)
        self._p5 = Frame(self)
        self._p5.grid()
        entry = Entry(self._p5)
        entry.grid(row=0, column=0)
        entry.insert(INSERT, 'Hoja de vida')
        self._text = None
        self._next_hv = 0
        self._photo = None
        self.cargar_hv(0)
        self.cargar_hv_imagen(0, 0)

    # Se usa para mostrar la hoja de vida que sigue, aumentando el atributo next_hv
    def proximo(self, _):
        if self._next_hv < 3:
            self._next_hv = self._next_hv + 1
        else:
            self._next_hv = 0

        self.cargar_hv(self._next_hv)
        self.cargar_hv_imagen(self._next_hv, 0)

    # Carga el component imagen que sirve para mostrar las fotos
    def cargar_hv_imagen(self, hv_num, numero):
        path = './assets/hv_{0}_{1}.png'.format(hv_num, numero)
        self._photo = PhotoImage(file=path)
        l = Label(self, image=self._photo)
        l.grid(row=2, column=0)

    # Carga el texto para la hoja de vida respecto al numero asignado 
    def cargar_hv(self, numero):
        self._text = Text(self._p5, height=10)
        self._text.grid(row=1, column=0)
        self._text.bind('<Button-1>', self.proximo)

        path = './assets/hv{0}.txt'.format(numero)

        with open(path, "r+") as hv_text:
            self._text.insert(INSERT, hv_text.read())
