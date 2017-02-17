package fr.univbrest.dosi.business.implementation;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.business.interfaces.FormationBusinessInterface;
import fr.univbrest.dosi.business.stubs.FormationRepositoryStub;
import fr.univbrest.dosi.repositories.FormationRepository;

@Component
public class FormationBusinessImpl implements FormationBusinessInterface {
	
	private final FormationRepository FormationDAO;
	
	@Autowired
	public FormationBusinessImpl(FormationRepository  entrepot) {
		super();
		this.FormationDAO = entrepot;
	}

	public boolean CreateFormation(Formation F)
	{
		if(FormationDAO.findOne(F.getCodeFormation()) != null)
			return false;
		
		FormationDAO.save(F);
		
		return true;
	}

	public List<Formation> GetAllFormations()
	{
		return  Lists.newArrayList(FormationDAO.findAll());
	}
	
	public void DeleteFormation(Formation F)
	{
		FormationDAO.delete(F);
	}
	
	public Formation FindByCodeFormation(String id)
	{
		return  FormationDAO.findOne(id);
	}
	
	public List<Formation> FindbyNomFormation(String nom)
	{
		return Lists.newArrayList(FormationDAO.findBynomFormation(nom));
	}
	
	public Long CountFormations()
	{
		return FormationDAO.count();
	}

	@Override
	public void DeleteFormationParCode(String codeFormation) {
		FormationDAO.delete(codeFormation);		
	}

	@Override
	public void UpdateFormation(Formation F) {

		FormationDAO.save(F);
		
	}
}
