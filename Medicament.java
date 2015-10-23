// auteurs: Maud El-Hachem
// 2015
package drugware_v15;
//medicaments 1
public class Medicament {
	private String nomMolecule; // le nom de la mol�cule chimique active
	private String nomMarque; // le nom de la marque d�pos�e
	private String[] usages; // pour quels traitements
	private double[] dosesPossibles; // les formats possibles d'une dose
	private String unite; // l'unit� d'une dose (mg, g, etc.)
	private String[] interactions; // les mol�cules avec lesquelles peut
									// interagir ce m�dicament

	public Medicament() {
		this.nomMolecule = "";
		this.nomMarque = "";
		//TODO
		this.dosesPossibles = new double[8];
		this.unite = "";
	}

	/**
	 * @return the usages
	 */
	public String[] getUsages() {
		return usages;
	}

	/**
	 * @param usages
	 *            the usages to set
	 */
	public void setUsages(String[] usages) {
		this.usages = usages;
	}

	/**
	 * @return the nomMarque
	 */
	public String getNomMarque() {
		return nomMarque;
	}

	/**
	 * @param nomMarque
	 *            the nomMarque to set
	 */
	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	/**
	 * @return the nomMolecule
	 */
	public String getNomMolecule() {
		return nomMolecule;
	}

	/**
	 * @param nomMolecule
	 *            the nomMolecule to set
	 */
	public void setNomMolecule(String nomMolecule) {
		this.nomMolecule = nomMolecule;
	}

	/**
	 * @return the dosesPossibles
	 */
	public double[] getDosesPossibles() {
		return dosesPossibles;
	}

	/**
	 * @param dosesPossibles
	 *            the dosesPossibles to set
	 */
	public void setDosesPossibles(double[] dosesPossibles) {
		this.dosesPossibles = dosesPossibles;
	}

	/**
	 * @return the unite
	 */
	public String getUnite() {
		return unite;
	}

	/**
	 * @param unite
	 *            the unite to set
	 */
	public void setUnite(String unite) {
		this.unite = unite;
	}

	/**
	 * @return the interactions
	 */
	public String[] getInteractions() {
		return interactions;
	}

	/**
	 * @param interactions
	 *            the interactions to set
	 */
	public void setInteractions(String[] interactions) {
		this.interactions = interactions;
	}

}
