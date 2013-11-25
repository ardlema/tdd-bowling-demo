Practica TDD
============

Implementación con Scala y ScalaTest de un marcador de bolera.

El ejercicio esta explicado e implementado en Java por Robert C. Martin y Robert S. Koss en la siguiente url: http://www.objectmentor.com/resources/articles/xpepisode.htm

Requisitos
==========

  * Scala 2.10
  * sbt 0.12
  * ruby 1.9.3 (opcional)

Puesta en marcha
================

  * Clonar el proyecto 
  * Si se utiliza Intellij para crear los ficheros necesarios que permitan importar el proyecto:
      - Moverse al directorio donde se ha clonado el proyecto
      - Ejecutar: sbt gen-idea

Moverse entre los diferentes pasos de la práctica
=================================================

  Para simplificar la navegación entre los diferentes pasos del ejercicio se ha creado un script en ruby (goToStep.rb) que permite, de una forma sencilla, moverse entre los difentes commits realizados.
   
  Para ejecutar el script se debe copiar el fichero al directorio padre del proyecto. Si se quiere ir al primer paso de la práctica, ejecutar:
  
  * ruby goToStep.rb 1
 
  Para ir al paso 15 de la práctica ejecutar:

  * ruby goToStep.rb 15
      
