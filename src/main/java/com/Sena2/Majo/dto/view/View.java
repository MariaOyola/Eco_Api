package com.Sena2.Majo.dto.view;

public class View {

    //  vamos a crear clases en el cual vamos a crear vistas Basicas 
    /// osea solo datos  basicos
    
    public static class basic {}
    // esta es la que vamos a implementar en el DTO para asi poder dejar ver los datos basicos


    // la detail la usamos  para ver vistas mas  detalladas (( tambien se usan en el DTO))
    public static class detail  extends basic{}


    // Recordar que en el DTO vere que vista quiero que visualicen los usuario ( basica o detallada)
}
