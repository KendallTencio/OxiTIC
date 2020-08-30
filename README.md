# OxiTIC
Este es un proyecto prototipo para la realización de una Plataforma que permita un control a distancia de personas que padezcan de Hipoxia Silenciosa en el ámbito del Covid-19 mediante el uso de Arduinos y Oxímetros.

# Introducción
  Se buscaría tener una plataforma de dos modalidades, una modalidad de obtención de datos y reconocimiento de patrones de riesgo haciendo uso de un oxímetro y un microcontrolador, siendo esta primera modalidad usada por los pacientes o personas de riesgo que se busquen tener en control por alguna cualidad de ser asintomáticos o similares. Una segunda modalidad de la plataforma se encargaría de hacer vigilancia del estado de los pacientes, obteniendo información pertinente de los mismos como datos personales, ubicación y estado actual acorde a los datos registrados por el oxímetro.
  La primera modalidad tendría acceso a observar los datos captados por el oxímetro y los resultados de riesgo calculados por el reconocimiento de patrones, determinando en qué estado de riesgo se encuentra; además contaría con acceso a un botón de emergencia S.O.S. que comunique a la persona con las autoridades de sanidad en caso de que algún problema se presente. Esta modalidad de la plataforma está pensada para los pacientes, como se dijo con anterioridad y los datos serán transmitidos en tiempo real a un servidor de BD como lo puede ser Firebase, para ser también redirigidos a la segunda modalidad.
  La segunda modalidad busca llevar un control de los pacientes que estén haciendo uso de la plataforma en la primera modalidad, su uso se ve previsto para ser manipulado por autoridades de salud. Presentaría un listado de los pacientes siendo monitoreados, siendo los primeros en la lista los que tengan mayor riesgo calculado por los patrones a los que tengan menos, además se prestaría para en caso de tener que actuar con alguno de ellos poder acceder a su información pertinente como datos de nombre, cédula, celular, ubicación geográfica, tipo de sangre, etc.

# Herramientas/Tecnologías necesarias
  - Oxímetro con BLE.
  - Arduino ESP32 con manejo de Bluetooth.
  - Android Studio
  - Servidor de BD en Firebase o Realm (Preferiblemente Firebase)
