package prog3060.zqi;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GEOGRAPHICAREA", schema="APP")
public class GeographicArea {

	@OneToMany(mappedBy="geographicArea")
	private Set<Age> Ages= new HashSet<Age>();

	@OneToMany(mappedBy="geographicArea")
	private Set<Household> Households= new HashSet<Household>();
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GEOGRAPHICAREAID", nullable=false)
	private int geographicAreaID;

	@Column(name="CODE", nullable=false)
	private int code;

	@Column(name="LEVEL", nullable=false)
	private int level;

	@Column(name="NAME", nullable=false)
	private String name;

	@Column(name="ALTERNATIVECODE", nullable=false)
	private int alternativeCode;

	public int getGeographicAreaID() {
		return geographicAreaID;
	}

	public void setGeographicAreaID(int geographicAreaID) {
		this.geographicAreaID = geographicAreaID;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAlternativeCode() {
		return alternativeCode;
	}

	public void setAlternativeCode(int alternativeCode) {
		this.alternativeCode = alternativeCode;
	}
}
