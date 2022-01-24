from tkinter import *

class FieldFrame(Frame):
    def __init__(self, master, tituloCriterios, criterios, tituloValores, valores, habilitado):
        self.tituloCriterios = tituloCriterios
        self.criterios = criterios
        self.tituloValores = tituloValores
        self.valores = valores
        self.habilitado = habilitado
        super().__init__(master)

        Label(self, text=self.tituloCriterios).grid(padx = 80, column = 0, row = 0)
        Label(self, text=self.tituloValores).grid(padx = 80, column = 1, row = 0)
        for i in range(1, len(criterios)+1):
            Label(self, text=criterios[i-1]).grid(padx = 80,pady=2, column=0, row=i)
            Entry(self, width = 40).grid(pady =2, column=1, row=i)

        
        aceptar = Button(self, text="Aceptar",command=self.aceptarCheck).grid(pady = 50, column = 0, row = len(self.criterios)+1)
        borrar = Button(self, text="Borrar", command=self.borrarEntry).grid(pady = 50, column = 1, row = len(self.criterios)+1)
        
    #Funcion auxiliar del boton aceptar
    def aceptarCheck(self):
        pass
    
    #Funcion auxiliar del boton borrar
    def borrarEntry(self):
        pass
        
        
    

    def getValue(self, criterio):
        pass   
     
        
        
            
                


if __name__ == "__main__":
    print('practica 2')

    window = Tk()
    window.title("Generic IT")
    window.resizable(True,True)

    procesoConsulta = Frame(window, bd=10)
    nombre = Label(procesoConsulta, text="Ingreso de cliente", bd= 10)
    nombre.pack()

    descripcion = Label(procesoConsulta, text="Diligenciar la siguiente información para el correcto ingreso del cliente al sistema: ", bd= 10)
    descripcion.pack()

    crearCliente = FieldFrame(procesoConsulta, "Datos cliente",["ID","Nombre", "Cedula", "Direccion", "Cartera"], "Valor", [0, "Hernesto", 1029384, "cra 34h 89-25", 500000], ["ID"])
    crearCliente.pack()

    procesoConsulta.pack()
    window.mainloop()



