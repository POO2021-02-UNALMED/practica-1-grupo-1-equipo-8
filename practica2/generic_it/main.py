# @author: Emilio Porras
# @author: Esteban Garcia
# @summary programa principal de la aplicacion
from gestor_aplicacion.personal.empleado import Empleado
from gestor_aplicacion.tienda.cliente import Cliente
from gestor_aplicacion.personal.dependiente import Dependiente
from ctypes import resize
from os import startfile
from tkinter import *
import sys

from numpy import diag

dependiente = Dependiente("Esteban", 102943784)

#Creación de la clase field frame, de la cual surgirán todos los formularios de la aplicación
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

#Funcion que permite crear el grid del FieldFrame y actualizarlo con nuevos datos.
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

    
    #Funcion auxiliar del boton borrar
    def borrarEntry(self):
        for entrada in self._entries:
            entrada.delete(0, "end")
        
    def getValue(self, criterio):
        criterios_dict = dict(zip(self._criterios, self._valores))
        return criterios_dict[criterio]
    
    def getCriterios(self): 
        return self._criterios
        
    def getValores(self):
        return self._valores

    def setValores(self, valores):
        self._valores = valores
    
    def setEntries(self, entries):
        self._entries = entries


    def crearBotones(self, comando1):
        aceptar = Button(self, text="Aceptar",command=comando1).grid(pady = 50, column = 0, row = len(self._criterios)+1)
        borrar = Button(self, text="Borrar",command=self.borrarEntry).grid(pady = 50, column = 1, row = len(self._criterios)+1)
        
#Fin clase FieldFrame------------------------------------------------------------


def matarloTodo():
        solicitarServicio.pack_forget()
        evtSolicitarServicio.pack_forget()
        interfazInicio.pack_forget()


if __name__ == "__main__":
    
    #Ventana principal
    window = Tk()
    window.geometry("640x420")
    window.title("Generic IT")
    window.option_add("*tearOff",  FALSE)


    #Eventos antes que matar todo esté completo-------------------------------------
    def evtClienteManual():
        clienteManual.pack(fill=BOTH,expand=True)
        interfazInicio.pack_forget()

    def evtSolicitarServicio():
        solicitarServicio.pack()
    
    def evtDiagnosticarProducto():
        diagnosticarProducto.pack()
        interfazInicio.pack_forget()
    
    def evtRepararProducto():
        repararProducto.pack()
        interfazInicio.pack_forget()
    
    def evtFinalizarServicio():
        finalizarServicio.pack()
        interfazInicio.pack_forget()
    
    def evtCobrarServicio():
        cobrarServicio.pack()
        interfazInicio.pack_forget()
        
    
    #-------------------------------------------------------------------------------
    def salir():
        sys.exit()
        
    def evento():
        pass

    frame_a = Frame()#master = window
    
    frame_a.pack()
    #Barra menu superior
    menubar = Menu()

    menuarchivo = Menu(window)
    menuprocesos = Menu(window)
    menuayuda = Menu(window)
    

    menubar.add_cascade(menu = menuarchivo,
                        label='Archivo',
                        command = evento)
    menubar.add_cascade(menu = menuprocesos,
                        label = 'Procesos y Consultas',
                        command = evento)
    menubar.add_cascade(menu = menuayuda,
                        label='Ayuda',
                        command = evento)

    #submenu de procesos y consultas
    submenu = Menu(window)
    submenu.add_command(label = "Crear cliente manualmente", command = evtClienteManual)
    submenu.add_command(label = "Generar cliente", command = evento)
    submenu.add_command(label = "Solicitar servicio", command = evtSolicitarServicio)
    submenu.add_command(label = "Diagnosticar producto", command = evtDiagnosticarProducto)

    menuarchivo.add_command(label = "Aplicación", command = evento)
    menuarchivo.add_command(label = "Guardar y salir", command = salir)

    menuprocesos.add_cascade(label = "Menu diagnosticar un producto", menu = submenu)

    menuprocesos.add_command(label = "Reparar un producto", command = evtRepararProducto)
    menuprocesos.add_command(label = "Finalizar un servicio", command = evtFinalizarServicio)
    menuprocesos.add_command(label = "Cobrar un servicio", command = evtCobrarServicio)
    menuprocesos.add_command(label = "Liquidacion del periodo", command = evento)
    menuprocesos.add_command(label = "Mostrar clientes", command = evento)
    menuprocesos.add_command(label = "Mostrar servicios", command = evento)

    menuayuda.add_command(label = "Acerca de", command = evento)

    window['menu'] = menubar

    #window.mainloop()
    print('practica 2')






    
    #Frame de creacion manual del cliente ------------------------------------------------------------
    #window = Tk()
    window.resizable(True,True)

    clienteManual = Frame(window, bd=10)
    #clienteManual.pack(fill="both", expand=True)
    nombre = Label(clienteManual, text="Crear cliente manualmente", bd= 10)

    interfazInicio = Frame(window)
    texto = Text(interfazInicio)
    with open("instrucciones.txt", "r") as instrucciones:
        texto.insert(INSERT, instrucciones.read())
    

    descripcion = Label(clienteManual, text="Diligenciar la siguiente información para el correcto ingreso del cliente al sistema: ", bd= 10)

    #VALOR DE ID = len(Cliente.clientes)
    crearCliente = FieldFrame(clienteManual, "Datos cliente",["ID","Nombre", "Cedula", "Cartera"], "Valor", [0, None, None, None], ["ID"])
    crearCliente.grid_columnconfigure(0, weight=1)
    crearCliente.grid_columnconfigure(1, weight=1)
    crearCliente.grid_rowconfigure(0, weight=1)
    crearCliente.grid_rowconfigure(1, weight=1)
    crearCliente.grid_rowconfigure(2, weight=1)
    crearCliente.grid_rowconfigure(3, weight=1)
    crearCliente.grid_rowconfigure(4, weight=1)
    crearCliente.grid_rowconfigure(5, weight=1)
    


    def creacionCliente():
        crearCliente.aceptarCheck()
        Cliente(crearCliente.getValue("Nombre"), crearCliente.getValue("Cedula"), [], Dependiente.getDependientes()[0], float(crearCliente.getValue("Cartera")))
        valores = crearCliente.getValores()
        #Actualizar id del cliente en el FieldFrame
        crearCliente.setValores([int(valores[0]) + 1] + [valores[i] for i in range(1, len(valores))])
        #Resetear entries del FieldFrame
        crearCliente.setEntries(list())
        #Refrescar el FieldFrame
        crearCliente.actualizacion()

    #Creacion de los botones para aceptar y borrar de creacion manual de cliente
    crearCliente.crearBotones(creacionCliente)   #     Aceptar             Borrar

    nombre.pack()
    texto.pack()
    interfazInicio.pack()
    descripcion.pack()
    crearCliente.pack(fill=BOTH,expand=True)
    #--------------------------------------------------------------------------------
    
    
    
    #Frame de Solicitar servicio-----------------------------------------------------
    solicitarServicio = Frame(window)
    nombreSolicitarServicio = Label(solicitarServicio, text="Solicitar servicio", bd=10)
    FFsolicitarServicio = FieldFrame(solicitarServicio, None, ["ID Servicio"], None, [None], [])

    def aceptarSolicitarServicio():
        FFsolicitarServicio.aceptarCheck()
        #FUNCIONALIDAD DE SOLICITAR SERVICIO 

    FFsolicitarServicio.crearBotones(aceptarSolicitarServicio)


    nombreSolicitarServicio.pack()
    FFsolicitarServicio.pack()
    #-------------------------------------------------------------------------------



    #Frame de Diagnosticar producto-----------------------------------------------------
    diagnosticarProducto = Frame(window)
    nombreDiagnosticarProducto = Label(diagnosticarProducto, text="Diagnosticar un producto", bd=10)
    FFdiagnosticarProducto = FieldFrame(diagnosticarProducto, None, ["ID Servicio"], None, [None], [])

    def aceptarDiagnosticarProducto():
        FFdiagnosticarProducto.aceptarCheck()
        #FUNCIONALIDAD DE DIAGNOSTICAR PRODUCTO

    FFdiagnosticarProducto.crearBotones(aceptarDiagnosticarProducto)


    nombreDiagnosticarProducto.pack()
    FFdiagnosticarProducto.pack()
    #-------------------------------------------------------------------------------

    


    #Frame de Reparar un producto-----------------------------------------------------
    repararProducto = Frame(window)
    nombreRepararProducto = Label(repararProducto, text="Reparar un producto", bd=10)
    FFrepararProducto = FieldFrame(repararProducto, None, ["ID Servicio"], None, [None], [])

    def aceptarRepararProducto():
        FFrepararProducto.aceptarCheck()
        #FUNCIONALIDAD DE REPARAR UN PRODUCTO

    FFrepararProducto.crearBotones(aceptarRepararProducto)


    nombreRepararProducto.pack()
    FFrepararProducto.pack()
    #-------------------------------------------------------------------------------





    #Frame de Finalizar un servicio-----------------------------------------------------
    finalizarServicio = Frame(window)
    nombreFinalizarServicio = Label(finalizarServicio, text="Finalizar un servicio", bd=10)
    FFfinalizarServicio = FieldFrame(finalizarServicio, None, ["ID Servicio"], None, [None], [])

    def aceptarFinalizarServicio():
        FFfinalizarServicio.aceptarCheck()
        #FUNCIONALIDAD DE REPARAR UN PRODUCTO

    FFfinalizarServicio.crearBotones(aceptarFinalizarServicio)


    nombreFinalizarServicio.pack()
    FFfinalizarServicio.pack()
    #-------------------------------------------------------------------------------





    #Frame de Cobrar un servicio-----------------------------------------------------
    cobrarServicio = Frame(window)
    nombreCobrarServicio = Label(cobrarServicio, text="Cobrar un servicio", bd=10)
    FFcobrarServicio = FieldFrame(cobrarServicio, None, ["ID Servicio"], None, [None], [])

    def aceptarCobrarServicio():
        FFfinalizarServicio.aceptarCheck()
        #FUNCIONALIDAD DE COBRAR SERVICIO

    FFcobrarServicio.crearBotones(aceptarCobrarServicio)


    nombreCobrarServicio.pack()
    FFcobrarServicio.pack()
    #-------------------------------------------------------------------------------


    window.mainloop()



