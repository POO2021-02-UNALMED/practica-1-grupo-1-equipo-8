# @author: Emilio Porras
# @author: Esteban Garcia
# @summary programa principal de la aplicacion
from tkinter import *

class FieldFrame(Frame):
    def __init__(self, master, tituloCriterios, criterios, tituloValores, valores, habilitado):
        self._tituloCriterios = tituloCriterios
        self._criterios = criterios
        self._tituloValores = tituloValores
        self._valores = valores
        self._habilitado = habilitado
        self._entries = list()
        super().__init__(master)
        self.actualizacion()


    def actualizacion(self):
        Label(self, text=self._tituloCriterios).grid(padx = 80, column = 0, row = 0)
        Label(self, text=self._tituloValores).grid(padx = 80, column = 1, row = 0)
        for i in range(1, len(self._valores)+1):
            Label(self, text=self._criterios[i-1]).grid(padx = 80, pady=2, column=0, row=i)
            if self._criterios[i-1] in self._habilitado:
                texto = StringVar(value=self._valores[i-1])
                entrada = Entry(self, width = 40, textvariable=texto, state=DISABLED, justify="center")
            else:
                texto = StringVar(value=self._valores[i-1])
                entrada = Entry(self, width = 40, textvariable=texto, justify="center")
            entrada.grid(pady =2, column=1, row=i)
            self._entries.append(entrada)

        
    #Funcion auxiliar del boton aceptar
    def aceptarCheck(self):
        #EXCEPTION SI FALTAN CAMPOS POR LLENAR Y DECIR CUALES SON
        for i in range(len(self._entries)):
            self._valores[i] = self._entries[i].get()
        print(self._valores)
        print(self.getValue(self._criterios[1]))

    
    #Funcion auxiliar del boton borrar
    def borrarEntry(self):
        for entrada in self._entries:
            entrada.delete(0, "end")
        
    def getValue(self, criterio):
        return dict(zip(self._criterios, self._valores))[criterio]
    
    def getCriterios(self): 
        return self._criterios
        
    def getValores(self):
        return self._valores

    def setValores(self, valores):
        self._valores = valores
    
    def setEntries(self, entries):
        self._entries = entries
        
        
        
            
                


if __name__ == "__main__":
    print('practica 2')
    #Frame de creacion de cliente -------------
    window = Tk()
    window.title("Generic IT")
    window.resizable(True,True)

    procesoConsulta = Frame(window, bd=10)
    nombre = Label(procesoConsulta, text="Ingreso de cliente", bd= 10)
    nombre.pack()

    descripcion = Label(procesoConsulta, text="Diligenciar la siguiente información para el correcto ingreso del cliente al sistema: ", bd= 10)
    descripcion.pack()

    #VALOR DE ID = len(Cliente.clientes)
    crearCliente = FieldFrame(procesoConsulta, "Datos cliente",["ID","Nombre", "Cedula", "Cartera"], "Valor", [0, None, None, None], ["ID"])
    crearCliente.pack()
    
    procesoConsulta.pack()

    def creacionCliente():
        crearCliente.aceptarCheck()
        #Cliente(crearCliente.getValue("Nombre"), crearCliente.getValue("Cedula"), --Lista de productos elegidos al azar--, Dependiente.getDependientes[0], float(crearCliente.getValue("Cartera")))
        valores = crearCliente.getValores()
        #Actualizar id del cliente en el FieldFrame
        crearCliente.setValores([int(valores[0]) + 1] + [valores[i] for i in range(1, len(valores))])
        #Resetear entries del FieldFrame
        crearCliente.setEntries(list())
        #Refrescar el FieldFrame
        crearCliente.actualizacion()
        print(crearCliente.getValores())
        print(crearCliente._entries)

    
    aceptar = Button(crearCliente, text="Aceptar",command=creacionCliente).grid(pady = 50, column = 0, row = len(crearCliente.getCriterios())+1)
    borrar = Button(crearCliente, text="Borrar", command=crearCliente.borrarEntry).grid(pady = 50, column = 1, row = len(crearCliente.getCriterios())+1)
    #------------------------------------------

    window.mainloop()



