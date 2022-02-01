class ErrorAplicacion(Exception):
    def __init__(self, extra_message="", message="Manejo de errores de la Aplicación: "):
        c_type = type(self)
        self.message = message + c_type.__name__ + " " + extra_message
        super().__init__(self.message)
