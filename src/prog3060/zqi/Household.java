package prog3060.zqi;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HOUSEHOLD", schema="APP")
public class Household {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private int id;

	@ManyToOne
	@JoinColumn(name="GEOGRAPHICAREA", nullable=false)
	private GeographicArea geographicArea;

	@ManyToOne
	@JoinColumn(name="CENSUSYEAR", nullable=false)
	private CensusYear censusYear;

	@ManyToOne
	@JoinColumn(name="HOUSEHOLDTYPE", nullable=false)
	private HouseholdType householdType;

	@ManyToOne
	@JoinColumn(name="HOUSEHOLDSIZE", nullable=false)
	private HouseholdSize householdSize;

	@ManyToOne
	@JoinColumn(name="HOUSEHOLDSBYAGERANGE", nullable=false)
	private HouseholdsByAgeRange householdsByAgeRange;

	@ManyToOne
	@JoinColumn(name="HOUSEHOLDEARNERS", nullable=false)
	private HouseholdEarners householdEarners;

	@ManyToOne
	@JoinColumn(name="TOTALINCOME", nullable=false)
	private TotalIncome totalIncome;

	@Column(name="NUMBERREPORTED", nullable=false)
	private int numberReported;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GeographicArea getGeographicArea() {
		return geographicArea;
	}

	public void setGeographicArea(GeographicArea geographicArea) {
		this.geographicArea = geographicArea;
	}

	public CensusYear getCensusYear() {
		return censusYear;
	}

	public void setCensusYear(CensusYear censusYear) {
		this.censusYear = censusYear;
	}

	public HouseholdType getHouseholdType() {
		return householdType;
	}

	public void setHouseholdType(HouseholdType householdType) {
		this.householdType = householdType;
	}

	public HouseholdSize getHouseholdSize() {
		return householdSize;
	}

	public void setHouseholdSize(HouseholdSize householdSize) {
		this.householdSize = householdSize;
	}


	public HouseholdEarners getHouseholdEarners() {
		return householdEarners;
	}

	public void setHouseholdEarners(HouseholdEarners householdEarners) {
		this.householdEarners = householdEarners;
	}

	public TotalIncome getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(TotalIncome totalIncome) {
		this.totalIncome = totalIncome;
	}

	public int getNumberReported() {
		return numberReported;
	}

	public void setNumberReported(int numberReported) {
		this.numberReported = numberReported;
	}

	public HouseholdsByAgeRange getHouseholdsByAgeRange() {
		return householdsByAgeRange;
	}

	public void setHouseholdsByAgeRange(HouseholdsByAgeRange householdsByAgeRange) {
		this.householdsByAgeRange = householdsByAgeRange;
	}
	
}
