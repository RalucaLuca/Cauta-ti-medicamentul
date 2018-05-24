package ro.raluca.model;

public class MetodeFarmacie extends Farmacie {
	
	// Conexiunea cu DB
//		DB conex = DB.getInstance();
//		Connection con = conex.getConnection();

		// Afisare din DB
//		public void getDataFromFarmacie() throws SQLException {
//			Statement st = con.createStatement();
//			String query = "SELECT * FROM Farmacie";
//			ResultSet rs = st.executeQuery(query);
	//
//			System.out.println("Farmacie: ");
	//
//			while (rs.next()) {
//				id_farmacie = rs.getInt("id_farmacie");
//				CUI = rs.getInt("CUI");
//				nume = rs.getString("nume_farmacie");
//				site = rs.getString("site");
	//
//				System.out.println("id_farmacie: " + id_farmacie + " CUI: " + CUI + " Nume:  " + nume + "site:  " + site);
//			}
	//
//		}
		// Procedura Stocata
		/*
		 * public void SediileUneiFarmacii(String farmacie) throws SQLException {
		 * //Apelarea unei proceduri stocate - Afisarea sediilor unei farmacii alese
		 * CallableStatement cs =
		 * con.prepareCall("{call dbo.SediiFarmacieAleasa('catena')}"); ResultSet rs =
		 * cs.executeQuery();
		 * 
		 * System.out.println( "Sediile farmaciei " + farmacie + " sunt: ");
		 * 
		 * while (rs.next()) { System.out.println("Judetul: " + rs.getString("judet"));
		 * System.out.println("Adresa: " + rs.getString("adresa"));
		 * if(rs.getString("telefon")!=null) System.out.println("Numarul de telefon: 0"
		 * + rs.getString("telefon")); else System.out.println("Numarul de telefon: ");
		 * System.out.println(); } }
		 */



}
