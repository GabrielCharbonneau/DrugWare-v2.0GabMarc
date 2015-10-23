package drugware_v15;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.rules.TestName;

public class PharmacieTest {
	@Rule public TestName name = new TestName();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println( "Début du test - " +getClass()+  " -  "  + name.getMethodName() );
	}

	@After
	public void tearDown() throws Exception {
		System.out.println( "Fin du test - " +getClass()+  " -  "  + name.getMethodName());
	}

	@Test
	public void testPharmacie() {
		//fail("Not yet implemented");
		//System.out.println( "Début du test - PharmacieTest - testPharmacie ");
		Pharmacie pharmacie = new Pharmacie();
		assertNotNull("List medicament null", pharmacie.getLesMedicaments());
		assertEquals("Size medicament not 0 ",0,pharmacie.getLesMedicaments().size());
		
		assertNotNull("List client null", pharmacie.getLesClients());
		assertEquals("Size client not 0 ",0,pharmacie.getLesClients().size());
		
		//System.out.println( "Fin du test - PharmacieTest - testPharmacie ");

	}

	@Test
	public void testGetLesClients() {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testGetLesClients ");
		
		Pharmacie pharmacie = new Pharmacie();
		List<Client> lesClients = new ArrayList<Client>();
		pharmacie.setLesClients(lesClients);
		pharmacie.getLesClients();
		assertEquals("list lesClients past to set", lesClients,pharmacie.getLesClients() );
		
		//System.out.println( "Fin du test - PharmacieTest - testGetLesClients ");
	}

	@Test
	public void testSetLesClients() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testSetLesClients ");
		
		Pharmacie pharmacie = new Pharmacie();
		List<Client> lesClients = new ArrayList<Client>();
		pharmacie.setLesClients(lesClients);
		
		final Field field = pharmacie.getClass().getDeclaredField("lesClients");
	    field.setAccessible(true);

		assertEquals("Les clients set", field.get(pharmacie), lesClients );
		
		//System.out.println( "Fin du test - PharmacieTest - testSetLesClients ");
	}

	@Test
	public void testGetLesMedicaments() {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testGetLesMedicaments ");
		
		Pharmacie pharmacie = new Pharmacie();
		List<Medicament> lesMedicaments = new ArrayList<Medicament>();
		pharmacie.setLesMedicaments(lesMedicaments);
		pharmacie.getLesMedicaments();
		assertEquals("list Medicaments past to set",lesMedicaments, pharmacie.getLesMedicaments());
		
		//System.out.println( "Fin du test - PharmacieTest - testGetLesMedicaments ");
	}

	@Test
	public void testSetLesMedicaments() {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testSetLesMedicaments ");
		
		Pharmacie pharmacie = new Pharmacie();
		List<Medicament> lesMedicaments = new ArrayList<Medicament>();
		pharmacie.setLesMedicaments(lesMedicaments);
		pharmacie.getLesMedicaments();
		assertEquals("list Medicaments past to set",lesMedicaments, pharmacie.getLesMedicaments());
		
		//System.out.println( "Fin du test - PharmacieTest - testSetLesMedicaments ");
	}

	@Test
	public void testLireClients() {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testLireClients ");
		
		try{
			Pharmacie pharmacie = new Pharmacie();
			pharmacie.lireClients();
		}catch(Exception e){
			fail();
		}
		
		//System.out.println( "Fin du test - PharmacieTest - testLireClients ");
	}

	@Test
	public void testLireMedicaments() {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testLireMedicaments ");
		try{
			Pharmacie pharmacie = new Pharmacie();
			pharmacie.lireMedicaments();
		}catch(Exception e){
			fail();
		}
		//System.out.println( "Fin du test - PharmacieTest - testLireMedicaments ");
	}

	@Test
	public void testLirePrescriptions() {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testLirePrescriptions ");
		try{
			Pharmacie pharmacie = new Pharmacie();
			pharmacie.lirePrescriptions();
		}catch(Exception e){
			fail();
		}
		//System.out.println( "Fin du test - PharmacieTest - testLirePrescriptions ");
	}

	@Test
	public void testSiClientExiste() {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testSiClientExiste ");
		
		PharmacieStub pharmacie = new PharmacieStub();
		pharmacie.lireClients();
		String NAM ="ELHM12345678";
		assertEquals("NAM existe", true, pharmacie.siClientExiste(NAM));
		assertEquals("NAM existe", false, pharmacie.siClientExiste("a"));
		
		//System.out.println( "Fin du test - PharmacieTest - testSiClientExiste ");
	}
	
	static class PharmacieStub extends Pharmacie{
		
		 public void lireClients(){
			 getLesClients().add(new Client("ELHM12345678", "ElHachem", "Maud" ));
		 }
		 
		 public void lirePrescription(){
			 for (Client client : getLesClients()){
				 client.getPrescriptions().add(new Prescription("Botox", 50.0, 0 ));
			 }
		 }
		 
		 public void lireMedicaments(){
//			 Nexium
//			 ésoméprazole
//			 traiter les symptômes de RGO;soigner les brûlures d'estomac;traiter les ulcères d'estomac;
//			 20;40;
//			 mg
//			 clopidogrel;dabigatran;ifosfamide;
			 
			 Medicament medicament = new Medicament();
			 medicament.setNomMarque("Nexium");
			 medicament.setDosesPossibles(new double[]{20,40});
			 medicament.setNomMolecule("ésoméprazole");
			 medicament.setUnite("mg");
			 medicament.setUsages("traiter les symptômes de RGO;soigner les brûlures d'estomac;traiter les ulcères d'estomac".split(";"));
			medicament.setInteractions("clopidogrel;dabigatran;ifosfamide".split(";"));
			 getLesMedicaments().add(medicament);
			 
//			 Plavix
//			 clopidogrel
//			 prévenir les crises cardiaques, les accidents vasculaires cérébraux et certains autres problèmes circulatoires chez les personnes atteintes d'athérosclérose;
//			 75;300;
//			 mg
//			 fluvoxamine;ibuprofène;naproxène;gemfibrozil;
			 
			 Medicament medicament2 = new Medicament();
			 medicament2.setNomMarque("Plavix");
			 medicament2.setDosesPossibles(new double[]{20,40});
			 medicament2.setNomMolecule("clopidogrel");
			 medicament2.setUnite("mg");
			 medicament2.setUsages("prévenir les crises cardiaques, les accidents vasculaires cérébraux et certains autres problèmes circulatoires chez les personnes atteintes d'athérosclérose".split(";"));
			medicament2.setInteractions("fluvoxamine;ibuprofène;naproxène;gemfibrozil;".split(";"));
			 getLesMedicaments().add(medicament2);
			
		 }
	}

	@Test
	public void testAjouterClient() {
		//("Not yet implemented");
		

		//System.out.println( "Début du test - PharmacieTest - testAjouterClient ");
		
		Pharmacie pharmacie = new Pharmacie();
		pharmacie.getLesClients().add(new Client("VLAD","VLAD","VLAD"));
		pharmacie.ajouterClient("VLADDD","VLADD","VLADD");
		assertEquals("Ajouter Client",pharmacie.getLesClients().size(),2);
		assertEquals("Ajouter Client", pharmacie.siClientExiste("VLADDD") , true);
		
		//System.out.println( "Fin du test - PharmacieTest - testAjouterClient ");
	}

	@Test
	public void testGetPrescriptionsClient() {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testGetPrescriptionsClient ");
		String NAM = "ELHM12345678";
		PharmacieStub pharmacie = new PharmacieStub();
		pharmacie.lireClients();
		pharmacie.lirePrescription();
		//assertEquals("Prescription", "ELHM12345678" , pharmacie.getPrescriptionsClient(NAM));
		assertEquals("Prescription", 1 , pharmacie.getPrescriptionsClient(NAM).size());
		
		Prescription prescription = pharmacie.getPrescriptionsClient(NAM).get(0);
		assertEquals("Prescription", "Botox" , prescription.getMedicamentAPrendre());
		assertEquals("Prescription", new Double(50.0) , (Double)prescription.getDose());
		assertEquals("Prescription", 0 , prescription.getRenouvellements());

		
		//System.out.println( "Fin du test - PharmacieTest - testGetPrescriptionsClient ");
	}

	@Test
	public void testServirPrescription() {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testServirPrescription ");
		
		String NAM ="ELHM12345678";
		String medicament="Botox";
		PharmacieStub pharmacie = new PharmacieStub();
		pharmacie.lireClients();
		pharmacie.lirePrescription();
		
		assertEquals("Servir Prescription", true , pharmacie.servirPrescription(NAM, medicament));
		
		//System.out.println( "Fin du test - PharmacieTest - testServirPrescription ");
	}

	@Test
	public void testTrouverInteraction() {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testTrouverInteraction ");
		
		PharmacieStub pharmacie = new PharmacieStub();
		pharmacie.lireMedicaments();
		assertTrue(pharmacie.trouverInteraction("ésoméprazole", "clopidogrel"));
		assertTrue(pharmacie.trouverInteraction("clopidogrel", "fluvoxamine"));
		//System.out.println( "Fin du test - PharmacieTest - testTrouverInteraction ");
	}

	@Test
	public void testEcrireClients() {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testEcrireClients ");
		
		//System.out.println( "Fin du test - PharmacieTest - testEcrireClients ");
	}

	@Test
	public void testEcrirePrescriptions() {
		//fail("Not yet implemented");
		
		//System.out.println( "Début du test - PharmacieTest - testEcrirePrescriptions ");
		
		//System.out.println( "Fin du test - PharmacieTest - testEcrirePrescriptions ");
	}

}
