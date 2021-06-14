package ResetThosePacks;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="testMe")
public class TestMyDB {
		
		@Id
		@GeneratedValue
		public int idT;
		public String NomT;
		public boolean DoneT;
		
		public String toString() {
			//return String.format("%d - %s", idC, NomC);
			if (this.DoneT) {
				String strf = this.idT +" - " +this.NomT +" - Effectué";
				return strf;
			}
			else {
				String strf = this.idT +" - " +this.NomT +" - Pas encore effectué";
				return strf;
			}
			//return String.format("%d - %s", idC, NomC);
		}
		
		//public Date date_naissance;
	    // you can also use getters and setters
}
