
package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

public class ManagerSpecie {

	private ArrayList<Specie> listEspecies;

	public ManagerSpecie() {
		listEspecies = new ArrayList<Specie>();
	}

	public List<String> getFamilies() {

		List<String> listFamily = new ArrayList<>();

		for (Specie especie : listEspecies) {
			boolean Exist = false;
			for (String string : listFamily) {
				if (especie.getFamiliaEspaecie().equals(string)) {
					Exist = true;
				}
			}

			if (Exist == false) {
				listFamily.add(especie.getFamiliaEspaecie());
			}
		}
		return listFamily;

	}

        public List<String> getAllFamilies(){
            List<String> listFamilies = new ArrayList<>();
            for (Specie listEspecy : listEspecies) {
                listFamilies.add(listEspecy.getFamiliaEspaecie());
            }
            
            return listFamilies;
        }
        
        public List<String> getAvalible(){
            List<String> listFamilies = new ArrayList<>();
            int counterAp = 0;
            int counterNo = 0;
            
            double porcent = listEspecies.size()/100;
            
            for (Specie listEspecy : listEspecies) {
                
                if(listEspecy.getCultivoCiudad() == true){
                    if(counterAp == porcent){
                        listFamilies.add("apta");
                        counterAp = 0;
                    }else{
                        counterAp++;
                    }
                }else{
                    if(counterNo == porcent){
                        listFamilies.add("no apta");
                        counterNo = 0;
                    }else{
                        counterNo++;
                    }
                }
                
            }
            listFamilies.add("apta");
            
            listFamilies.add("no apta");
            return listFamilies;
        }
        
	public ArrayList<Specie> getListEspecies() {
		return listEspecies;
	}

	public void addEspecie(Specie especie) {
		listEspecies.add(especie);
	}

	public ArrayList<Specie> superSearch(String paisSearch, Boolean aptoCiudad, String familia) {
		ArrayList<Specie> listFinded = new ArrayList<>();

		Map<String, String> countries = new HashMap<>();
		for (String iso : Locale.getISOCountries()) {
			Locale countri = new Locale("", iso);
			countries.put(countri.getDisplayCountry(), iso);
		}

		for (Specie especie : listEspecies) {
			if (especie.getFamiliaEspaecie().equals(familia)) {
				listFinded.add(especie);
				if (especie.getCultivoCiudad() == aptoCiudad) {
					listFinded.add(especie);
					for (String pais : especie.getContriesList()) {

						if (pais.equals(paisSearch)) {
							listFinded.add(especie);
						}
					}
					if (especie.getCultivoCiudad() == aptoCiudad) {
						listFinded.add(especie);
					}
				}
			}
		}
		return listFinded;
	}

	public ArrayList<Specie> filterCountry(String country) {
		ArrayList<Specie> listFinded = new ArrayList<>();

		Map<String, String> countries = new HashMap<>();
		for (String iso : Locale.getISOCountries()) {
			Locale countri = new Locale("", iso);
			countries.put(countri.getDisplayCountry(), iso);
		}

		for (Specie especie : listEspecies) {
			for (String pais : especie.getContriesList()) {

				if (pais.equals(country)) {
					listFinded.add(especie);
				}
			}
		}
		return listFinded;
	}

	public ArrayList<Specie> filterSuitable(Boolean suitbale) {
		ArrayList<Specie> listFinded = new ArrayList<>();
		for (Specie especie : listEspecies) {

			if (especie.getCultivoCiudad() == suitbale) {
				listFinded.add(especie);
			}
		}

		return listFinded;
	}
	
	
	public ArrayList<Specie> filterByFamily(String family) {
		ArrayList<Specie> listFinded = new ArrayList<>();
		for (Specie especie : listEspecies) {

			if (especie.getFamiliaEspaecie().equals(family)) {
				listFinded.add(especie);
			}
		}

		return listFinded;
	}

	public List<String> getListConties() {

		List<String> listCountries = new ArrayList<>();

		Map<String, String> countries = new HashMap<>();
		for (String iso : Locale.getISOCountries()) {
			Locale countri = new Locale("", iso);
			countries.put(countri.getDisplayCountry(), iso);
			listCountries.add(countri.getDisplayCountry());
		}
		//
		System.out.println(countries.get("Colombia"));
		// System.out.println(countries.get(this));
		// System.out.println(countries.get("Bolivia"));
		// Locale l = new Locale("", "CO");
		// System.out.println(l.getDisplayCountry());

		return listCountries;

	}

	public ArrayList<Specie> findByWord(String keyword) {
		ArrayList<Specie> listFinded = new ArrayList<>();
		for (Specie especie : listFinded) {
			if (especie.getNombreCientifico().contains(keyword)) {
				listFinded.add(especie);
			}
		}
		return listFinded;
	}

	public ArrayList<Specie> findByFamilia(String keyword) {
		ArrayList<Specie> listFinded = new ArrayList<>();
		for (Specie especie : listFinded) {
			if (especie.getFamiliaEspaecie().contains(keyword)) {
				listFinded.add(especie);
			}
		}
		return listFinded;
	}

	public ArrayList<Specie> findByCountry(String keyword) {
		ArrayList<Specie> listFinded = new ArrayList<>();
		for (Specie especie : listFinded) {
			for (String pais : especie.getContriesList()) {
				if (pais == keyword) {
					listFinded.add(especie);
				}
			}
		}
		return listFinded;
	}

	public ArrayList<Specie> findIfCity(boolean city) {
		ArrayList<Specie> listFinded = new ArrayList<>();
		for (Specie especie : listFinded) {
			if (especie.getCultivoCiudad() == city) {
				listFinded.add(especie);
			}
		}
		return listFinded;
	}

	public void setListEspecies(ArrayList<JsonObject> listObj) {
		for (JsonObject listEspecy : listObj) {
			listEspecies.add(assembleEspecie(listEspecy));
		}
	}

	public Specie assembleEspecie(JsonObject spe) {
		Specie makingSpecie = null;

		String familiaEspaecie = (String) spe.get("family_name");
		String nombreCientifico = (String) spe.get("full_name");
		String reinoEspecie = (String) spe.get("kingdom_name");
		String notaInformativa = (String) spe.get("full_note");
		boolean acceptedCities = (boolean) spe.get("cites_accepted");
		List<String> contriesList = new ArrayList<>();
		// *** por si se borra el archivo de plantas y haya que leer el archivo grande
		// otra vez se descomentarea esto
		// JsonArray listChanges = (JsonArray)spe.get("current_listing_changes");
		// Iterator<Object> interatorChages = listChanges.iterator();
		// while (interatorChages.hasNext()) {
		// JsonObject change = (JsonObject)interatorChages.next();
		// notaInformativa =(String)change.get("hash_full_note");
		// }
		JsonArray listCountriJson = (JsonArray) spe.get("countries_iso_codes");
		Iterator<Object> interatorCountry = listCountriJson.iterator();
		while (interatorCountry.hasNext()) {
			contriesList.add((String) interatorCountry.next());
		}
		makingSpecie = new Specie(familiaEspaecie, nombreCientifico, reinoEspecie, notaInformativa, contriesList,
				acceptedCities);
		return makingSpecie;
	}

	public static Specie createEspecie(String nameEspecie, String familiaEspaecie, String nombreCientifico,
			String reinoEspecie, String notaInformativa, List<String> contriesList, Boolean cultivoCiudad) {
		return new Specie(familiaEspaecie, nombreCientifico, reinoEspecie, notaInformativa, contriesList,
				cultivoCiudad);
	}

	public Specie findById(int idEspecie) {

		for (Specie especie : listEspecies) {
			if (especie.getIdEspecie() == idEspecie) {
				return especie;
			}
		}
		return null;
	}

}
