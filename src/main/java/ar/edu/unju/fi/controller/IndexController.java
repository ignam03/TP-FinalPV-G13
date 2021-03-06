package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.service.ICurriculumService;

@Controller
@RequestMapping("/empleos")
public class IndexController {

	private static final Log LOGGER = LogFactory.getLog(IndexController.class);
	
    @Autowired
    @Qualifier("CurriculumServiceImp")
    private ICurriculumService curriculumSvc;

    @GetMapping("/inicio")
    public String getInicioPage(Model model) {
        return "index";
    }

    @GetMapping({ "/loginCiu", "/login?error=true" })
    public String getLoginCiudadanoPage(Model model) {
        return "loginCiudadano";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "loginCiudadano";
    }

    @GetMapping({ "/loginEmp", "/login?error=true" })
    public String getLoginEmpleadorPage(Model model) {
        return "loginEmpleador";
    }

    @GetMapping("/registroCiu")
    public String getCiudadanoPage(Model model) {
        return "ciudadanoForm";
    }

    @GetMapping("/registroEmp")
    public String getEmpleadorPage(Model model) {
        return "empleadorForm";
    }

    @GetMapping("/ofertaLab")
    public String getListaEmpleoPage(Model model) {
        return "ofertaLaboral";
    }

    @GetMapping("/empresas")
    public String get404Page(Model model) {
        return "404";
    }

    @GetMapping("/sobreNosotros")
    public String getSobreNosotrosPage(Model model) {
        return "nosotros";
    }

    @GetMapping("/perfilesLaborales")
    public String getPerfilesLaboralesPage(Model model, @Param("filtro") String filtro,
            @Param("provincia") String provincia) {
        List<Curriculum> listaCurriculums = curriculumSvc.getOCurriculm(filtro);
        // List<Curriculum> listaCurriculumsProv =
        // curriculumSvc.getCurriculumPronvicas(provincia);
        model.addAttribute("perfiles", listaCurriculums);
        // model.addAttribute("perfiles",listaCurriculumsProvs);
        for (Curriculum curriculum : listaCurriculums) {

        }
        return "busquedaPerfiles";
    }
    /*
    @GetMapping("/verCvEmp")
	public ModelAndView getVerCv(Model model) {
    	
		ModelAndView mov = new ModelAndView("verCvEmp");
		
		List<Curriculum> listaCurriculums = curriculumSvc.getCurrriculums();
        		
		mov.addObject("perfiles", listaCurriculums);
		
		return mov;
		
	}*/
    
    @GetMapping("/verCvEmp")
    public ModelAndView visualizarCv(@RequestParam(name = "id") int id) {

    	ModelAndView mov = new ModelAndView("verCvEmp");
    	
    	List<Curriculum> listaCurriculums = curriculumSvc.getCurrriculums();

        Optional<Curriculum> p = this.curriculumSvc.getCurrriculums().stream().filter(perfil -> id == perfil.getCurriculumNumber()).findFirst();

        mov.addObject("perfiles", p.get());

        return mov;
    }
    
    
    
    // Tabla y muestra de Cursos

    public List<Curso> getCursos() {
        List<Curso> listaCurso = new ArrayList<>();
        listaCurso.add(new Curso(1, "Curso de Programacion",
                "Deber??as Aprovechar la Oportunidad de Aprender con la Modalidad Online en Vivo de Coder. Suma conocimientos en Dise??o, Marketing Digital, Community Manager y Programaci??n. Posibilidad de Becas. Proyectos reales. Tu Carrera a Otro Nivel. La Educaci??n del Futuro.",
                "Grupal", 40));
        listaCurso.add(new Curso(2, "Curso de Matematica",
                "Aprovecha este mes y suscr??bete para aprender por todo 1 a??o. S??bete a +1000 cursos, 21 escuelas, 365 d??as, 24 horas. Invierte en tu educaci??n. Aprende a tu ritmo. Incrementa tu salario. Estudia Cuando Quieras. De Principiante a Experto. Fortalece Habilidades.",
                "Individual", 20));
        listaCurso.add(new Curso(3, "Curso de Ingles Tecnico",
                "Prueba El M??todo M??s Innovador De Aprendizaje De Ingl??s Online! Profesores Americanos. Clases Privadas. 100% Online. Clases en Vivo 24x7. Cursos: Vocabulario de ingl??s, Expresiones Idiom??ticas, ingl??s para el Trabajo, Gram??tica De Ingl??s.",
                "Individual", 25));
        listaCurso.add(new Curso(4, "Curso de Estadistica",
                "Encuentra Resultados De Calidad Al Instante. Consigue Estadistica Curso. Consigue Estadistica Curso. Resultados De Calidad Al Instante Con iZito. La Mejor Informaci??n Aqu??. M??s Informaci??n. Resultados Relacionados. Resultados Cualitativos.",
                "Grupal", 30));
        listaCurso.add(new Curso(5, "Curso de Frances",
                "Ingres?? A platzi.com Y Conoc?? Nuestros Cursos Para Aprender Ingl??s junto a profesionales. Desarrollate En El ??rea De Ingl??s Y Maximiza Tus Saberes Con Los Cursos M??s Completos. Planes Disponibles. Cursos Disponibles 24/7. Test De Nivel.",
                "Individual", 10));
        listaCurso.add(new Curso(6, "Curso de Dise??o Grafico",
                "Comunic?? visualmente a trav??s de dise??os publicitarios, ilustraciones y branding. ??Form??te en Dise??o UX y cre?? soluciones innovadoras que perduren en el tiempo! Personas Y Empresas. Varios Medios De Pago. Planes Disponibles.",
                "Individual", 20));
        listaCurso.add(new Curso(7, "Curso de Electronica",
                "Comunic?? visualmente a trav??s de dise??os publicitarios, ilustraciones y branding. ??Form??te en Dise??o UX y cre?? soluciones innovadoras que perduren en el tiempo! Personas Y Empresas. Varios Medios De Pago. Planes Disponibles.Metodolog??a y materiales de estudio de vanguardia. M??s de 35 a??os te Trayectoria Educativa. Inscribite hoy y comenz?? una carrera de gran Presente y Futuro. Toma hoy una gran decisi??n. Atenci??n personalizada. 33 A??os de Trayectoria.",
                "Grupal", 15));
        listaCurso.add(new Curso(8, "Curso de Computacion",
                "Aprende a escribir tu CV, negociar tu salario y otras habilidades que impulsen tu carrera. Aprende habilidades digitales pr??cticas con lecciones gratuitas en l??nea. ??reas De Trabajo: Alumnos, Profesionales, Dirigido A Profesores.",
                "Grupal", 30));
        return listaCurso;
    }

    @GetMapping("/cursos")
    public String visualizarPaginaCursos(Model model) {
        model.addAttribute("curso", this.getCursos());
        return "curso";
    }

    @GetMapping("/verC")
    public ModelAndView visualizarCursos(@RequestParam(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("vermasC");

        Optional<Curso> p = this.getCursos().stream().filter(curso -> id == curso.getId()).findFirst();

        modelAndView.addObject("curso", p.get());

        return modelAndView;
    }
    
    @GetMapping("/cursoI")
    public ModelAndView visualizarCursosI(@RequestParam(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("feli");
        
        Optional<Curso> p = this.getCursos().stream().filter(curso -> id == curso.getId()).findFirst();

        modelAndView.addObject("feli", p.get());
        
        p.get().setCupos(p.get().getCupos()-1);
        
        LOGGER.info("Cupos restantes " + p.get().getCupos());
        
        return modelAndView;
    }

}