package ec.edu.espe.distribuidas.prosth.model;

import ec.edu.espe.distribuidas.prosth.model.Provincia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-17T18:51:15")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, Integer> codProvincia;
    public static volatile SingularAttribute<Ciudad, Integer> codCiudad;
    public static volatile SingularAttribute<Ciudad, Provincia> provincia;
    public static volatile SingularAttribute<Ciudad, String> nombre;

}