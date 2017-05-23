package Algorithmus;

import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import Data.Mont_OP;
import Data.Projekte;
import Data.Used_auspr;

public class Eignungsgrade {
	private static ArrayList<Mont_OP> Mont_OParray;
	private static Mont_OP retMont_OP;
	public ArrayList<Used_auspr> Used_ausprArray;

	Eignungsgrade(){
		Mont_OParray =sql_connector.Mont_OPSQL.get_lastMontOP();
		retMont_OP=Mont_OParray.get(0);
		ArrayList<Used_auspr> Used_ausprArray= sql_connector.Used_AuspSQL.giveRelevant(retMont_OP.idmontOP);

		Object[] RatingFM = new Object[Used_ausprArray.size()];
		Object[] RatingFR = new Object[Used_ausprArray.size()];
		for (Used_auspr ap1 : Used_ausprArray)
		{
			RatingFM[0]=ap1.ratingFM;
			RatingFR[0]=ap1.ratingFR;

		}
		System.out.println(RatingFM);
	}

	public static void main(String[] args) {

		Mont_OParray =sql_connector.Mont_OPSQL.get_lastMontOP();
		retMont_OP=Mont_OParray.get(3);
		ArrayList<Used_auspr> Used_ausprArray= sql_connector.Used_AuspSQL.giveRelevant(retMont_OP.idmontOP);


		double sumRatingFM =0.0;
		double sumRatingFR =0.0;
		int[] myIntArray = new int[Used_ausprArray.size()];
		int num[] = {5, 4, 3, 2};
		for(int i = 0; i < Used_ausprArray.size(); i++) {
			Used_auspr retUsed_auspr=Used_ausprArray.get(i);
			 System.out.println("RatingFM"+(i+1)+": "+retUsed_auspr.ratingFM);
			//System.out.println("RatingFR"+(i+1)+": "+retUsed_auspr.ratingFR);
			// System.out.println("Test: "+test);
			 
			 int t=0;
			 t=t+num[i];
			sumRatingFM = sumRatingFM+(retUsed_auspr.ratingFM)/Used_ausprArray.size();
			sumRatingFR = sumRatingFR+retUsed_auspr.ratingFR/Used_ausprArray.size();
		}

		System.out.println("sumRatingFM: "+sumRatingFM);
		System.out.println("sumRatingFR: "+sumRatingFR);
		
		
		
		double test = sumRatingFM*100;
		double test1 = sumRatingFR*100;
		int h =(int) test;
		int h1 =(int) test1;
		
		Math.round(test);
		System.out.println("test: "+test);
		System.out.println("test1: "+Math.round(test));
		System.out.println("test2: "+(100-Math.round(test)));
		
		
		Object[] RatingFM = new Object[Used_ausprArray.size()];
		Object[] RatingFR = new Object[Used_ausprArray.size()];
		for (Used_auspr ap1 : Used_ausprArray)
		{
			RatingFM[0]=ap1.ratingFM;
			RatingFR[0]=ap1.ratingFR;

		}
		//	System.out.println(RatingFM);



	}

}
