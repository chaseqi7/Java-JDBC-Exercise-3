package prog3060.zqi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Exercise3Application {

    static final String PERSISTENCE_UNIT_NAME = "Exercise3JPAApplication";
    static final int HOUSEHOLD_ID = 5;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory tempEntityManagerFactory = null;
        EntityManager tempEntityManager = null;

        try
        {

            tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            tempEntityManager = tempEntityManagerFactory.createEntityManager();

            tempEntityManager.getTransaction().begin();

// Retrieve a Team object from the database using its key
            Household tempHousehold = tempEntityManager.find(Household.class, HOUSEHOLD_ID);
            
            String tempSelectJPQLQuery = "FROM Household hh "
            		+ "JOIN hh.geographicArea ga "
            		+ "JOIN hh.censusYear cy "
            		+ "JOIN hh.householdType hht "
            		+ "JOIN hh.householdSize hhs "
            		+ "JOIN hh.householdsByAgeRange hhb "
            		+ "JOIN hh.householdEarners hhe "
            		+ "JOIN hh.totalIncome ti "
                    + "WHERE ga.alternativeCode = :alternativeCode "
                    + "AND cy.censusYear= :censusYear "
                    + "AND hht.description= :hhtDescription "
                    + "AND hhs.description= :hhsDescription "
                    + "AND hhb.description= :hhbDescription "
                    + "AND hhe.description= :hheDescription "
                    + "AND ti.description= :tiDescription";
            
            
            GeographicArea tempGA=new GeographicArea();
            tempGA.setAlternativeCode(70);
            tempGA.setCode(70);
            tempGA.setLevel(1);
            tempGA.setName("Puzzles");
            
            tempEntityManager.persist(tempGA);
            
            
            
            Household temphh=new Household();
            temphh.setGeographicArea(tempGA);
            temphh.setCensusYear(tempEntityManager.find(CensusYear.class, 1));
            temphh.setHouseholdType(tempEntityManager.find(HouseholdType.class, 11));
            temphh.setHouseholdSize(tempEntityManager.find(HouseholdSize.class, 3));
            temphh.setHouseholdsByAgeRange(tempEntityManager.find(HouseholdsByAgeRange.class, 7));
            temphh.setHouseholdEarners(tempEntityManager.find(HouseholdEarners.class, 3));
            temphh.setTotalIncome(tempEntityManager.find(TotalIncome.class, 14));
            temphh.setNumberReported(25);

            tempEntityManager.persist(temphh);
            

            Query tempQuery = tempEntityManager.createQuery(tempSelectJPQLQuery);
            tempQuery.setParameter("alternativeCode",temphh.getGeographicArea().getAlternativeCode())
            .setParameter("censusYear",temphh.getCensusYear().getCensusYear())
            .setParameter("hhtDescription",temphh.getHouseholdType().getDescription())
            .setParameter("hhsDescription",temphh.getHouseholdSize().getDescription())
            .setParameter("hhbDescription",temphh.getHouseholdsByAgeRange().getDescription())
            .setParameter("hheDescription",temphh.getHouseholdEarners().getDescription())
            .setParameter("tiDescription",temphh.getTotalIncome().getDescription());

            List<Object[]> tempResultList = tempQuery.getResultList();
            

            System.out.println("Begin Report.");

            List <String> tempOutputTable = new ArrayList <String>();

            tempOutputTable.add(String.format("%-15s", "Census Year")
                    + String.format("%-10s", "GA Name")
                    + String.format("%-10s", "GA Code")
                    + String.format("%-10s", "GA Level")
                    + String.format("%-10s", "GA Alt")
                    + String.format("%-10s", "Number"));

            Iterator <Object[]> tempResultListIterator = tempResultList.iterator();
            
            while (tempResultListIterator.hasNext())
            {
            	Object[] tempResultSet = tempResultListIterator.next();
            	Household tempRetrievedHousehold=(Household) tempResultSet[0];

            	tempOutputTable.add(String.format("%-15s", tempRetrievedHousehold.getCensusYear().getCensusYear())
                        + String.format("%-10s", tempRetrievedHousehold.getGeographicArea().getName())
                        + String.format("%-10s", tempRetrievedHousehold.getGeographicArea().getCode())
                        + String.format("%-10s", tempRetrievedHousehold.getGeographicArea().getLevel())
                        + String.format("%-10s", tempRetrievedHousehold.getGeographicArea().getAlternativeCode())
                        + String.format("%-10s", tempRetrievedHousehold.getNumberReported()));
            }
            

            PrintOutput("CanadaCensusDB", tempOutputTable);
            System.out.println("Report done.");
            
            tempEntityManager.getTransaction().rollback();
        }
        catch (Exception e)
        {
        	tempEntityManager.getTransaction().rollback();
            if (tempEntityManager != null)
            {

                tempEntityManager.getTransaction().rollback();

            }

            e.printStackTrace();

        }
        finally
        {

            if (tempEntityManager != null)
            {

                tempEntityManager.close();

            }

            if (tempEntityManagerFactory != null)
            {

                tempEntityManagerFactory.close();

            }

        }

    }

    private static void PrintOutput(String tempOutputTableTitle, List <String> tempOutputTable)
    {

        System.out.println("******************************************************************************************");
        System.out.println();
        System.out.println(tempOutputTableTitle);
        System.out.println();

        for (String tempOutputTableElement : tempOutputTable)
        {

            System.out.println(tempOutputTableElement);

        }

        System.out.println();
        System.out.println("******************************************************************************************");

	}

}
