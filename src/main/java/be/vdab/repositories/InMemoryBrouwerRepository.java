//package be.vdab.repositories;
//
//import be.vdab.entities.Brouwer;
//import be.vdab.valueobjects.Adres;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Repository
//public class InMemoryBrouwerRepository implements BrouwerRepository {
//
//	private final Map<Long, Brouwer> brouwers = new ConcurrentHashMap<>();
//
//	InMemoryBrouwerRepository() {
//		brouwers.put(1L, new Brouwer(1,"Brouwer1",100000, new Adres("Straat1", "HuisNr1",9000, "Gemeente8")));
//		brouwers.put(2L, new Brouwer(2,"Drouwer2",200000, new Adres("Straat2", "HuisNr100",9000, "Gemeente1")));
//		brouwers.put(3L, new Brouwer(3,"Frouwer3",300000, new Adres("Straat3", "HuisNr1",9000, "Gemeente1")));
//		brouwers.put(4L, new Brouwer(4,"Hrouwer4",400000, new Adres("Straat4", "HuisNr15",9010, "Gemeente7")));
//		brouwers.put(5L, new Brouwer(5,"Jrouwer5",500000, new Adres("Straat5", "HuisNr112",9000, "Gemeente1")));
//		brouwers.put(6L, new Brouwer(6,"Lrouwer6",600000, new Adres("Straat1", "HuisNr1",1000, "Gemeente1")));
//		brouwers.put(7L, new Brouwer(7,"Nrouwer7",700000, new Adres("Straat2", "HuisNr14",9000, "Gemeente1")));
//		brouwers.put(8L, new Brouwer(8,"Prouwer8",800000, new Adres("Straat3", "HuisNr1",3000, "Gemeente1")));
//		brouwers.put(9L, new Brouwer(9,"Rrouwer9",900000, new Adres("Straat4", "HuisNr1",2000, "Gemeente1")));
//		brouwers.put(10L, new Brouwer(10,"Trouwer10",1000000, new Adres("Straat5", "HuisNr1",9000, "Gemeente4")));
//	}
//
//	@Override
//	public void create(Brouwer brouwer) {
//		brouwer.setBrouwerNr(Collections.max(brouwers.keySet()) + 1);
//		brouwers.put(brouwer.getBrouwerNr(), brouwer);
//	}
//
//	@Override
//	public List<Brouwer> findAll() {
//		return new ArrayList<>(brouwers.values());
//	}
//
//	@Override
//	public List<Brouwer> findByNaam(String beginNaam) {
//		beginNaam = beginNaam.toUpperCase();
//		List<Brouwer> brouwersStartenMet = new ArrayList<>();
//		for (Map.Entry<Long, Brouwer> brouwerEntry : brouwers.entrySet()){
//			if (brouwerEntry.getValue().getNaam().toUpperCase().startsWith(beginNaam)){
//				brouwersStartenMet.add(brouwerEntry.getValue());
//			}
//		}
//		return brouwersStartenMet;
//	}
//}
