package api.config;

import api.Analistas;
import api.Cargos;
import api.Projetos;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(Cargos.class,Analistas.class,Projetos.class));
    }
}