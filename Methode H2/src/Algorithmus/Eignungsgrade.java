package Algorithmus;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

//import com.mysql.fabric.xmlrpc.base.Array;

import Data.Mont_OP;
//import Data.Projekte;
import Data.Used_auspr;

public class Eignungsgrade {
	private static ArrayList<Mont_OP> Mont_OParray;
	private static Mont_OP retMont_OP;
	public ArrayList<Used_auspr> Used_ausprArray;
	public BigDecimal[] RatingFM;
	public BigDecimal[] RatingFR;

	public Eignungsgrade(int projektID){
		
		Mont_OParray=sql_connector.Mont_OPSQL.get_MontOPzuProjekt(projektID);
		RatingFM = new BigDecimal[Mont_OParray.size()];
		RatingFR = new BigDecimal[Mont_OParray.size()];
		for(int i=0; i< Mont_OParray.size();i++){
			BigDecimal sum_Gewichtung=new BigDecimal(0.0);
			RatingFM[i]=new BigDecimal(0.0);
			RatingFR[i]=new BigDecimal(0.0);
			retMont_OP=Mont_OParray.get(i);
			ArrayList<Used_auspr> Used_ausprArray= sql_connector.Used_AuspSQL.giveRelevant(retMont_OP.idmontOP);
			if(Used_ausprArray.size()==0){
				
			}
			else{
				for (Used_auspr ap : Used_ausprArray)
				{
					RatingFM[i]=RatingFM[i].add(new BigDecimal(ap.ratingFM * ap.gewichtung));
					RatingFR[i]=RatingFR[i].add(new BigDecimal(ap.ratingFR * ap.gewichtung));
					sum_Gewichtung=sum_Gewichtung.add(new BigDecimal(ap.gewichtung));
				}
				RatingFM[i]=RatingFM[i].divide(sum_Gewichtung, 2, RoundingMode.HALF_UP);
				RatingFR[i]=RatingFR[i].divide(sum_Gewichtung, 2, RoundingMode.HALF_UP);

				

				System.out.println("RatingFM: "+RatingFM[i]);
				System.out.println("RatingFR: "+RatingFR[i]);

			}
		}
	}
	public static void main(String[] args) {
	


	}

}
