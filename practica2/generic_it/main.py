# @author: Emilio Porras
# @author: Esteban Garcia
# @summary programa principal de la aplicacion
from gestor_aplicacion.personal.empleado import Empleado
from gestor_aplicacion.tienda.cliente import Cliente
from gestor_aplicacion.personal.tecnico import Tecnico
from gestor_aplicacion.personal.dependiente import Dependiente
from gestor_aplicacion.tienda.servicio import Servicio
from gestor_aplicacion.tienda.componente import Componente
from gestor_aplicacion.tienda.precio_componente import PrecioComponente
from gestor_aplicacion.tienda.bodega import Bodega
from gestor_aplicacion.tienda.producto import Producto
from ctypes import resize
from os import startfile
from tkinter import *
import sys
from numpy import diag
from random import choice, random, randint

dependiente = Dependiente("Esteban", 102943784)
tecnico = Tecnico("Emilio", 12312391)
#servicio = Servicio("Emilio", None, "Manel", dependiente)

#FUNCIONALIDADES---------------------------------------------------------------------------------------

def generarProductoAleatorio():
    rand = random()
    nombreProductos = [ "Laptop Legion 5", "Hp zbook 1", "Hp Omen 15", "Asus TUF Gaming", "HP XPS",
				"Macbook pro", "Lenovo Thinkpad", "Hp pavilion", "Notebook Gigabyte", "MSI Strike" ]
    componentes = [ Componente("Memoria 4g Kinsgton", True),
                    Componente("Disco duro SSD 256gb", True),
                    Componente("Bateria laptop lenovo supercharger", True),
                    Componente("Procesador AMD", True),
                    Componente("Display 15 pulgadas", True),
                    Componente("Memoria 8g Kinsgton", True),
                    Componente("Disco duro HDD 512gb", True),
                    Componente("Bateria laptop lenovo", True),
                    Componente("Procesador Intel", True),
                    Componente("Display 17 pulgadas", True)]
    
    productoComponentes = list()
    productoComponentes.append(choice(componentes))
    productoComponentes.append(choice(componentes))

    return Producto(choice(nombreProductos), productoComponentes)
    

def generarCliente():
    nombres = ["Esteban", "Emilio", "Felipe", "Erik", "Alexander", "Jaime", "Alejandro", "Emiliana", "Dua lipa", "Erika", "Michael", "Juliana"]
    componentes = [Componente("Memoria 4g Kingston", False, PrecioComponente.RAM_4GB.value),
    Componente("Disco duro SSD 256gb", False, PrecioComponente.DISCO_DURO_SSD_256GB.value),
    Componente("Bateria laptop lenovo supercharger", False, PrecioComponente.BATERIA_LAPTOP_SUPERCHARGER),
    Componente("Procesador AMD", False, PrecioComponente.PROCESADOR_AMD.value),
    Componente("Display 15 pulgadas", False, PrecioComponente.DISPLAY_LAPTOP_15In.value),
    Componente("Memoria 8g Kingston", False, PrecioComponente.RAM_8GB.value),
    Componente("Disco duro HDD 512gb", False, PrecioComponente.DISCO_DURO_HDD_512GB),
    Componente("Bateria laptop lenovo", False, PrecioComponente.BATERIA_LAPTOP),
    Componente("Procesador Intel", False, PrecioComponente.PROCESADOR_INTEL),
    Componente("Display 17 pulgadas", False, PrecioComponente.DISPLAY_LAPTOP_17In.value)]
    dependiente = Dependiente.dependientes[0]
    producto = generarProductoAleatorio()
    productos = [producto]
    cartera = int(450000+1000000*random())
    cliente = Cliente(choice(nombres), randint(100000000, 9999999999), productos, dependiente, cartera)

    valores = crearCliente.getValores()
    #Actualizar id del cliente en el FieldFrame
    crearCliente.setValores([int(valores[0]) + 1] + [valores[i] for i in range(1, len(valores))])
    #Resetear entries del FieldFrame
    crearCliente.setEntries(list())
    #Refrescar el FieldFrame
    crearCliente.actualizacion()

    for componente in componentes:
        Bodega.agregarComponente(componente)
    return cliente

    



def funSolicitarServicio(index):
        cliente = Cliente.getClientes()[int(index)]
        if len(cliente.getRecibos()) == 0:
            producto = cliente.getProductos()[0]
            cliente.solicitarReparacion(producto)
            return "El cliente fue atendido exitosamente por " + cliente.getDependiente().getNombre() + " y se ha generado el servicio con: " + producto.__str__() + ".\nYa puede consultar en los servicios para iniciar su diagnostico."
        else:
            return "El cliente " + cliente.getNombre() + " ya habia sido atendido\n"

def diagnosticarUnProducto():
            servicio = Servicio.getServicios()[int(FFdiagnosticarProducto.getValue("ID Servicio"))] #***ERIK***: Error id no correcto}
            #except = "El id del servicio no es correcto\n"
            #Busca los componentes con problemas en el producto asociado al servicio.
            if not servicio.isReparado():
                servicio.getTecnico().diagnosticar(servicio)
                # Devuelve el diagnostico hecho por el tecnico.
                stringDiagnostico = servicio.__str__()
                stringDiagnostico += "Ya puede volver al menu principal para solicitar reparacion\n"
            else:
                stringDiagnostico = "Este producto ya habia sido reparado\n"
            return stringDiagnostico

























#------------------------------------------------------------------------------------------------------

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
        #***ERICK***  EXCEPTION SI FALTAN CAMPOS POR LLENAR Y DECIR CUALES SON
        for i in range(len(self._entries)): #_entries es la lista con las entradas.
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

framesAMatar = []

def matarloTodo(frameUtilizado):

        for frame in framesAMatar:
            frame.pack_forget()
        frameUtilizado.pack(fill=BOTH,expand=True)
        

def outPut(string, text):
    text.delete("1.0", "end")
    text.insert(INSERT, string)
    text.pack(fill=X, expand=True)




if __name__ == "__main__":
    
    #Ventana principal
    window = Tk()
    window.geometry("640x420")
    window.title("Generic IT")
    window.option_add("*tearOff",  FALSE)


    #Métodos sin argumentos para poder ejecutarlos-------------------------------------
    def evtClienteManual():
        matarloTodo(clienteManual)

    #Output de Generar cliente  
    outputGenerarCliente = Text(window, height=3)
    framesAMatar.append(outputGenerarCliente)    
    def evtGenerarCliente():
        cliente = generarCliente()
        outPut("Se genero el cliente ID: "+str(Cliente.clientes.index(cliente))+" "+cliente.__str__() ,outputGenerarCliente)
        matarloTodo(outputGenerarCliente)

    def evtSolicitarServicio():
        matarloTodo(solicitarServicio)
    
    def evtDiagnosticarProducto():
        matarloTodo(diagnosticarProducto)
    
    def evtRepararProducto():
        matarloTodo(repararProducto)
    
    def evtFinalizarServicio():
        matarloTodo(finalizarServicio)
    
    def evtCobrarServicio():
        matarloTodo(cobrarServicio)

    #Output de Liquidar el periodo  
    outputLiquidarPeriodo = Text(window, height=5)
    framesAMatar.append(outputLiquidarPeriodo)   
    def evtLiquidarPeriodo():
        ###LIQUIDAR EL PERIODO CON LA CAJA REGISTRADORA
        outPut("En la caja registradora hay ***SALDO CAJA antes de liquidar."+
        "\nEl Dependiente: ***DEPENDIENTE ha recibido ***PAGO por su trabajo."+
        "\nEl Tecnico: ***TECNICO ha recibido ***PAGO por su trabajo"+
        "\nEl Tecnico: ***TECNICO ha recibido ***PAGO por su trabajo"+
        "\nEn la caja registradora quedan ***SALDO CAJA.", outputLiquidarPeriodo)
        matarloTodo(outputLiquidarPeriodo)
    
    #Output de mostrar clientes
    outPutMostrarClientes = Text(window, height=len(Cliente.clientes))
    framesAMatar.append(outPutMostrarClientes)
    #Evento para mostrar clientes
    def evtMostrarClientes():
        stri = ""
        for i in range(len(Cliente.clientes)):
            stri+="ID cliente: " + str(i) + " " + Cliente.clientes[i].__str__() + "\n"
        outPut(stri, outPutMostrarClientes)
        matarloTodo(outPutMostrarClientes)
    
    #Output de mostrar servicios
    outPutMostrarServicios = Text(window, height=len(Servicio.servicios))
    framesAMatar.append(outPutMostrarServicios)
    #Evento para mostrar servicios
    def evtMostrarServicios():
        stri = ""
        for i in range(len(Servicio.servicios)):
            stri+= "ID servicio: " + str(i) + " " + Servicio.servicios[i].__str__() + "\n"
        outPut(stri, outPutMostrarServicios)
        matarloTodo(outPutMostrarServicios)
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
    submenu.add_command(label = "Generar cliente", command = evtGenerarCliente)
    submenu.add_command(label = "Solicitar servicio", command = evtSolicitarServicio)
    submenu.add_command(label = "Diagnosticar producto", command = evtDiagnosticarProducto)

    menuarchivo.add_command(label = "Aplicacion", command = evento)
    menuarchivo.add_command(label = "Guardar y salir", command = salir)

    menuprocesos.add_cascade(label = "Menu diagnosticar un producto", menu = submenu)

    menuprocesos.add_command(label = "Reparar un producto", command = evtRepararProducto)
    menuprocesos.add_command(label = "Finalizar un servicio", command = evtFinalizarServicio)
    menuprocesos.add_command(label = "Cobrar un servicio", command = evtCobrarServicio)
    menuprocesos.add_command(label = "Liquidar el periodo", command = evtLiquidarPeriodo)
    menuprocesos.add_command(label = "Mostrar clientes", command = evtMostrarClientes)
    menuprocesos.add_command(label = "Mostrar servicios", command = evtMostrarServicios)

    menuayuda.add_command(label = "Acerca de", command = evento)

    window['menu'] = menubar

    print('practica 2')


    #Frame de creacion manual del cliente ------------------------------------------------------------
    window.resizable(True,True)

    clienteManual = Frame(window, bd=10)
    nombre = Label(clienteManual, text="Crear cliente manualmente", bd= 10)



    #Interfaz de inicio----------------------------------------------------------------
    interfazInicio = Frame(window)
    texto = Text(interfazInicio)
    with open("instrucciones.txt", "r+") as instrucciones:
        texto.insert(INSERT, instrucciones.read())


    framesAMatar.append(interfazInicio)
    #----------------------------------------------------------------------------------


    

    descripcion = Label(clienteManual, text="Diligenciar la siguiente información para el correcto ingreso del cliente al sistema: ", bd= 10)

    #VALOR DE ID = len(Cliente.clientes)
    crearCliente = FieldFrame(clienteManual, "Datos cliente",["ID","Nombre", "Cedula", "Cartera"], "Valor", [len(Cliente.clientes), None, None, None], ["ID"])
    crearCliente.grid_columnconfigure(0, weight=1)
    crearCliente.grid_columnconfigure(1, weight=1)
    crearCliente.grid_rowconfigure(0, weight=1)
    crearCliente.grid_rowconfigure(1, weight=1)
    crearCliente.grid_rowconfigure(2, weight=1)
    crearCliente.grid_rowconfigure(3, weight=1)
    crearCliente.grid_rowconfigure(4, weight=1)
    crearCliente.grid_rowconfigure(5, weight=1)
    
    output = Text(clienteManual, height=3)
    framesAMatar.append(output)

    def creacionCliente():
        crearCliente.aceptarCheck()
        producto = generarProductoAleatorio()
        productos = [producto] 
        #***ERIK*** REVISAR QUE EL NOMBRE, CEDULA Y CARTERA SEAN DE SUS TIPOS CORRESPONDIENTES
        cliente = Cliente(crearCliente.getValue("Nombre"), crearCliente.getValue("Cedula"), productos, Dependiente.getDependientes()[0], float(crearCliente.getValue("Cartera")))
        
        valores = crearCliente.getValores()
        #Actualizar id del cliente en el FieldFrame
        crearCliente.setValores([int(valores[0]) + 1] + [valores[i] for i in range(1, len(valores))])
        #Resetear entries del FieldFrame
        crearCliente.setEntries(list())
        #Refrescar el FieldFrame
        crearCliente.actualizacion()
        outPut("Se ha generado manualmente el cliente con ID: " + str(len(Cliente.clientes)-1) + " " + cliente.__str__(), output)

    #Creacion de los botones para aceptar y borrar de creacion manual de cliente
    crearCliente.crearBotones(creacionCliente)   #     Aceptar             Borrar

    nombre.pack()
    texto.pack()
    interfazInicio.pack()
    descripcion.pack()
    crearCliente.pack(fill=BOTH,expand=True)
    framesAMatar.append(clienteManual)
    
    #--------------------------------------------------------------------------------
     
    
    
    #Frame de Solicitar servicio-----------------------------------------------------
    solicitarServicio = Frame(window)
    nombreSolicitarServicio = Label(solicitarServicio, text="Solicitar servicio", bd=10)
    dcrSolicitarServicio = Label(solicitarServicio, text="Ingrese el ID del cliente para solicitar la reparacion de su producto", bd=10)
    FFsolicitarServicio = FieldFrame(solicitarServicio, None, ["ID cliente"], None, [None], [])
    outputsolicitarServicio = Text(solicitarServicio, height=3)
    framesAMatar.append(outputsolicitarServicio)


    def aceptarSolicitarServicio():
        FFsolicitarServicio.aceptarCheck()
        funSolicitarServicio(FFsolicitarServicio.getValue("ID cliente"))
        outPut(funSolicitarServicio(FFsolicitarServicio.getValue("ID cliente")), outputsolicitarServicio) 

    FFsolicitarServicio.crearBotones(aceptarSolicitarServicio)


    nombreSolicitarServicio.pack()
    dcrSolicitarServicio.pack()
    FFsolicitarServicio.pack()
    framesAMatar.append(solicitarServicio)
    #-------------------------------------------------------------------------------
    #@summary Diagnostica el servicio seleccionado por el administrador.
    #Frame de Diagnosticar producto-----------------------------------------------------
    diagnosticarProducto = Frame(window)
    nombreDiagnosticarProducto = Label(diagnosticarProducto, text="Diagnosticar un producto", bd=10)
    dcrDiagnosticarProducto = Label(diagnosticarProducto, text = "Ingrese el ID del servicio a diagnosticar", bd=10)
    FFdiagnosticarProducto = FieldFrame(diagnosticarProducto, None, ["ID Servicio"], None, [None], [])
    outputDiagnosticarProducto = Text(diagnosticarProducto, height=7)
    framesAMatar.append(outputDiagnosticarProducto)

    def aceptarDiagnosticarProducto():
        FFdiagnosticarProducto.aceptarCheck()
        
        outPut(diagnosticarUnProducto(), outputDiagnosticarProducto)

    FFdiagnosticarProducto.crearBotones(aceptarDiagnosticarProducto)


    nombreDiagnosticarProducto.pack()
    dcrDiagnosticarProducto.pack()
    FFdiagnosticarProducto.pack()
    framesAMatar.append(diagnosticarProducto)
    #-------------------------------------------------------------------------------

    


    #Frame de Reparar un producto-----------------------------------------------------
    repararProducto = Frame(window)
    nombreRepararProducto = Label(repararProducto, text="Reparar un producto", bd=10)
    dcrRepararProducto = Label(repararProducto, text="Ingrese el ID del servicio a reparar", bd=10)
    FFrepararProducto = FieldFrame(repararProducto, None, ["ID Servicio"], None, [None], [])
    outputRepararProducto = Text(repararProducto, height=3)
    framesAMatar.append(outputRepararProducto)

    def aceptarRepararProducto():
        FFrepararProducto.aceptarCheck()
        #FUNCIONALIDAD DE REPARAR UN PRODUCTO
        outPut("El servicio de ***CLIENTE fue arreglado por ***TECNICO y tuvo un costo para la empresa de ***COSTO SERVICIO", outputRepararProducto)

    FFrepararProducto.crearBotones(aceptarRepararProducto)


    nombreRepararProducto.pack()
    dcrDiagnosticarProducto.pack()
    FFrepararProducto.pack()
    framesAMatar.append(repararProducto)
    #-------------------------------------------------------------------------------





    #Frame de Finalizar un servicio-----------------------------------------------------
    finalizarServicio = Frame(window)
    nombreFinalizarServicio = Label(finalizarServicio, text="Finalizar un servicio", bd=10)
    dcrFinalizarServicio = Label(finalizarServicio, text="Ingrese el ID del servicio a finalizar", bd=10)
    FFfinalizarServicio = FieldFrame(finalizarServicio, None, ["ID Servicio"], None, [None], [])
    outputFinalizarServicio = Text(finalizarServicio, height=5)
    framesAMatar.append(outputFinalizarServicio)


    def aceptarFinalizarServicio():
        FFfinalizarServicio.aceptarCheck()
        #FUNCIONALIDAD DE FINALIZAR SERVICIO
        outPut("Factura # ***ID SERVICIO"+
        "\nCliente: ***CLIENTE con cedula ###CEDULA CLIENTE"+
        "\nCosto total: **COSTO SERVICIO"+
        "\nRecibir el producto: ###PRODUCTO"+
        "\nEl servicio ya esta listo para ser cobrado.", outputFinalizarServicio)


    FFfinalizarServicio.crearBotones(aceptarFinalizarServicio)


    nombreFinalizarServicio.pack()
    dcrFinalizarServicio.pack()
    FFfinalizarServicio.pack()
    framesAMatar.append(finalizarServicio)
    #-------------------------------------------------------------------------------





    #Frame de Cobrar un servicio-----------------------------------------------------
    cobrarServicio = Frame(window)
    nombreCobrarServicio = Label(cobrarServicio, text="Cobrar un servicio", bd=10)
    dcrCobrarServicio = Label(cobrarServicio, text="Ingrese el ID del servicio a cobrar", bd=10)
    FFcobrarServicio = FieldFrame(cobrarServicio, None, ["ID Servicio"], None, [None], [])
    outputCobrarServicio = Text(cobrarServicio, height=3)
    framesAMatar.append(outputCobrarServicio)


    def aceptarCobrarServicio():
        FFfinalizarServicio.aceptarCheck()
        #FUNCIONALIDAD DE COBRAR SERVICIO
        outPut("Se cobra el servicio por un total de ***COSTO*MARGEN_GANANCIA." + 
               "\nEn la caja registradora ahora hay ***TOTAL_INGRESOS_CAJA pesos.", outputCobrarServicio)

    FFcobrarServicio.crearBotones(aceptarCobrarServicio)


    nombreCobrarServicio.pack()
    dcrCobrarServicio.pack()
    FFcobrarServicio.pack()
    framesAMatar.append(cobrarServicio)
    #-------------------------------------------------------------------------------
    

    window.mainloop()



