package com.example.labo1

import org.junit.Test

class ejercicios {
    class Computadora(
        var sistemaOperativo: String,
        var memoriaRam: Int,
        var capacidadAlmacenamiento: Int,
        var modeloProcesador: String
    ) {
        val estaActiva: Boolean = true
        var catalogoSoftware = mutableListOf<String>()

        fun iniciarSistema() {
            if (estaActiva) {
                println("Dispositivo encendido.")
            } else {
                println("Dispositivo apagado.")
            }
        }

        fun mejorarRam(nuevaCapacidad: Int) {
            memoriaRam = nuevaCapacidad
            println("Memoria RAM actualizada a $nuevaCapacidad GB.")
        }

        fun ampliarDisco(nuevoEspacio: Int) {
            capacidadAlmacenamiento = nuevoEspacio
            println("Capacidad de almacenamiento expandida a $nuevoEspacio GB.")
        }

        fun migrarSistema(versionSO: String) {
            sistemaOperativo = versionSO
            println("Sistema actualizado a $versionSO de manera exitosa.")
        }

        fun sustituirCpu(nuevoCerebro: String) {
            modeloProcesador = nuevoCerebro
            println("Procesador reemplazado por $nuevoCerebro.")
        }

        fun registrarApp(nombreApp: String) {
            catalogoSoftware.add(nombreApp)
            println("Aplicación instalada: $nombreApp")
        }

        fun filtrarSoftwareReciente(): MutableList<String> {
            val appsRecientes = mutableListOf<String>()
            val criterioAnio = "2026"

            for (app in catalogoSoftware) {
                if (app.contains(criterioAnio)) {
                    appsRecientes.add(app)
                }
            }
            return appsRecientes
        }

        fun imprimirFichaTecnica() {
            println("--- Especificaciones del Hardware ---")
            println("CPU: $modeloProcesador")
            println("RAM: $memoriaRam GB")
            println("Disco: $capacidadAlmacenamiento GB")
            println("OS: $sistemaOperativo")
        }
    }


    class Calculadora(
        val fabricante: String,
        val tiempoVidaUtil: Int,
        val costoMercado: Double
    ) {
        fun adicion(a: Double, b: Double) = a + b

        fun sustraccion(a: Double, b: Double) = a - b

        fun producto(a: Double, b: Double) = a * b

        fun cociente(dividendo: Double, divisor: Double): Double {
            return if (divisor == 0.0) {
                println("Error: Operación matemática inválida (división por cero).")
                0.0
            } else {
                dividendo / divisor
            }
        }

        fun verDetallesComerciales() {
            println("Modelo: $fabricante")
            println("Garantía estimada: $tiempoVidaUtil años")
            println("Precio: $$costoMercado")
        }
    }


    class Estudiante(
        val nombreCompleto: String,
        val idEstudiantil: Int,
        val curso: String
    ) {
        fun imprimirPerfil() {
            println("Estudiante: $nombreCompleto")
            println("ID de Registro: $idEstudiantil")
        }
    }

    fun filtrarAlumnosPorCurso(nomina: List<Estudiante>, cursoABuscar: String) {
        println("Generando reporte para la materia: $cursoABuscar")
        var contadorCoincidencias = 0

        for (alumno in nomina) {
            if (alumno.curso == cursoABuscar) {
                alumno.imprimirPerfil()
                contadorCoincidencias++
            }
        }
        println("Registros totales encontrados: $contadorCoincidencias\n")
    }

    @Test
    fun verificarHardware() {
        val miOrdenador = Computadora("Windows 11", 8, 256, "Ryzen 5")

        miOrdenador.iniciarSistema()
        miOrdenador.imprimirFichaTecnica()
        miOrdenador.mejorarRam(16)
        miOrdenador.registrarApp("Word 2026")
        miOrdenador.registrarApp("JuegoViejito 2015")
        miOrdenador.registrarApp("Excel 2026")
        miOrdenador.registrarApp("explorer 1543")

        val software2026 = miOrdenador.filtrarSoftwareReciente()
        println("Apps del año 2026:")
        software2026.forEach { println("- $it") }
    }

    @Test
    fun verificarOperaciones() {
        val miCalcu = Calculadora("Casio", 10, 15.99)
        miCalcu.verDetallesComerciales()

        println("Suma: ${miCalcu.adicion(10.5, 5.0)}")
        println("Multiplicación: ${miCalcu.producto(3.0, 4.0)}")
        println("División: ${miCalcu.cociente(15.0, 3.0)}")
    }

    @Test
    fun gestionarRegistroAcademico() {
        val a1 =Estudiante("Jose Lara", 202601, "PDM")
        val a2 = Estudiante("Ana López", 202602, "PDM")
        val a3 =Estudiante("Joaquin Mendez", 202603, "PDM")
        val a4 =Estudiante("María Gracia", 202604, "Análisis")
        val a5 = Estudiante("Nancy Santillana", 202605, "Análisis")
        val a6 = Estudiante("Kevin Franco", 202606, "Análisis")
        val a7 = Estudiante("Daniel Rosales", 202607, "Análisis")

        val baseDeDatos = listOf(a1, a2, a3, a4, a5, a6, a7)

        filtrarAlumnosPorCurso(baseDeDatos, "PDM")
    }
}