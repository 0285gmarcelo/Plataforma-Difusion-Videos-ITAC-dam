# Plataforma de Difusión de Vídeos
**Asignatura:** Programación, Entornos de Desarrollo y Bases de Datos  
**Ciclo:** DAM1 — Desarrollo de Aplicaciones Multiplataforma  
**Centro:** IES Ítaca  
**Autores:** Carlos Martín Paulos Cardoso · Guillermo André Marcelo Méndez

---

## Descripción

Aplicación de escritorio desarrollada en Java con interfaz gráfica Swing que permite
gestionar una base de datos MySQL con información sobre películas, series, actores
y personajes.

---

## Requisitos previos

- Apache NetBeans IDE 25
- JDK 11 o superior
- MySQL Server 8.0 o superior
- MySQL Connector/J 8.x (incluido en el proyecto vía Maven)

---

## Instalación y puesta en marcha

1. Iniciar el servicio **MySQL Server** en el equipo.
2. Importar el fichero `ProyectoFinalBase_de_Datos.sql` en MySQL Workbench.  
   Esto crea la base de datos `plataforma_difusion_video` con todas las tablas
   y datos de prueba.
3. Abrir el proyecto `ProyectoPlataformaVideos` en **Apache NetBeans IDE 25**.
4. Ejecutar `Main.java`.
5. En la pantalla de inicio pulsar **«Comenzar»**.

> **Nota:** Las credenciales por defecto son usuario `root` y contraseña `root`
> apuntando a `localhost:3306`. Si tu configuración es diferente, modifícalas en
> `src/main/java/Utils/Constantes.java`.

---

## Uso de la aplicación

### Menú Principal
Al iniciar la aplicación aparecen tres opciones:

| Opción | Descripción |
|---|---|
| CONSULTAR | Ver registros de la base de datos e informes |
| CREAR-ELIMINAR | Eliminar registros, exportar e importar ficheros |
| MANIPULAR DATOS | Insertar y actualizar registros |

---

### CONSULTAR

- **Consultar Fila** — busca un registro por su código identificador.
- **Consultar Todas las Filas** — muestra todos los registros de la tabla
  seleccionada ordenados alfabéticamente.
- **Consultar Datos Insertados** — muestra los registros añadidos durante
  la sesión activa.
- **Informes Multitabla** — genera 9 informes con operaciones JOIN y los
  guarda en la carpeta `Ficheros\`.

#### Informes disponibles
| Informe | Descripción |
|---|---|
| Informe 1 | Películas con actores y personajes, ordenadas por duración descendente |
| Informe 2 | Series con actores y personajes, ordenadas por temporadas descendente |
| Informe 3 | Actores con las series en las que participan y nº de episodios |
| Informe 4 | Actores con las películas en las que participan y tipo de personaje |
| Informe 5 | Actores con todas sus participaciones en películas y series |
| Informe 6 | Series con el total de actores que participan en cada una |
| Informe 7 | Actores con más de 3 personajes diferentes en total |
| Informe 8 | Actores sin participación en ninguna película ni serie |
| Informe 9 | Películas (2010-2020) con «Misterio» en el título y duración > 120 min |

---

### CREAR-ELIMINAR

- **Eliminar** — seleccionar tabla, introducir el código del registro y pulsar
  «ELIMINAR FILA».
- **Exportar** — seleccionar tabla y formato. Los ficheros se guardan en
  la carpeta `Ficheros\`.
- **Importar** — seleccionar tabla y formato del fichero a importar.
  Si la tabla ya fue importada en esta sesión, se mostrará un aviso.

#### Formatos de exportación/importación
| Formato | Separador | Extensión |
|---|---|---|
| TXT | `;` | `.txt` |
| CSV | `:` | `.csv` |
| Binario | — | `.bin` |
| JSON | — | `.json` |

---

### MANIPULAR DATOS

- **Actualizar Filas** — seleccionar tabla, introducir el código del registro,
  modificar los campos deseados y pulsar «ACTUALIZAR FILA».  
  Los campos vacíos no se modifican.
- **Insertar Filas** — seleccionar tabla, rellenar el formulario y pulsar
  «INSERTAR FILA». El código debe introducirse manualmente.

#### Valores válidos para el campo tipo
| Tabla | Valores permitidos |
|---|---|
| Personaje Película | `principal` · `secundario` · `cameo` |
| Personaje Serie | `principal` · `recurrente` · `invitado` |

---

## Orden recomendado para introducir datos

Para evitar errores de integridad referencial seguir este orden:

**Insertar:**
1. Actores
2. Películas y/o Series
3. Personaje Película y/o Personaje Serie

**Eliminar:**
1. Personaje Película y/o Personaje Serie
2. Actores, Películas y/o Series

---


## Tecnologías utilizadas

- **Java** con librería **Swing** para la interfaz gráfica
- **MySQL** como sistema gestor de base de datos
- **JDBC** (MySQL Connector/J) para la conexión Java-MySQL
- **Maven** como gestor de dependencias
- **Apache NetBeans IDE 25** como entorno de desarrollo
- **Git y GitHub** para el control de versiones

---

## Documentación incluida en el repositorio

- `ProyectoFinalBase_de_Datos.sql` — script de creación e inserción de la BD
- `Plataforma-Difusion-Videos_InformePreliminar.pdf` — informe preliminar del proyecto
- `Plataforma-Difusion-Videos_ManualUsuario.pdf` — manual de usuario y de profesor
