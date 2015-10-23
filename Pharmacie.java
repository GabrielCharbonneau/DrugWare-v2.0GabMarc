// auteurs: Maud El-Hachem
// 2015
package drugware_v15;
//pharmacie 3 erreurs
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Pharmacie {
	private List<Client> lesClients;
	private List<Medicament> lesMedicaments;
	
	

	public Pharmacie() {
		this.lesMedicaments = new ArrayList<>();
		this.lesClients = new ArrayList<>();
		//this.lesClients.add(new Client("1","",""));
	}

	/**
	 * @return the lesClients
	 */
	public List<Client> getLesClients() {
		return lesClients;
	}

	/**
	 * @param lesClients
	 *            the lesClients to set
	 */
	public void setLesClients(List<Client> lesClients) {
		this.lesClients = lesClients;
	}

	/**
	 * @return the lesMedicaments
	 */
	public List<Medicament> getLesMedicaments() {
		return lesMedicaments;
	}

	/**
	 * @param lesMedicaments
	 *            the lesMedicaments to set
	 */
	public void setLesMedicaments(List<Medicament> lesMedicaments) {
		this.lesMedicaments = lesMedicaments;
	}

	public void lireClients() {
		Fichiers fichier = new Fichiers();
		fichier.lireClients(lesClients);
	}

	public void lireMedicaments() {
		Fichiers fichier = new Fichiers();
		fichier.lireMedicaments(lesMedicaments);
	}

	public void lirePrescriptions() {
		Fichiers fichier = new Fichiers();
		fichier.lirePrescriptions(lesClients);
	}

	public boolean siClientExiste(String NAM) {
		for (Iterator<Client> it = lesClients.iterator(); it.hasNext();) {
			Client itClient = it.next();
			if (itClient.getNAM().equals(NAM)) {
				//TODO return false
				return true;
			}
		}
		return false;
	}

	public void ajouterClient(String NAM, String nom, String prenom) {
		this.lesClients.add(new Client(NAM, nom, prenom));
		
	}

	//TODO
	public List<Prescription> getPrescriptionsClient(String NAM) {
		for (Iterator<Client> it = lesClients.iterator(); it.hasNext();) {
//			if (it.next().getNAM().equals(NAM)) {
//				return it.next().getPrescriptions();
//			}
			//it.next() moves pointer to the next element
			//here it.next is called 2 times, so it is pointed at wrong element
			Client client = it.next();
			if (client.getNAM().equals(NAM)){
				return client.getPrescriptions();
			}
		}
		return null;
	}

	public boolean servirPrescription(String NAM, String medicament) {
		boolean delivree = false;
		for (Iterator<Client> it = lesClients.iterator(); it.hasNext();) {
			Client itClient = it.next();
			if (itClient.getNAM().equals(NAM)) {
				for (Iterator<Prescription> it2 = itClient.getPrescriptions().iterator(); it2.hasNext();) {
					Prescription courante = it2.next();
					if (courante.getMedicamentAPrendre().equalsIgnoreCase(
							medicament))
						//TODO
						//if(courante.getRenouvellemetns()>=1){
						if (courante.getRenouvellements() >= 0) {
							courante.setRenouvellements(courante
									.getRenouvellements() - 1);
							delivree = true;
						}
				}
			}
		}
		return delivree;
	}

	public boolean trouverInteraction(String medicament1, String medicament2) {
		
		for (Iterator<Medicament> it = lesMedicaments.iterator(); it.hasNext();) {
			Medicament courant = it.next();
			if (courant.getNomMolecule().equalsIgnoreCase(medicament1))
				for (int i = 0; i < courant.getInteractions().length; i++)
					if (courant.getInteractions()[i]
							.equalsIgnoreCase(medicament2))
						return true;
			if (courant.getNomMolecule().equalsIgnoreCase(medicament2))
				for (int i = 0; i < courant.getInteractions().length; i++)
					if (courant.getInteractions()[i]
							.equalsIgnoreCase(medicament2))
						return true;
		}
		//TODO
		//return true
		return false;
	}

	public void ecrireClients() {
		Fichiers fichier = new Fichiers();
		fichier.ecrireClients(lesClients);
	}

	public void ecrirePrescriptions() {
		Fichiers fichier = new Fichiers();
		fichier.lirePrescriptions(lesClients);
	}
}
