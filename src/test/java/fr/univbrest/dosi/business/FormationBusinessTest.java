package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.business.implementation.FormationBusinessImpl;
import fr.univbrest.dosi.business.interfaces.FormationBusinessInterface;
import fr.univbrest.dosi.business.stubs.FormationRepositoryStub;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class FormationBusinessTest {

	private FormationBusinessInterface formationBusiness;

	
	@Before
	public void init() {
		
			FormationRepositoryStub entrepot = new FormationRepositoryStub();
			formationBusiness = new FormationBusinessImpl(entrepot);
	}

    @Test
    public void doitRécupérerUneFormationParCode() {
    	remplirdonnees();
        Formation resultat = (formationBusiness.FindByCodeFormation("GIND3"));
        assertNotNull(resultat);
        assertThat(resultat.getDiplome()).isEqualTo("Ingenieur d'etat");
    }
	private void remplirdonnees() {
		Formation F1 = new Formation("GIND3", new Date(),"Ingenieur d'etat","double",new Date("30/09/2022"),new BigDecimal(2),"Génie Indus");
        formationBusiness.CreateFormation(F1);
        Formation F2 = new Formation("GINF3", new Date(),"Ingenieur d'etat","double",new Date("30/09/2022"),new BigDecimal(2),"Génie Info");
        formationBusiness.CreateFormation(F2);
	}
    
    @Test
    public void doitCompterLesFormations() {
       
    	remplirdonnees();
        long resultat = formationBusiness.CountFormations();
        assertThat(resultat).isEqualTo(2L);
        
    }

    /*@Test
    public void doitRécupérerUnCandidatParUniversiteOrigine() {
        List<Formation> resultat = formationBusiness.FindbyNomFormation("Génie Indus");

        assertThat(resultat).hasSize(1);
        assertThat(resultat.get(0).getCodeFormation()).isEqualTo("GIND3");
    }*/
}