'''
@File    :   view_exception.py
@Time    :   2022/01/31
@Author  :   Erik Gonzalez
@Version :   1.0
@Desc    : Exception padre para las excepciones que ocurren con un campo del field frame
'''

from .error_aplicacion import ErrorAplicacion

class FieldException(ErrorAplicacion):
    pass
