package de.fu.mi.scuttle.domain.modulVW;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="modulverwaltung1_roles")
public class RolesEntity {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ro_id")
	@Id
	private long id;
	
	@Column(name="ro_name")
	private String name;
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="role")
	private UserRolesEntity userrole;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserRolesEntity getUserrole() {
		return userrole;
	}

	public void setUserrole(UserRolesEntity userrole) {
		this.userrole = userrole;
	}
	
}
